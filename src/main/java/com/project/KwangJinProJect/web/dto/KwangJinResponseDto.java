package com.project.KwangJinProJect.web.dto;

import com.project.KwangJinProJect.domain.Member;
import lombok.Getter;

@Getter
public class KwangJinResponseDto {

    private Long id;
    private String username;
    private String password;
    private String age;

    public KwangJinResponseDto(Member member){
        this.id=member.getId();
        this.username=member.getUsername();
        this.password=member.getPassword();
        this.age=member.getAge();
    }

}
