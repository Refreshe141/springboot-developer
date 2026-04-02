package com.kmh.Spring01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Sql("/insert-member.sql")
    void getAllMembers(){
        //given

        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(3);
    }




    @Test
    @Sql("/insert-member.sql")
    void getMemberById(){
        //given

        //when
        Member member = memberRepository.findById(2L).get();

        //then
        assertThat(member.getName()).isEqualTo("B");
    }


    @Test
    @Sql("/insert-member.sql")
    void getMemberByName(){

        //given


        //when
        Member member = memberRepository.findByName("C").get();

        //then
        assertThat(member.getId()).isEqualTo(3);

    }

    @DisplayName("레코드 삽입 테스트")
    @Test

    void saveMember(){
        //given
        Member m = new Member("scpark");


        //when
        Member savedMember = memberRepository.save(m);
        Long id = savedMember.getId();
        Optional<Member> result = memberRepository.findById(id);
        Member member = result.get();
        String name = member.getName();
        assertThat(name).isEqualTo("scpark");

        //then
        // assertThat(savedMember.getId()).isNotNull();
        //assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("scpark");
    }
    @DisplayName("2개의 레코드를 한번에 삽입하는 테스트")
    @Test
    void saveMembers(){
        //given
        List<Member> members = List.of(new Member("Hongildong"),new Member("kimminhyeok"));

        //when
        memberRepository.saveAll(members);


        //then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);

    }
    @Sql("/insert-member.sql")
    @DisplayName("레코드 삭제 테스트")
    @Test
    void deleteAll(){
        //given

        //when
        memberRepository.deleteAll();


        //then
        assertThat(memberRepository.findAll().size()).isZero();
    }

    @Sql("/insert-member.sql")
    @DisplayName("Update Test")
    @Test
    void update(){

        //given
        Member member = memberRepository.findById(2L).get();


        //when
        member.changeName("scpark2");


        //then
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("scpark2");
    }
}