package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();

//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("spring1");

        memoryMemberRepository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        memoryMemberRepository.save(member1);

        Member result = memoryMemberRepository.findByName("spring1").get();

        assertThat(result).isEqualTo(member);

    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("spring1");
        memoryMemberRepository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        memoryMemberRepository.save(member1);

        List<Member> result = memoryMemberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
