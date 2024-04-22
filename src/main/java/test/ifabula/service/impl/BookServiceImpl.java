package test.ifabula.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.ifabula.contant.GlobalMessage;
import test.ifabula.dto.request.BookRequestDto;
import test.ifabula.dto.request.BorrowBookRequestDto;
import test.ifabula.dto.response.BookResponseDto;
import test.ifabula.dto.response.BorrowBookResponseDto;
import test.ifabula.entity.Book;
import test.ifabula.entity.BorrowBook;
import test.ifabula.entity.User;
import test.ifabula.exception.BusinessException;
import test.ifabula.repository.BookRepository;
import test.ifabula.repository.BorrowBookRepository;
import test.ifabula.repository.UserRepository;
import test.ifabula.service.BookService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BorrowBookRepository borrowBookRepository;

    @Override
    public BookResponseDto create(BookRequestDto requestDto) {
        Book book = saveBook(requestDto);
        return mapBookResponse(book);
    }

    @Override
    public List<BookResponseDto> getAll() {
        List<Book> books = bookRepository.findByIsDeleted(false);
        return mapBookResponseList(books);
    }

    @Override
    @Transactional
    public BorrowBookResponseDto borrow(BorrowBookRequestDto requestDto) {
        Book book = findBookById(requestDto.getBookId());
        checkBookIsBorrow(book);

        User user = findUserById(requestDto.getUserId());
        checkUserCanBorrow(user);

        BorrowBook borrowBook = saveBorrowBook(requestDto, book, user);
        updateBookIsBorrowed(book);
        return mapBorrowBookResponse(borrowBook);
    }

    private Book saveBook(BookRequestDto requestDto) {
        Book book = composeCreateBook(requestDto);
        return bookRepository.save(book);
    }

    private Book composeCreateBook(BookRequestDto requestDto) {
        return Book.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .build();
    }

    private List<BookResponseDto> mapBookResponseList(List<Book> books) {
        List<BookResponseDto> responses = new ArrayList<>();
        books.forEach(book -> responses.add(mapBookResponse(book)));
        return responses;
    }

    private BookResponseDto mapBookResponse(Book book) {
        return BookResponseDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .isBorrow(book.isBorrow())
                .createdAt(book.getCreatedAt())
                .createdBy(book.getCreatedBy())
                .updatedAt(book.getUpdatedAt())
                .updatedBy(book.getUpdatedBy())
                .isDeleted(book.isDeleted())
                .build();
    }

    private Book findBookById(Long id) {
        return bookRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new BusinessException(GlobalMessage.DATA_NOT_FOUND));
    }

    private User findUserById(Long id) {
        return userRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new BusinessException(GlobalMessage.DATA_NOT_FOUND));
    }

    private void checkBookIsBorrow(Book book) {
        if (book.isBorrow()) {
            throw new BusinessException(GlobalMessage.BOOK_IS_BORROW);
        }
    }

    private void checkUserCanBorrow(User user) {
        Optional<BorrowBook> borrowBook = borrowBookRepository.findByUserAndIsReturnAndIsDeleted(
                user, false, false
        );
        if (borrowBook.isPresent()) {
            throw new BusinessException(GlobalMessage.CANNOT_BORROW_BOOK);
        }
    }

    private BorrowBook saveBorrowBook(BorrowBookRequestDto requestDto, Book book, User user) {
        BorrowBook borrowBook = composeBorrowBook(requestDto, book, user);
        return borrowBookRepository.save(borrowBook);
    }

    private BorrowBook composeBorrowBook(BorrowBookRequestDto requestDto, Book book, User user) {
        return BorrowBook.builder()
                .book(book)
                .user(user)
                .borrowDate(LocalDateTime.now())
                .returnDate(requestDto.getReturnDate())
                .isReturn(false)
                .build();
    }

    private BorrowBookResponseDto mapBorrowBookResponse(BorrowBook borrowBook) {
        return BorrowBookResponseDto.builder()
                .id(borrowBook.getId())
                .book(mapBookResponse(borrowBook.getBook()))
                .userId(borrowBook.getUser().getId())
                .borrowDate(borrowBook.getBorrowDate())
                .returnDate(borrowBook.getReturnDate())
                .isReturn(borrowBook.isReturn())
                .build();
    }

    private void updateBookIsBorrowed(Book book) {
        book.setBorrow(true);
        bookRepository.save(book);
    }
}
