package xyz.cavalheiro.curriculo.service;

import xyz.cavalheiro.curriculo.dao.ContatoDAO;
import xyz.cavalheiro.curriculo.domain.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContatoImplService implements ContatoService {

    @Autowired
    private ContatoDAO dao;

    @Override
    public void save(Contato contato) {
        dao.save(contato);
    }

    @Override
    public void update(Contato contato) {
        dao.update(contato);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contato> listAll() {
        return dao.listAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Contato listId(long id) {
        return dao.listId(id);
    }
}
