package com.example.jpa.memo.repository;

import com.example.jpa.entity.Member;
import com.example.jpa.entity.MemberMemoDTO;
import com.example.jpa.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class MemoCustomRepositoryImpl implements MemoCustomRepository {
    //memoRepository가 MemoCustomRepository를 상속받아줍니다.
    @PersistenceContext //엔티티 매니저를 주입받을때 사용하는 어노테이션
    private EntityManager entityManager;

    @Override
    @Transactional //update 구문이므로
    public int updateTest(String writer, Long mno) {
        //기존에 인터페이스를 통해서 처리하던 JPQL 구문을 직접 작성이 가능합니다.
        String sql = "update Memo m set m.writer = :a where m.mno = :b"; //JPQL
        Query query = entityManager.createQuery(sql);
        query.setParameter("a", writer);//a 파라미터에 writer를 채움
        query.setParameter("b",mno);
        int result = query.executeUpdate(); //insert update delete 구문을 실행할 대 사용

        return result;
    }

    @Override
    public List<Memo> mtoJoin1(Long mno) {
        TypedQuery<Memo> result = entityManager.createQuery(
                //"select m from Memo m inner join m.member x where m.mno <= :mno"
                //"select m from Memo m left join m.member x where m.mno <= :mno"
                "select m from Memo m inner join m.member x where m.mno <= :mno", //조인의 테이븛 위치에 엔티티의 필드 명이 들어감ㄴ
                Memo.class);

        result.setParameter("mno", mno);//파라미터 세팅
        List<Memo> list = result.getResultList();//list 타입으로 반환 받음

        return list;
    }

    @Override
    public List<Object[]> mtoJoin2(Long mno) {

        TypedQuery<Object[]> result = entityManager.createQuery(
                "select m , x from Memo m left join m.member x where m.mno <= :mno"
                , Object[].class
        );
        result.setParameter("mno", mno);
        List<Object[]> list = result.getResultList();


        return list;
    }

    @Override
    public List<Object[]> mtoJoin3(String writer) {

        TypedQuery<Object[]> result = entityManager.createQuery(
                "select m, x from Memo m inner join Member x on m.writer = x.name where m.writer = :writer",
                Object[].class);

        result.setParameter("writer", writer);
        List<Object[]> list = result.getResultList();

        return list;
    }

    @Override
    public List<Memo> mtoJoin4() {

        TypedQuery<Memo> result = entityManager.createQuery(
                "select m from Memo m left join fetch m.member x"
                , Memo.class
        );

        return result.getResultList();
    }

    @Override
    public Member otmJoin1(String id) {

      TypedQuery<Member> result = entityManager.createQuery(
                "select m from Member m inner join m.list where m.id = :id",
                Member.class
        );
      result.setParameter("id",id);
      Member m = result.getSingleResult(); // 1행인 경우

        return m;
    }

    @Override
    public List<Member> otmJoin2(String id) {

       TypedQuery <Member> result = entityManager.createQuery(
//                "select m from Member m inner join fetch m.list x where m.id= :id"
               "select distinct m from Member m inner join fetch m.list x where m.id= :id"
               ,Member.class

        );

       result.setParameter("id",id);
       List <Member> list = result.getResultList();
        return list;
    }

    @Override
    public List<MemberMemoDTO> otmJoin3(String id) {

        //구문의 select 절에는 생성자의 맵핑하는 구문이 들어갑니다.
        TypedQuery<MemberMemoDTO> result=entityManager.createQuery(
                "select new com.example.jpa.entity.MemberMemoDTO( m.id, m.name,m.signDate,x.mno,x.writer,x.text) " +
                        " from Member m inner join m.list x where m.id = :id "
                ,MemberMemoDTO.class
        );

        result.setParameter("id",id);
        List <MemberMemoDTO> list = result.getResultList();

        return list;
    }

//    @Override
//    public Page<MemberMemoDTO> joinPage(String text, Pageable pageable) {
//
//        TypedQuery<MemberMemoDTO> result=entityManager.createQuery(
//                "select new com.example.jpa.entity.MemberMemoDTO( x.id, x.name,x.signDate,m.mno,m.writer,m.text)" +
//                        "from Memo m left join m.member x where m.writer like :writer"
//                ,MemberMemoDTO.class
//        );
//        result.setParameter("writer","%"+text+"%"); // 파라미터 셋팅
//        result.setFirstResult((int)pageable.getOffset()); //페이지 시작 번호 - pageRequest.of(0,10) <- 앞에 값 0
//        result.setMaxResults(pageable.getPageSize()); //데이터 개수 - pageRequest.of(0,10) <- 뒤에 값 10
//        List <MemberMemoDTO> list = result.getResultList(); // 데이터
//        //페이지 작업을 처리할 때는 countQuery를 실행
//  Query countQuery = entityManager.createQuery(
//                "select count(m) from Memo m left join m.member x where m.writer like :writer"
//        );
//
//  countQuery.setParameter("writer","%"+text+"%"); // 파라미터 셋팅
//        Long count = (Long) countQuery.getSingleResult(); // 한 행의 결과가 반환됨
//
//        //실행 결과를 pageable객체에 담는다.
//        PageImpl <MemberMemoDTO> page = new PageImpl<>(list,pageable,count);
//
//        return page;
//    }
}
