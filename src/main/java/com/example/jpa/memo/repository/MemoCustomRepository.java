package com.example.jpa.memo.repository;

import com.example.jpa.entity.Member;
import com.example.jpa.entity.MemberMemoDTO;
import com.example.jpa.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemoCustomRepository  {

   int updateTest(String writer , Long mno);
   List<Memo> mtoJoin1(Long mno); //manyToOne 조인 (N+1문제) -조인을 하기위해 추가적인 select구문을 날리는 행위
   List<Object[]>mtoJoin2(Long mno); // 두개 이상의 엔티티 동시에 조회 (반환 object[])
   List<Object[]>mtoJoin3(String writer);
   List<Memo>mtoJoin4(); //성능향상 Fetch 조인(로딩 전략보다 무조건 우선시 적용됨)


   ////////////////////////////////////////
   //원 투 매니 방식
   Member otmJoin1(String id);//OneTomany 조인
   List<Member>otmJoin2(String id); //fetch 조인 - 1:N 조인에서 Fetch 방식은 중복행을 생성 (중복행 제거 disctinct)
//   List<Member>otmJoin3(String id);


   
   ///////////////////////////////////////////////////
   //다대일 양방향 맵핑

  
   List<MemberMemoDTO> otmJoin3(String id); //DTO로 반환받기
//   Page<MemberMemoDTO> joinPage(String text, Pageable pageable); //조인 된 결과를 pageable 처리


}
