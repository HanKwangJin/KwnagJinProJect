package com.project.KwangJinProJect.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String age;

    public void update(String name,String password){
        this.name=name;
        this.password=password;
    }
    @Builder
    public Member(String name, String password, String age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
