package com.project.KwangJinProJect.web.dto;

import com.project.KwangJinProJect.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KwangJinSaveRequestDto {
    private String name;
    private String password;
    private String age;

    @Builder

    public KwangJinSaveRequestDto(String name, String password, String age) {
            this.name = name;
            this.password = password;
            this.age = age;
        }

        public Member toEntity(){
        return Member.builder()
                .name(name)
                .password(password)
                .age(age)
                .build();
    }

}
