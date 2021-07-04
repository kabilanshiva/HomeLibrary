package com.test.homelibrary.HomeLibraryService;

import com.test.homelibrary.HomeLibraryEntity.BookEntity;
import com.test.homelibrary.HomeLibraryEntity.SlotEntity;

import java.util.List;

public interface HomeLibraryService {

    public List<BookEntity> getAllBooks();
    public List<BookEntity> getAvailableBooks();
    public BookEntity getById(Integer id);
    public BookEntity addNewBook(BookEntity bookEntity);
    public SlotEntity getAvailableSlot();
    public BookEntity takeBook(Integer id);

}
