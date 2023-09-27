package com.ketan.hibernateinheritanceandcascadetypes.services;

import com.ketan.hibernateinheritanceandcascadetypes.dtos.*;
import com.ketan.hibernateinheritanceandcascadetypes.models.*;
import org.springframework.stereotype.Service;
import com.ketan.hibernateinheritanceandcascadetypes.repositories.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private List<String> getReaderNames(Book book) {
        List<String> readerNames = book.getReaders().stream()
                .map(Reader::getName)
                .collect(Collectors.toList());
        return readerNames;
    }

    @Override
    public BookReaderResponseDto createBook(BookRequestDto bookRequestDto) {
        Author author = authorRepository.findById(bookRequestDto.getAuthor().getId()).orElse(null);
        if (author != null) {
            Book book = new Book();
            book.setTitle(bookRequestDto.getTitle());
            book.setAuthor(author);
            book = bookRepository.save(book);

            return BookReaderResponseDto.builder()
                    .title(book.getTitle())
                    .authorName(author.getName())
                    .readers(getReaderNames(book))
                    .build();
        }
        return null;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<BookResponseDto> books = bookRepository.findAll().stream()
                .map(book -> BookResponseDto.builder()
                        .title(book.getTitle())
                        .authorName(book.getAuthor().getName())
                        .build())
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public BookReaderResponseDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            Author author = book.getAuthor();
            return BookReaderResponseDto.builder()
                    .title(book.getTitle())
                    .authorName(author.getName())
                    .readers(getReaderNames(book))
                    .build();
        }
        return null;
    }

    @Override
    public BookReaderResponseDto updateBook(Long id, BookRequestDto bookRequestDto) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            Author author = authorRepository.findById(bookRequestDto.getAuthor().getId()).orElse(null);
            if (author != null) {
                book.setTitle(bookRequestDto.getTitle());
                book.setAuthor(author);
                book = bookRepository.save(book);

                return BookReaderResponseDto.builder()
                        .title(book.getTitle())
                        .authorName(author.getName())
                        .readers(getReaderNames(book))
                        .build();
            }
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<String> getReadersByBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            return getReaderNames(book);
        }
        return null;
    }
}
