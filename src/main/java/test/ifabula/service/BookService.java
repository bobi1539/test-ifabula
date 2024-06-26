package test.ifabula.service;

import test.ifabula.dto.request.BookRequestDto;
import test.ifabula.dto.request.BorrowBookRequestDto;
import test.ifabula.dto.request.ReturnBookRequestDto;
import test.ifabula.dto.response.BookResponseDto;
import test.ifabula.dto.response.BorrowBookResponseDto;

import java.util.List;

public interface BookService {

    BookResponseDto create(BookRequestDto requestDto);

    List<BookResponseDto> getAll();

    BorrowBookResponseDto borrow(BorrowBookRequestDto requestDto);

    BookResponseDto getById(Long id);

    List<BorrowBookResponseDto> getBorrow(Long userId, Boolean isReturn);

    BorrowBookResponseDto returnBook(ReturnBookRequestDto requestDto);
}
