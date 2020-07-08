package com.example.MongoDBDemo.controller;


import com.example.MongoDBDemo.model.Books;
import com.example.MongoDBDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("app/v1")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(path = "/add_book", method = RequestMethod.POST)
    public String addBook(@RequestBody Books book){
        bookRepository.insert(book);
        return "Book Added with id " + book.getId();
    }

    @RequestMapping(path = "/get_all", method = RequestMethod.GET)
    public List<Books> getAllBooks(){
        return bookRepository.findAll();
    }

    @RequestMapping(path = "find_by_id/{id}", method = RequestMethod.GET)
    public Optional<Books> findById(@PathVariable("id") int id){
        return bookRepository.findById(id);
    }

    @RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int id){
        Optional<Books> bookToDelete  = findById(id);
        if(bookToDelete.isPresent()) {
            bookRepository.deleteById(id);
            return "Book with id " + bookToDelete.get().getId() + " deleted";
        }
        return "No Book exist with " + id;
    }
}
