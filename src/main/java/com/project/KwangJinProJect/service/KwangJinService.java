package com.project.KwangJinProJect.service;

import com.project.KwangJinProJect.repository.KwangJinRepository;
import com.project.KwangJinProJect.domain.Member;
import com.project.KwangJinProJect.web.dto.KwangJinResponseDto;
import com.project.KwangJinProJect.web.dto.KwangJinSaveRequestDto;
import com.project.KwangJinProJect.web.dto.KwangJinUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KwangJinService {
    private final KwangJinRepository kwangJinRepository;
    private final KwangJinService kwangJinService;
    private final KwangJinResponseDto kwangJinResponseDto;
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
    public List<Member> findAll(){
        return kwangJinRepository.findAll();
    }
    public boolean login(Member member){
        Member findMember=kwangJinRepository.findByname(member.getName());
        if (findMember == null){
            return false;
        }
        if (!findMember.getPassword().equals(member.getPassword())){
            return false;
        }
        return true;
    }
}
