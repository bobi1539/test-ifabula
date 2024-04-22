package test.ifabula.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.ifabula.contant.Endpoint;
import test.ifabula.dto.request.LoginRequestDto;
import test.ifabula.dto.request.RegisterRequestDto;
import test.ifabula.dto.response.LoginResponseDto;
import test.ifabula.dto.response.RegisterResponseDto;
import test.ifabula.service.UserService;

@RestController
@RequestMapping(Endpoint.AUTH)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public RegisterResponseDto register(
            @RequestBody @Valid RegisterRequestDto requestDto
    ) {
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody @Valid LoginRequestDto requestDto
    ) {
        return userService.login(requestDto);
    }
}
