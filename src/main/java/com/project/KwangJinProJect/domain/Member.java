package com.project.KwangJinProJect.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.tags.form.TextareaTag;

import javax.persistence.*;
@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String password;
    private String age;

    @Builder
    public Member(String name, String password, String age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
