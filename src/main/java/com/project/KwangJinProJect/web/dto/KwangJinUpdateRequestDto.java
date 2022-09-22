package com.project.KwangJinProJect.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KwangJinUpdateRequestDto {
    private String name;
    private String password;

    @Builder
    public KwangJinUpdateRequestDto(String name,String password){
        this.name=name;
        this.password=password;
    }
}
