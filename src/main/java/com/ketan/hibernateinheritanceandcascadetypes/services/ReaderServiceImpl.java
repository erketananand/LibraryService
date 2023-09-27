package com.ketan.hibernateinheritanceandcascadetypes.services;

import com.ketan.hibernateinheritanceandcascadetypes.dtos.*;
import com.ketan.hibernateinheritanceandcascadetypes.models.*;
import org.springframework.stereotype.Service;
import com.ketan.hibernateinheritanceandcascadetypes.repositories.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository, BookRepository bookRepository) {
        this.readerRepository = readerRepository;
        this.bookRepository = bookRepository;
    }

    private List<String> getBookTitles(Reader reader) {
        List<String> bookTitles = reader.getBooks().stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        return bookTitles;
    }

    @Override
    public ReaderResponseDto createReader(ReaderRequestDto readerRequestDto) {
        Reader reader = new Reader();
        reader.setName(readerRequestDto.getName());

        List<Book> books = readerRequestDto.getBooks().stream()
                .map(baseObjectDto -> bookRepository.findById(baseObjectDto.getId()).orElse(null))
                .collect(Collectors.toList());

        reader.setBooks(new HashSet<>(books));
        reader = readerRepository.save(reader);

        return ReaderResponseDto.builder()
                .name(reader.getName())
                .bookNames(getBookTitles(reader))
                .build();
    }

    @Override
    public List<String> getAllReaders() {
        return readerRepository.findAll().stream()
                .map(Reader::getName)
                .collect(Collectors.toList());
    }

    @Override
    public ReaderResponseDto getReaderById(Long id) {
        Reader reader = readerRepository.findById(id).orElse(null);
        if (reader != null) {
            return ReaderResponseDto.builder()
                    .name(reader.getName())
                    .bookNames(getBookTitles(reader))
                    .build();
        }
        return null;
    }

    @Override
    public ReaderResponseDto updateReader(Long id, ReaderRequestDto readerRequestDto) {
        Reader reader = readerRepository.findById(id).orElse(null);
        if (reader != null) {
            reader.setName(readerRequestDto.getName());

            List<Book> books = readerRequestDto.getBooks().stream()
                    .map(baseObjectDto -> bookRepository.findById(baseObjectDto.getId()).orElse(null))
                    .collect(Collectors.toList());

            reader.setBooks(new HashSet<>(books));
            reader = readerRepository.save(reader);

            return ReaderResponseDto.builder()
                    .name(reader.getName())
                    .bookNames(getBookTitles(reader))
                    .build();
        }
        return null;
    }

    @Override
    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }

    @Override
    public List<String> getBooksByReader(Long id) {
        Reader reader = readerRepository.findById(id).orElse(null);
        if (reader != null) {
            return getBookTitles(reader);
        }
        return null;
    }
}
