package com.douzonetenten.tentenboardclient.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("해당 유저를 찾을 수 없습니다.");
    }
}
