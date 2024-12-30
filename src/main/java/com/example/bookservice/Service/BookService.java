package com.example.bookservice.Service;

import com.example.bookservice.Model.Book;
import com.example.bookservice.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "bc")
public class BookService {
    private final BookRepository bookRepository;

    @Cacheable
    public List<Book> findAll() {
       return bookRepository.findAll();
    }

    @Cacheable(key = "#id")
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @CachePut(key = "#book.id")
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @CacheEvict(key = "#id")
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
