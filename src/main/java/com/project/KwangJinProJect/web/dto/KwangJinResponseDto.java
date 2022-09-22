package com.project.KwangJinProJect.web.dto;

import com.project.KwangJinProJect.domain.Member;
import lombok.Getter;

@Getter
public class KwangJinResponseDto {

    private Long id;
    private String name;
    private String password;
    private String age;

    public KwangJinResponseDto(Member member){
        this.id=member.getId();
        this.name=member.getName();
        this.password=member.getPassword();
        this.age=member.getAge();
    }

}
