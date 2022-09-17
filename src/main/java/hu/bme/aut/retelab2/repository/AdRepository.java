package hu.bme.aut.retelab2.repository;

import hu.bme.aut.retelab2.domain.Ad;
import hu.bme.aut.retelab2.domain.Note;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AdRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Ad save(Ad adData) {
        return em.merge(adData);
    }

    public List<Ad> findByPriceRange(Integer minPrice, Integer maxPrice) {
        //TODO: SQL should be written
        System.out.println("minimum ertek: "+minPrice+" maximum ertek: "+maxPrice);
        return em.createQuery("SELECT n FROM Ad n WHERE n.price BETWEEN ?1 AND ?2", Ad.class).setParameter(1, minPrice).setParameter(2,maxPrice).getResultList();
    }
}
