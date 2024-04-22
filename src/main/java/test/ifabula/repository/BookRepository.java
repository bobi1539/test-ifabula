package test.ifabula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.ifabula.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIsDeleted(boolean isDeleted);

    Optional<Book> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
