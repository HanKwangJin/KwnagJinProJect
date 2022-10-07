package com.project.KwangJinProJect.auth;

import com.project.KwangJinProJect.domain.Member;
import com.project.KwangJinProJect.repository.KwangJinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private KwangJinRepository kwangJinRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member memberEntity = kwangJinRepository.findByUsername(username);
        log.info("유저 정보 : {}", memberEntity);
        if (memberEntity != null) {
            return new PrincipalDetails(memberEntity);
        }
        return null;
    }
}
