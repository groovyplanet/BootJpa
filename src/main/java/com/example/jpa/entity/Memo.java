package com.example.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity //jpa가 엔티티로 관리한다는 의미
@Table(name = "MEMO") // MEMO 테이블
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Memo {
    //엔티티를 정의하면 , 하이버네이트가 ddl 구문을 대신 실행해 주는데, spring.jpa.hibernate.ddl-auto=update 옵션
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    //오라클 전략
//    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "이름")
//    @SequenceGenerator(name = "이름" , sequenceName = "시퀀스명", initialValue = 1, allocationSize = 1)
    private long mno;
    @Column(length = 200,nullable = false)
    private String writer;
    @Column(columnDefinition = "varchar(200) default 'y'")//만들고 싶은 제약을 직접 명시
    private String text;

    //N:1
    //FK 컬럼명을 명시하지 않으면 MEMBER 엔티티에 MEMBER_주키로 자동 생성 됩니다.
//    @ManyToOne(fetch=FetchType.LAZY) // manyTOone의 기본값은 eager
//    @JoinColumn(name = "member_id") //member엔티티의 주키를 member_id 컬럼에 저장하겠다 (FK 제약 조건을 걸어줌)
//    private Member member ; //멤버 엔티티

    @ManyToOne
    @JoinColumn(name = "member_id") //FK 지정
    private Member member;

}
