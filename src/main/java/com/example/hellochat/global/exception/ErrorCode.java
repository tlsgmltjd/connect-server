package com.example.hellochat.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청."),

    NOT_MATCH_ADMIN_TOKEN(HttpStatus.BAD_REQUEST, "관리자 암호가 일치하지 않습니다."),

    DUPLICATED_USERNAME(HttpStatus.BAD_REQUEST, "중복된 사용자 입니다."),

    DONT_FOLLOW(HttpStatus.BAD_REQUEST, "팔로우할 수 없습니다."),

    DONT_UNFOLLOW(HttpStatus.BAD_REQUEST, "언팔로우할 수 없습니다."),

    NOT_FOLLOW_INFORMATION(HttpStatus.BAD_REQUEST, "팔로우를 찾을 수 없습니다."),

    NOT_MATCH_INFORMATION(HttpStatus.BAD_REQUEST, "사용자를 찾을 수 없습니다."),

    NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 데이터를 찾을 수 없습니다."),

    NOT_MATCH_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 틀립니다."),

    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 유효하지 않습니다."),

    NOT_OK_REQUEST(HttpStatus.BAD_REQUEST, "유요한 요청이 아닙니다."),

    DONT_SEND_REQUEST(HttpStatus.BAD_REQUEST, "요청을 보낼 수 없습니다."),

    MANY_REQUEST(HttpStatus.BAD_REQUEST, "요청은 한번에 3개를 초과할 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}