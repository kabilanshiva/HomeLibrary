package com.test.homelibrary.HomeLibraryController;

import com.test.homelibrary.HomeLibraryEntity.BookEntity;
import com.test.homelibrary.HomeLibraryEntity.SlotEntity;
import com.test.homelibrary.HomeLibraryService.HomeLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeLibraryController {

    @Autowired
    HomeLibraryService homeLibraryService;

    @GetMapping("/books")
    public List<BookEntity> getAllBooks() {
        return homeLibraryService.getAllBooks();
    }

    @GetMapping("/books/available")
    public List<BookEntity> getAvailableBooks() {
        return homeLibraryService.getAvailableBooks();
    }

    @GetMapping("/books/{id}")
    public BookEntity getBookById(@PathVariable("id") Integer id) {
        return homeLibraryService.getById(id);
    }

    @GetMapping("/slot")
    public SlotEntity getAvailableSlot() {
        return homeLibraryService.getAvailableSlot();
    }

    @PutMapping("/books/take/{id}")
    public BookEntity takeBook(@PathVariable("id")Integer id){
        return homeLibraryService.takeBook(id);
    }

    @PostMapping("/books")
    public BookEntity addNewBook(@RequestBody BookEntity bookEntity){
        return homeLibraryService.addNewBook(bookEntity);
    }

}
