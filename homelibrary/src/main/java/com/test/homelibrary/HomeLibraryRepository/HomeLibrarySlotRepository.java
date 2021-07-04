package com.test.homelibrary.HomeLibraryRepository;

import com.test.homelibrary.HomeLibraryEntity.SlotEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

@Repository
public class HomeLibrarySlotRepository{

    @PersistenceContext
    EntityManager entityManager;

    public SlotEntity getFreeSlot() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SlotEntity> cr = cb.createQuery(SlotEntity.class);
        Subquery<Integer> sq = cr.subquery(Integer.class);
        Root<SlotEntity> root = cr.from(SlotEntity.class);
        Root<SlotEntity> subRoot = sq.from(SlotEntity.class);
        cr.select(root)
                .where(cb.equal(root.get("id")
                        ,sq.select(cb.min(subRoot.get("id")))
                                .where(cb.equal(subRoot.get("isAvailable"),true))));
        return entityManager.createQuery(cr).getSingleResult();
    }
}


