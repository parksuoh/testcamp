package com.camping.camping.exceptions;

public class PasswordNotMatch extends RuntimeException {

    public PasswordNotMatch() {
        super("비밀번호가 틀립니다.");
    }
}
