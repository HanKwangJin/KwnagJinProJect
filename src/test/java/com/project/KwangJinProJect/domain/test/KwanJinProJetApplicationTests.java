package com.project.KwangJinProJect.domain.test;

import com.project.KwangJinProJect.repository.KwangJinRepository;
import com.project.KwangJinProJect.domain.Member;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class KwanJinProJetApplicationTests {
	@Autowired
	KwangJinRepository kwangJinRepository;
	@After
	public void cleanUp(){
		kwangJinRepository.deleteAll();
	}
	@Test
	public void 이름나이(){
		String name = "광진";
		String age = "25";
		//given
		kwangJinRepository.save(Member.builder()
				.name(name)
				.age(age)
				.password("1111")
				.build());
		//when
		List<Member> list=kwangJinRepository.findAll();
		//then
		Member member=list.get(0);
		assertThat(member.getName()).isEqualTo(name);
		assertThat(member.getAge()).isEqualTo(age);
	}

}
