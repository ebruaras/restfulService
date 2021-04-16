package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book create(Book product){
        return bookRepository.save(product);
    }
    public List<Book> listAll(){
        return bookRepository.findAll();
    }
    public Book listById(int id){
        return bookRepository.findById(id);
    }
    public void delete(Book product){
        bookRepository.delete(product);
    }
    public Book update(Book book){
        Book _book=bookRepository.findById(book.getId());
        _book.setName(book.getName());
        _book.setAuthor(book.getAuthor());
        _book.setPage(book.getPage());
        return bookRepository.save(_book);
    }
}
