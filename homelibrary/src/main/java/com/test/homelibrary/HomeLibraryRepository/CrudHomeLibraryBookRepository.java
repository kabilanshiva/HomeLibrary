package com.test.homelibrary.HomeLibraryRepository;

import com.test.homelibrary.HomeLibraryEntity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrudHomeLibraryBookRepository extends CrudRepository<BookEntity, Integer> {
}
