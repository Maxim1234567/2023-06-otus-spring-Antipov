package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.domain.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("select g from Genre g where g.id in (:ids)")
    List<Genre> findByIds(@Param("ids") List<Long> bookIds);

    @Query("select g from Book b join b.genres g where b.id = :bookId")
    List<Genre> findByBookId(@Param("bookId") long bookId);

    @Query("select g from Book b join b.genres g where b.id in (:bookIds)")
    List<Genre> findByBookIds(@Param("bookIds") List<Long> bookIds);
}
