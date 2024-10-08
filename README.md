# Bootjpa

**Bootjpa** 레파지토리에 오신 것을 환영합니다! 이 프로젝트는 백엔드 풀스택 과정 중 **JPA 기초** 수업을 위한 스프링 부트 애플리케이션입니다. Spring Boot와 JPA를 활용해 효율적인 백엔드 애플리케이션을 구축하는 방법을 배울 수 있도록 설계되었습니다.

## 🚀 프로젝트 개요

**Bootjpa**는 Spring Boot 2.x 버전과 JPA를 사용하여 데이터베이스와의 상호작용을 학습하고, 실습할 수 있는 기회를 제공합니다. 이 레파지토리를 통해 스프링 부트의 주요 기능과 JPA의 기본 개념을 익히며, 실제 프로젝트에 적용할 수 있는 능력을 키울 수 있습니다.

### 🌟 주요 기능

- **Spring Boot 통합**: Spring Boot의 강력한 기능을 활용해 간편하게 JPA를 통합하고, 애플리케이션을 빠르게 개발할 수 있습니다.
- **엔티티 관리**: JPA의 엔티티 관리, 애너테이션, 관계 설정, 상속 등을 학습합니다.
- **데이터베이스 연동**: MySQL을 사용해 실습하며, 기본적인 CRUD 작업부터 복잡한 쿼리 작성까지 경험할 수 있습니다.
- **커스텀 리포지토리**: Spring Data JPA 리포지토리를 확장하여 커스텀 쿼리를 작성하고 애플리케이션의 요구사항에 맞게 데이터를 처리하는 방법을 배웁니다.
- **트랜잭션 관리**: Spring의 트랜잭션 관리 기능을 통해 데이터의 일관성과 안정성을 유지하는 방법을 다룹니다.

## 🛠️ 사용 기술

- **Java 11**: Java 11의 기능을 활용하여 모던 자바 애플리케이션을 개발합니다.
- **Spring Boot 2.x**: 스프링 부트 2.x 버전을 기반으로 빠르고 효율적인 개발 환경을 제공합니다.
- **Spring Data JPA**: 데이터베이스 연동을 간편하게 할 수 있도록 ORM 기능을 제공합니다.
- **MySQL**: 실제 프로젝트에서 사용되는 MySQL 데이터베이스를 사용하여 연습합니다.
- **Thymeleaf**: 백엔드에서 데이터를 뷰로 전달하는 역할을 합니다.

## 📚 학습 모듈

1. **스프링 부트 소개**: 개발 환경 설정과 스프링 부트 시작하기.
2. **JPA 기초**: JPA의 주요 개념과 애너테이션에 대해 배웁니다.
3. **데이터베이스 관계**: 엔티티 간의 복잡한 관계를 매핑하는 방법을 학습합니다.
4. **Spring Data JPA**: 스프링 데이터 JPA로 데이터베이스 작업을 단순화합니다.
5. **커스텀 쿼리**: 고급 사용 사례를 위한 커스텀 쿼리 작성법을 익힙니다.
6. **트랜잭션 관리**: 트랜잭션 관리로 데이터 일관성을 보장하는 방법을 다룹니다.
7. **테스트 및 디버깅**: JPA 애플리케이션의 테스트와 디버깅 방법을 학습합니다.

## 📂 프로젝트 구조

```bash
bootjpa/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/bootjpa/
│   │   │       ├── controllers/
│   │   │       ├── entities/
│   │   │       ├── repositories/
│   │   │       ├── services/
│   │   │       └── BootjpaApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   └── test/
│       └── java/com/bootjpa/
└── README.md
```

## 📝 사용 방법

1. **레파지토리 클론**:
    ```bash
    git clone https://github.com/yourusername/bootjpa.git
    ```
2. **프로젝트 디렉토리로 이동**:
    ```bash
    cd bootjpa
    ```
3. **애플리케이션 실행**:
    ```bash
    ./mvnw spring-boot:run
    ```
4. **애플리케이션 접속**:
   브라우저를 열고 `http://localhost:8383`로 접속합니다.

## 🤝 기여 방법

이 프로젝트에 기여하고 싶으신가요? 개선 아이디어나 버그가 있다면, 이슈를 등록하거나 풀 리퀘스트를 제출해주세요. 함께 배우고 성장하는 개발 커뮤니티를 만들어갑시다!

---

행복한 코딩 되세요! 🎉

이 레파지토리가 유용하셨다면, ⭐를 눌러주시고 주변에 공유해주세요!
