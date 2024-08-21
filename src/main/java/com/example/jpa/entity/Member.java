package com.example.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.util.Lazy;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) // JPA 엔티티를 관리하는 영역에서 자동으로 변수에 적용해주는 역할을 함
//오디팅 기능을 활성화 시키려면 main 클래스 @EnableJpaAutoding
public class Member {
    @Id//PK
    private String id;
    @Column(nullable = false, length = 50) //null 허용 x , 길이는 50
    private String name;
    @CreatedDate //JPA를 통해서 인서트시에 날짜가 자동 입력됨
    @Column(updatable = false)
    private LocalDateTime signDate;

    //원투매니 단방향 조인 - 그냥사용하게되면 , 연관관계의 주인 1이 되면서 맵핑 테이블 자동생성
    //연관관계 주인 - FK를 관리하는 주체
//    @OneToMany(fetch = FetchType.EAGER) //OneToMany의 default 조인 방식은 Lazy 입니다
//    @JoinColumn(name = "member_id") //N테이블의 member_id를 FK로 조인하겠다 . (적지 않으면 맵핑 테이블 자동 생성)
//    private final List<Memo>list = new ArrayList<>();

    //양방향 맵핑
    //양방향 맵핑 시 toString 한쪽에서 지워야 함
    @OneToMany(mappedBy = "member") //mappedby 는 1쪽에서 지정하고 , 연관관계의 주인을 나타내는 키워드 (N쪽의 필드명)
    private final List<Memo>list =new ArrayList<>();



}
