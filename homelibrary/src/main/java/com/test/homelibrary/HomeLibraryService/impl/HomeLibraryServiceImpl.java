package com.test.homelibrary.HomeLibraryService.impl;

import com.test.homelibrary.HomeLibraryEntity.BookEntity;
import com.test.homelibrary.HomeLibraryEntity.SlotEntity;
import com.test.homelibrary.HomeLibraryRepository.CrudHomeLibraryBookRepository;
import com.test.homelibrary.HomeLibraryRepository.CrudHomeLibrarySlotRepository;
import com.test.homelibrary.HomeLibraryRepository.HomeLibraryBookRepository;
import com.test.homelibrary.HomeLibraryRepository.HomeLibrarySlotRepository;
import com.test.homelibrary.HomeLibraryService.HomeLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HomeLibraryServiceImpl implements HomeLibraryService {

    @Autowired
    CrudHomeLibraryBookRepository crudHomeLibraryBookRepository;

    @Autowired
    HomeLibrarySlotRepository homeLibrarySlotRepository;

    @Autowired
    CrudHomeLibrarySlotRepository crudHomeLibrarySlotRepository;

    @Autowired
    HomeLibraryBookRepository homeLibraryBookRepository;

    @Override
    public List<BookEntity> getAllBooks() {
        return StreamSupport.stream(crudHomeLibraryBookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookEntity> getAvailableBooks(){
        return homeLibraryBookRepository.getAvailableBooks();
    }

    @Override
    public BookEntity getById(Integer id) {
        return crudHomeLibraryBookRepository.findById(id).get();
    }

    @Override
    public BookEntity addNewBook(BookEntity bookEntity) {
        bookEntity.setSlot(switchSlotAvailability(getAvailableSlot()));
        return crudHomeLibraryBookRepository.save(bookEntity);
    }

    @Override
    public SlotEntity getAvailableSlot() {
        return homeLibrarySlotRepository.getFreeSlot();
    }

    @Override
    public BookEntity takeBook(Integer id) {
        BookEntity book = crudHomeLibraryBookRepository.findById(id).get();
        book.setInTheShelf(false);
        crudHomeLibrarySlotRepository.save(switchSlotAvailability(book.getSlot()));
        book.setSlot(null);
        return crudHomeLibraryBookRepository.save(book);
    }

    private SlotEntity switchSlotAvailability(SlotEntity slotEntity){
        slotEntity.setAvailable(!slotEntity.isAvailable());
        return slotEntity;
    }
}
