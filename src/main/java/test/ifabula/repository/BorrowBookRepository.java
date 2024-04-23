package test.ifabula.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import test.ifabula.entity.BorrowBook;
import test.ifabula.entity.User;

import java.util.List;
import java.util.Optional;

public interface BorrowBookRepository extends JpaRepository<BorrowBook, Long> {

    Optional<BorrowBook> findByUserAndIsReturnAndIsDeleted(
            User user, boolean isReturn, boolean isDeleted
    );

    List<BorrowBook> findAll(Specification<BorrowBook> specification);

    Optional<BorrowBook> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
