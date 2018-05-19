package xyz.cavalheiro.curriculo.dao;

import xyz.cavalheiro.curriculo.domain.Contato;

import java.util.List;

public interface ContatoDAO {
    void save(Contato contato);
    void update(Contato contato);
    void delete(long id);
    List<Contato> listAll();
    Contato listId(long id);
}
