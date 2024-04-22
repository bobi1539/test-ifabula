package test.ifabula.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import test.ifabula.contant.GlobalMessage;
import test.ifabula.dto.request.RegisterRequestDto;
import test.ifabula.dto.response.RegisterResponseDto;
import test.ifabula.entity.User;
import test.ifabula.exception.BusinessException;
import test.ifabula.helper.Util;
import test.ifabula.repository.UserRepository;
import test.ifabula.service.UserService;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDto register(RegisterRequestDto requestDto) {
        validateEmail(requestDto.getEmail());
        checkEmailIsRegistered(requestDto.getEmail());
        validatePassword(requestDto.getPassword());
        User user = saveUser(requestDto);
        return mapUserToResponse(user);
    }

    private void validateEmail(String email) {
        String regex = "^(.+)@(\\S+)$";
        boolean isEmailValid = Pattern.compile(regex).matcher(email).matches();
        if (!isEmailValid) {
            throw new BusinessException(GlobalMessage.EMAIL_NOT_VALID);
        }
    }

    private void checkEmailIsRegistered(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            throw new BusinessException(GlobalMessage.EMAIL_IS_REGISTERED);
        }
    }

    private void validatePassword(String password) {
        validatePasswordContainUpperCaseLetter(password);
        validatePasswordContainSpecialChar(password);
    }

    private void validatePasswordContainUpperCaseLetter(String password) {
        boolean isContainUpperCaseLetter = Util.isStringContainUpperCaseLetter(password);
        if (!isContainUpperCaseLetter) {
            throw new BusinessException(GlobalMessage.PASSWORD_MUST_CONTAIN_UPPER_CASE);
        }
    }

    private void validatePasswordContainSpecialChar(String password) {
        boolean isContainSpecialChar = Util.isStringContainSpecialChar(password);
        if (isContainSpecialChar) {
            throw new BusinessException(GlobalMessage.PASSWORD_MUST_NOT_CONTAIN_SYMBOL);
        }
    }

    private User saveUser(RegisterRequestDto requestDto) {
        User user = composeRegister(requestDto);
        return userRepository.save(user);
    }

    private User composeRegister(RegisterRequestDto requestDto) {
        return User.builder()
                .email(requestDto.getEmail())
                .password(hashPassword(requestDto.getPassword()))
                .build();
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private RegisterResponseDto mapUserToResponse(User user) {
        return RegisterResponseDto.builder()
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .isDeleted(user.isDeleted())
                .build();
    }
}
