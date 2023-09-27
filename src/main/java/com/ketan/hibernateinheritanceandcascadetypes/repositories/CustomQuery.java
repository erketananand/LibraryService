package com.ketan.hibernateinheritanceandcascadetypes.repositories;

public interface CustomQuery {
    String FIND_READERS_COUNT_PER_BOOK_BY_AUTHOR_ID = "SELECT NEW com.ketan.hibernateinheritanceandcascadetypes.dtos.AuthorBookReaderCountDto(b.title, COUNT(r.id)) FROM Author a JOIN a.books b LEFT JOIN b.readers r WHERE a.id = :authorId GROUP BY b.id";
}
