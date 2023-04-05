package ru.adel.springweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.adel.springweb.models.Book;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book,Integer> {
    List<Book> findByTitleStartingWith(String title);
}
