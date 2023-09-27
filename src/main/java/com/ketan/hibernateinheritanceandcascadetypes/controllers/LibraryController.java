package com.ketan.hibernateinheritanceandcascadetypes.controllers;
import com.ketan.hibernateinheritanceandcascadetypes.dtos.*;
import com.ketan.hibernateinheritanceandcascadetypes.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final ReaderService readerService;

    public LibraryController(AuthorService authorService, BookService bookService, ReaderService readerService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.readerService = readerService;
    }

    // Create operations

    @PostMapping("/authors")
    public AuthorResponseDto createAuthor(@RequestBody AuthorRequestDto author) {
        return authorService.createAuthor(author);
    }

    @PostMapping("/books")
    public BookReaderResponseDto createBook(@RequestBody BookRequestDto book) {
        return bookService.createBook(book);
    }

    @PostMapping("/readers")
    public ReaderResponseDto createReader(@RequestBody ReaderRequestDto reader) {
        return readerService.createReader(reader);
    }

    // Read operations

    @GetMapping("/authors")
    public List<String> getAllAuthorNames() {
        return authorService.getAllAuthorNames();
    }

    @GetMapping("/authors/all")
    public List<AuthorResponseDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public AuthorResponseDto getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    // Get books by author
    @GetMapping("/authors/{id}/books")
    public List<String> getBooksByAuthor(@PathVariable Long id) {
        return authorService.getBooksByAuthor(id);
    }

    @GetMapping("/authors/{id}/booksReaderCount")
    public List<AuthorBookReaderCountDto> getReaderCountPerBook(@PathVariable Long id) {
        return authorService.getReaderCountPerBook(id);
    }

    @GetMapping("/books")
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public BookReaderResponseDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // Get readers by book
    @GetMapping("/books/{id}/readers")
    public List<String> getReadersByBook(@PathVariable Long id) {
        return bookService.getReadersByBook(id);
    }

    @GetMapping("/readers")
    public List<String> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping("/readers/{id}")
    public ReaderResponseDto getReaderById(@PathVariable Long id) {
        return readerService.getReaderById(id);
    }

    // Get books by reader
    @GetMapping("/readers/{id}/books")
    public List<String> getBooksByReader(@PathVariable Long id) {
        return readerService.getBooksByReader(id);
    }

    // Update operations

    @PutMapping("/authors/{id}")
    public AuthorResponseDto updateAuthor(@PathVariable Long id, @RequestBody AuthorRequestDto author) {
        return authorService.updateAuthor(id, author);
    }

    @PutMapping("/books/{id}")
    public BookReaderResponseDto updateBook(@PathVariable Long id, @RequestBody BookRequestDto book) {
        return bookService.updateBook(id, book);
    }

    @PutMapping("/readers/{id}")
    public ReaderResponseDto updateReader(@PathVariable Long id, @RequestBody ReaderRequestDto reader) {
        return readerService.updateReader(id, reader);
    }

    // Delete operations

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @DeleteMapping("/readers/{id}")
    public void deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
    }


}
