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
    private String username;
    private String password;
    private String age;

    public void update(String username,String password){
        this.username=username;
        this.password=password;
    }
    @Builder
    public Member(String username, String password, String age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
