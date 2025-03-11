package com.jiyun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Message {

    WRONG_INPUT("올바른 값을 입력해 주세요."),
    NUMBER_ERROR("숫자를 입력해 주세요."),
    SYSTEM_ERROR("시스템 에러가 발생했습니다.");

    private final String content;

}