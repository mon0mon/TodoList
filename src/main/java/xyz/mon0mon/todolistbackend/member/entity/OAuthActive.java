package xyz.mon0mon.todolistbackend.member.entity;

import lombok.Getter;

@Getter
public enum OAuthActive {
    NONE(0), NAVER(10), KAKAO(20);

    private Integer code;

    OAuthActive(Integer code) {
        this.code = code;
    }
}
