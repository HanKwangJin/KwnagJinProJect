package com.project.KwangJinProJect.web.dto;

import com.project.KwangJinProJect.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KwangJinSaveRequestDto {
    private String username;
    private String password;
    private String age;

    @Builder

    public KwangJinSaveRequestDto(String username, String password, String age) {
            this.username = username;
            this.password = password;
            this.age = age;
        }

        public Member toEntity(){
        return Member.builder()
                .username(username)
                .password(password)
                .age(age)
                .build();
    }

}
