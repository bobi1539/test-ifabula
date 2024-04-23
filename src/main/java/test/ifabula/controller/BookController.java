package test.ifabula.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.ifabula.contant.Endpoint;
import test.ifabula.dto.request.BookRequestDto;
import test.ifabula.dto.request.BorrowBookRequestDto;
import test.ifabula.dto.request.ReturnBookRequestDto;
import test.ifabula.dto.response.BookResponseDto;
import test.ifabula.dto.response.BorrowBookResponseDto;
import test.ifabula.service.BookService;

import java.util.List;

@RestController
@RequestMapping(Endpoint.BOOK)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookResponseDto create(
            @RequestBody @Valid BookRequestDto requestDto
    ) {
        return bookService.create(requestDto);
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/borrow")
    public BorrowBookResponseDto borrow(
            @RequestBody @Valid BorrowBookRequestDto requestDto
    ) {
        return bookService.borrow(requestDto);
    }

    @GetMapping("/{id}")
    public BookResponseDto getById(
            @PathVariable Long id
    ) {
        return bookService.getById(id);
    }

    @GetMapping("/borrow")
    public List<BorrowBookResponseDto> getBorrow(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Boolean isReturn
    ) {
        return bookService.getBorrow(userId, isReturn);
    }

    @PostMapping("/return")
    public BorrowBookResponseDto returnBook(
            @RequestBody @Valid ReturnBookRequestDto requestDto
    ) {
        return bookService.returnBook(requestDto);
    }
}
