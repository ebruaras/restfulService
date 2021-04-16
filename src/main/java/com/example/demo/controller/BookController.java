package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;
    @CrossOrigin
    @GetMapping("/allBook")
    public ResponseEntity<List<Book>> getAllBook(){
        return new ResponseEntity<List<Book>>(bookService.listAll(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id")int id){
        return new ResponseEntity<Book>(bookService.listById(id),HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.create(book), HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@RequestBody @PathVariable(value = "id")int id){
        Book product=bookService.listById(id);
        bookService.delete(product);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.update(book),HttpStatus.OK);
    }
}
