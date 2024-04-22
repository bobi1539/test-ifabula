package test.ifabula.service;

import test.ifabula.dto.request.RegisterRequestDto;
import test.ifabula.dto.response.RegisterResponseDto;

public interface UserService {
    RegisterResponseDto register(RegisterRequestDto requestDto);
}
