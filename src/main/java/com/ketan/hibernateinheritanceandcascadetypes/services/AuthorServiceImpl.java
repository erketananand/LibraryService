package com.ketan.hibernateinheritanceandcascadetypes.services;

import com.ketan.hibernateinheritanceandcascadetypes.dtos.*;
import com.ketan.hibernateinheritanceandcascadetypes.models.*;
import org.springframework.stereotype.Service;
import com.ketan.hibernateinheritanceandcascadetypes.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private List<String> getBookTitles(Author author) {
        List<String> bookTitles = author.getBooks().stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        return bookTitles;
    }

    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        List<AuthorResponseDto> authors = authorRepository.findAll().stream()
                .map(author -> AuthorResponseDto.builder()
                        .name(author.getName())
                        .books(getBookTitles(author))
                        .build())
                .collect(Collectors.toList());
        return authors;
    }

    @Override
    public AuthorResponseDto createAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author = authorRepository.save(author);
        return AuthorResponseDto.builder()
                .name(author.getName())
                .books(new ArrayList<>())
                .build();
    }

    @Override
    public List<String> getAllAuthorNames() {
        return authorRepository.findAll().stream()
                .map(Author::getName)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {

            return AuthorResponseDto.builder()
                    .name(author.getName())
                    .books(getBookTitles(author))
                    .build();
        }
        return null;
    }

    @Override
    public AuthorResponseDto updateAuthor(Long id, AuthorRequestDto authorRequestDto) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setName(authorRequestDto.getName());
            author = authorRepository.save(author);
            return AuthorResponseDto.builder()
                    .name(author.getName())
                    .books(getBookTitles(author))
                    .build();
        }
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<String> getBooksByAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            return getBookTitles(author);
        }
        return null;
    }

    // Get the number of readers for each book written by an author
    @Override
    public List<AuthorBookReaderCountDto> getReaderCountPerBook(Long authorId) {
        return   authorRepository.getReaderCountPerBook(authorId);
        /* Other way of doing it
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            List<AuthorBookReaderCountDto> bookReaderCounts = new ArrayList<>();
            for (Book book : author.getBooks()) {
                long readerCount = book.getReaders().size();
                AuthorBookReaderCountDto bookReaderCount = AuthorBookReaderCountDto.builder()
                        .bookTitle(book.getTitle())
                        .readerCount(readerCount)
                        .build();
                bookReaderCounts.add(bookReaderCount);
            }
            return bookReaderCounts;
        }
        return Collections.emptyList();*/
    }
}
