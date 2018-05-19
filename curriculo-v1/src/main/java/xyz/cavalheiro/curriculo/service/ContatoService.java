package xyz.cavalheiro.curriculo.service;

import xyz.cavalheiro.curriculo.domain.Contato;

import java.util.List;

public interface ContatoService {

    void save(Contato contato);
    void update(Contato contato);
    void delete(long id);
    List<Contato> listAll();
    Contato listId(long id);
}
