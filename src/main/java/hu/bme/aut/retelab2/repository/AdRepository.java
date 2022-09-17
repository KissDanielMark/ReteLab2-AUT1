package hu.bme.aut.retelab2.repository;

import hu.bme.aut.retelab2.domain.Ad;
import hu.bme.aut.retelab2.domain.Note;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AdRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Ad save(Ad adData) {
        return em.merge(adData);
    }

}
