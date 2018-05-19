package xyz.cavalheiro.curriculo.controller;

import xyz.cavalheiro.curriculo.domain.Contato;
import xyz.cavalheiro.curriculo.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("contatos")
public class ContatoController {

	 @GetMapping("/login")
	   public String login() {
	        return "/restrito/login";
	    }
	@Autowired
	private ContatoService contatoService;

	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		model.addAttribute("contatos", contatoService.listAll());
		return new ModelAndView("/contato/list", model);
	}

	@GetMapping("/cadastro")
	public String preSalvar(@ModelAttribute("contato") Contato contato) {
		return "/contato/add";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("contato") Contato contato, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/contato/add";
		}

		contatoService.save(contato);
		attr.addFlashAttribute("mensagem", "Contato enviado com sucesso.");
		return "redirect:/contatos/cadastro";
	}

	@GetMapping("/{id}/atualizar")
	public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
		Contato contato = contatoService.listId(id);
		model.addAttribute("contato", contato);
		return new ModelAndView("/contato/add", model);
	}

	@PutMapping("/salvar")
	public String atualizar(@Valid @ModelAttribute("contato") Contato contato, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/contato/add";
		}

		contatoService.update(contato);
		attr.addFlashAttribute("mensagem", "Contato atualizado com sucesso.");
		return "redirect:/contatos/listar";
	}

	@GetMapping("/{id}/remover")
	public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
		contatoService.delete(id);
		attr.addFlashAttribute("mensagem", "Contato removido com sucesso.");
		return "redirect:/contatos/listar";
	}

}
