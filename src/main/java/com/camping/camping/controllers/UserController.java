package com.camping.camping.controllers;


import com.camping.camping.applications.AuthUserService;
import com.camping.camping.applications.LoginService;
import com.camping.camping.applications.RegisterService;
import com.camping.camping.dtos.AuthTokenDto;
import com.camping.camping.dtos.AuthUserDto;
import com.camping.camping.dtos.LoginRequestDto;
import com.camping.camping.dtos.LoginResponseDto;
import com.camping.camping.dtos.RegisterRequestDto;
import com.camping.camping.dtos.RegisterResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final RegisterService registerService;
    private final LoginService loginService;
    private final AuthUserService authUserService;

    public UserController(RegisterService registerService, LoginService loginService, AuthUserService authUserService) {
        this.registerService = registerService;
        this.loginService = loginService;
        this.authUserService = authUserService;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponseDto register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        String token = registerService.register(registerRequestDto.getName(), registerRequestDto.getPassword());
        return new RegisterResponseDto(token);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return loginService.login(loginRequestDto.getName(), loginRequestDto.getPassword());
    }

    @PostMapping("/auth")
    public AuthUserDto login(@Valid @RequestBody AuthTokenDto authTokenDto) {
        return authUserService.auth(authTokenDto.getToken());
    }


}
