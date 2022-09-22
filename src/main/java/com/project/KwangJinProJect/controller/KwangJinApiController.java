package com.project.KwangJinProJect.controller;

import com.project.KwangJinProJect.service.KwangJinService;
import com.project.KwangJinProJect.web.dto.KwangJinResponseDto;
import com.project.KwangJinProJect.web.dto.KwangJinSaveRequestDto;
import com.project.KwangJinProJect.web.dto.KwangJinUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

@RequiredArgsConstructor
    @RestController
    public class KwangJinApiController {

        private final KwangJinService kwangJinService;

        @PostMapping("/api/members")
        public String save(@RequestBody KwangJinSaveRequestDto kwangJinSaveRequestDto) {
            kwangJinService.save(kwangJinSaveRequestDto);
                return "kwangJinHome";
        }
        @PutMapping("/api/members/{id}")
        public Long update(@PathVariable Long id, @RequestBody KwangJinUpdateRequestDto kwangJinUpdateRequestDto){
            return kwangJinService.update(id,kwangJinUpdateRequestDto);
        }
        @GetMapping("/api/members/{id}")
        public KwangJinResponseDto findById(@PathVariable Long id){
            return kwangJinService.findById(id);
        }


}
