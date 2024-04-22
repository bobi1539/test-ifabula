package test.ifabula.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.ifabula.contant.Endpoint;
import test.ifabula.dto.request.BookRequestDto;
import test.ifabula.dto.request.BorrowBookRequestDto;
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
}
