package com.example.bookservice.Controller;

import com.example.bookservice.Model.Book;
import com.example.bookservice.Service.BookService;
import com.example.bookservice.Service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final KafkaProducerService kafkaProducerService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();

        return ResponseEntity.status(HttpStatus.OK)
                .body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.findById(id).get());
    }

    @CacheEvict(value = "bc", allEntries = true)
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        log.info("Попытка добавить книгу: " + book);
        try {
            Book savedBook = bookService.save(book);
            log.info("Книга успешно добавлена: " + savedBook);
            kafkaProducerService.sendMessage("book-topic", "Создана книга: " + savedBook);
            
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedBook);
        } catch (Exception e) {
            log.error("Ошибка при добавлении книги", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        bookService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}