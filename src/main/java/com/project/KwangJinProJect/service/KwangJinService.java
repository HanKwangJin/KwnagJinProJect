package com.project.KwangJinProJect.service;

import com.project.KwangJinProJect.domain.KwangJinRepository;
import com.project.KwangJinProJect.domain.Member;
import com.project.KwangJinProJect.web.dto.KwangJinResponseDto;
import com.project.KwangJinProJect.web.dto.KwangJinSaveRequestDto;
import com.project.KwangJinProJect.web.dto.KwangJinUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class KwangJinService {
    private final KwangJinRepository kwangJinRepository;

    @Transactional
    public Long save(KwangJinSaveRequestDto kwangJinSaveRequestDto) {
        return kwangJinRepository.save(kwangJinSaveRequestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, KwangJinUpdateRequestDto kwangJinUpdateRequestDto){
        Member member=kwangJinRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다.id="+id));
                member.update(kwangJinUpdateRequestDto.getName(), kwangJinUpdateRequestDto.getPassword());
                return id;
    }
    public KwangJinResponseDto findById(Long id){
        Member member=kwangJinRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new KwangJinResponseDto(member);

    }


}
