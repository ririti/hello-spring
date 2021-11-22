# Spring Study
---

> 김영한님 인프런 강의 - 스프링 입문
>
## 1.2021 11월 22일
- 프로젝트 환경설정
    - 프로젝트 생성
    - 라이브러리 살펴보기
    - View 환경설정
    - 빌드하고 실행
- 스프링 웹 개발 기초
  - 정적 컨텐츠
  - MVC와 템플릿 엔진
  - API
    - 객체를 반환하는것을 API방식
    - 기본은 JSON으로 반환
    - @ResponseBody 를 사용 
    - HTTP의 BODY에 문자 내용을 직접 반환
      viewResolver 대신에 HttpMessageConverter 가 동작
    -  기본 문자처리: StringHttpMessageConverter
    -  기본 객체처리: MappingJackson2HttpMessageConverter
    -  byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
    
  - 회원관리 예제 - 백엔드 개발
    - 비즈니스 요구사항 정리
    - 회원 도메인과 리포지토리 만들기
    - 회원 리포지토리 테스트 케이스 작성
    - 회원 서비스 개발
    - 회원 서비스 테스트
> 2.2021 11월 23일
  - 스프링 빈과 의존관계
    - 스프링 빈을 등록하는 2가지 방법
      * 1.컴포넌트 스캔방식
      * 2.자바 코드로 직접 스프링 빈 등록하기
    - 컴포넌트 스캔과 자동 의존관계 설정
      - @Component 에노테이션이 있으면 스프링 빈으로 자동 등록
      - @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 Component 스캔 때문
    - 자바 코드로 직접 스프링 빈 등록하기
      - 기본적으로 동일선상의 패키지나 상위 패키지의 스프링빈은 Component가 스캔하지 않는다.
  
  - 회원 관리 예제 - 웹 MVC개발
    - 회원 웹 기능 - 홈 화면 추가
    - 회원 웹 기능 - 등록
    - 회원 웹 기능 - 조회

  - 스프링 DB 접근 기술
    - H2 데이터베이스 설치
    - 순수 Jdbc
    - 스프링 통합 테스트
    - 스프링 JdbcTemplate
    - JPA
      - JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해 준다.
      -  JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다.
      -  JPA를 사용하면 개발 생산성을 크게 높일 수 있다. 
    - 스프링 데이터 JPA
  -AOP
    - AOP가 필요한 상황
      - 모든 메소드의 호출 시간을 측정
      - 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern) 회원 가입 시간, 회원 조회 시간을 측정
    - AOP적용

    