package xyz.cavalheiro.curriculo.dao;

import org.springframework.stereotype.Repository;
import xyz.cavalheiro.curriculo.domain.Contato;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContatoImplDAO implements ContatoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Contato contato) {
        em.persist(contato);
    }

    @Override
    public void update(Contato contato) {
        em.merge(contato);
    }

    @Override
    public void delete(long id) {
        em.remove(em.getReference(Contato.class, id));
    }

    @Override
    public List<Contato> listAll() {
        return em.createQuery("select c from Contato c ",Contato.class).getResultList();
    }

    @Override
    public Contato listId(long id) {
        return em.find(Contato.class,id);
    }
}
