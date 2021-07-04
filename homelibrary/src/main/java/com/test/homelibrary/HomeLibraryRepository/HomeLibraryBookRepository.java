package com.test.homelibrary.HomeLibraryRepository;

import com.test.homelibrary.HomeLibraryEntity.BookEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class HomeLibraryBookRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<BookEntity> getAvailableBooks(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> cr = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = cr.from(BookEntity.class);
        cr.select(root).where(cb.equal(root.get("inTheShelf"),true));

        return entityManager.createQuery(cr).getResultList();
    }
}
