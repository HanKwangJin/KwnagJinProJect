package com.project.KwangJinProJect.domain.test;

import com.project.KwangJinProJect.domain.KwangJinRepository;
import com.project.KwangJinProJect.domain.Member;
import com.project.KwangJinProJect.web.dto.KwangJinSaveRequestDto;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KwangJinApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private KwangJinRepository kwangJinRepository;

    @After
    public void tearDown() throws Exception{
        kwangJinRepository.deleteAll();
    }
    @Test
    public void Member_등록() throws Exception{
        //given
        String name="광진";
        String password="1234";
        KwangJinSaveRequestDto kwangJinSaveRequestDto=KwangJinSaveRequestDto.builder()
                .name(name)
                .password(password)
                .age("age").build();

        String url = "http://localhost:" + port + "/api/members";

        //when
        ResponseEntity<Long> responseEntity=restTemplate.postForEntity(url,kwangJinSaveRequestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Member> all = kwangJinRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
    }

}
