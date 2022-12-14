package com.project.KwangJinProJect.controller;

import com.project.KwangJinProJect.domain.Member;
import com.project.KwangJinProJect.repository.KwangJinRepository;
import com.project.KwangJinProJect.service.KwangJinService;
import com.project.KwangJinProJect.web.dto.KwangJinResponseDto;
import com.project.KwangJinProJect.web.dto.KwangJinSaveRequestDto;
import com.project.KwangJinProJect.web.dto.KwangJinUpdateRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
    public class KwangJinApiController {

    @Autowired
        private KwangJinService kwangJinService;
    @Autowired
        private KwangJinRepository kwangJinRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/api/members")
    public String save(KwangJinSaveRequestDto kwangJinSaveRequestDto) {
        log.info("회원 정보 : {}", kwangJinSaveRequestDto);
            kwangJinService.save(kwangJinSaveRequestDto);
        return "redirect:/";
    }

    @GetMapping("/api/list")
    public String list(Model model){
        List<Member> member =kwangJinService.findAll();
        model.addAttribute("member",member);
        return "kwangJinList";
    }

//    @PostMapping("/api/join")
//    public  String login(Member member){
//        if (kwangJinService.login(member)){
//            log.info("멤버 : {}", member);
//            return "kwangJinJoin";
//        }
//        return "redirect:/";
//    }

    @PostMapping("/api/join")
    public String join(Member member) {
        log.info("가입한 유저 : {}", member);

        String rawPassword = member.getPassword();
        log.info("기본 암호 : {}", rawPassword);

        String encode = passwordEncoder.encode(rawPassword);
        log.info("암호화 : {}", encode);
        member.setPassword(encode);
        kwangJinRepository.save(member);
        return "redirect:/loginPage";
    }



//        @PutMapping("/api/members/{id}")
//        public Long update(@PathVariable Long id, @RequestBody KwangJinUpdateRequestDto kwangJinUpdateRequestDto){
//            return kwangJinService.update(id,kwangJinUpdateRequestDto);
//        }
//        @GetMapping("/api/members/{id}")
//        public KwangJinResponseDto findById(@PathVariable Long id){
//            return kwangJinService.findById(id);

//        }
//    @GetMapping("/api/join")
//    public  String login(){
//        return "kwangJinJoin";

//    }



}
