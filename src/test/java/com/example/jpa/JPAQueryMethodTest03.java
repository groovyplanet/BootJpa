package com.example.jpa;

import com.example.jpa.entity.Memo;
import com.example.jpa.memo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class JPAQueryMethodTest03 {

    //쿼리 메서드는 JPA인터페이스의 메서드 모형을 보고 ㅡ, sql을 대신 실행시킴 (다양한 select 구문 활용)
    //
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testCode01() {
//        Memo m =memoRepository.findByWriterAndText("example10", "sample10");
//        System.out.println(m.toString());

       List<Memo>list = memoRepository.findByMnoLessThan(20L);//20보다 미만
        System.out.println(list.toString());
    }





//    SELECT * FROM MEMO WHERE MNO =11;
    @Test
    public void testCode02() {
        Memo m =memoRepository.findByMno(11l);
        System.out.println(m.toString());

    }

    //SELECT * FROM MEMO WHERE MNO between 10 AND 20;
    @Test
    public void testCode03() {
       List<Memo>list=memoRepository.findByMnoBetween(10L,20L);
        System.out.println(list.toString());
    }

    //SELECT * FROM MEMO WHERE WRITER LIKE '%10%';
    @Test
    public void testCode04() {
    List<Memo>list =memoRepository.findByWriterLike("%"+10+"%");
        System.out.println(list.toString());
    }
    //SELECT * FROM MEMO WHERE WRITER = 'example' order by WRITER desc;
    @Test
    public void testCode05() {
        List<Memo>list = memoRepository.findByWriterOrderByWriterDesc("example1");
        System.out.println(list.toString());
    }
    //    SELECT * FROM MEMO WHERE MNO IN (10,20,30,40,50);
    @Test
    public void testCode06() {
        List <Memo> list =memoRepository.findByMnoIn(Arrays.asList(10L, 20L, 30L, 40L, 50L));
        System.out.println(list.toString());
    }

    //쿼리메서드의 마지막 매개변수에 pageable을 주면 , 페이징처리합니다.
    @Test
    public void testCode07() {
        //쿼리메서드 + 페이지 결합
       Pageable pageable =  PageRequest.of(0,10, Sort.by("mno").descending());
        List <Memo>list= memoRepository.findByMnoLessThanEqual(50L, pageable);
        for(Memo m :list){
            System.out.println(m.toString());
        }

    }

}
