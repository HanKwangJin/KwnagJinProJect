package com.project.KwangJinProJect.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KwangJinUpdateRequestDto {
    private String username;
    private String password;

    @Builder
    public KwangJinUpdateRequestDto(String username,String password){
        this.username=username;
        this.password=password;
    }
}
