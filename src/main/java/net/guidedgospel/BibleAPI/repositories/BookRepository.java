package net.guidedgospel.BibleAPI.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import net.guidedgospel.BibleAPI.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query(value = "SELECT bookid FROM books WHERE bookName = ?", nativeQuery = true)
    public Integer getBookId(String bookName);

}
