✨ 회원가입 구현
====================
- ## 📚 공부
  - 전화번호 형식 검증
    - @Pattern : 형식을 검증하는 어노테이션
    - ```@Pattern(regexp = "\\d{3}\\d{4}\\d{4}",message = "전화번호 형식을 맞춰주세요")```
- ## 🐛 이슈
  - ### 프로젝트를 중지 했다가 다시 실행하면 ID가 50씩 증가되었다
    - Done (2024.05.11)
      - 기본키를 생성해주는 **@GeneratedValue**에는 여러개의 전략이 존재함
      - 대표적으로는 IDENTITY와 SEQUENCE
      - IDENTITY : 기본 키 생성을 DB에 위임하는 전략 -> **<u> 근데 이걸로 하면 500 error가 발생했음 왜지?</u>**
      - SEQUENCE :Sequence를 사용하여 기본키를 할당하는 방식
      ```
      @Entity
      @SequenceGenerator(
      name = "ID", //식별자 생성기 이름
      sequenceName = "ID_SEQ", //DB에 등록되어 있는 Sequence 이름
      initialValue = 1, //처음 시작 value 설정
      allocationSize = 1 //Sequence 한번 호출 시 증가하는 수
      //allocationSize가 기본값이 50이므로 1로 설정하지 않을 시, sequence 호출 시 마다 50씩 증가 -> 내가 마주한 이슈
      )
      @Table(name="MEMBERS")
      @Builder
      public class Account extends BaseEntity
      {
      @Id
      //기본키 생성
      @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "ID"
      )
      @Column(name="ID")
      private Long id;
      ```
        Entity를 생성할 때 @SequenceGenerator를 사용
        @SequenceGenerator에는 다양한 속성이 있는데
        그 중에서 **allocationSize**가 기본값이 50이기 때문에 해당 속성을 1로 설정하지 않을 시, sequence 호출 시마다 50씩 증가된 것 이었다.
    - 참조 : <https://velog.io/@gillog/JPA-기본-키-생성-전략IDENTITY-SEQUENCE-TABLE>
  - ### createAt이 null로 나옴
    - Progress

✨ 로그인 기능 구현
==================
- ## 📚 공부

 - ## 🐛 이슈
   - ### createAt이 null로 나옴
     - Progress

✨ 회원탈퇴 기능 구현 
=====================
- ## 📚 공부
  - ### JpaRepository
    - 내일 정리할래..졸려..
- ## 🐛 이슈
  - ### 400 BAD_REQUEST 오류 발생
    - Done (2024.05.12)
      - ***요청 보낼 데이터를 @RequestBody로 Body로 넣어서 보내려고 했기 때문에*** 발생한 오류
      - HTTP DELETE 메소드는 Request Body를 지원하지 않음
      - 주로 **Path나 쿼리 파라미터**를 통해 요청 데이터 전달
      - <u>@RequestParam</u>로 바꿔서 요청 URL를 ```http://localhost:8080/api/member/withdraw?userId=1``` 이렇게 했더니 해결👏🏻👏🏻
      - <u>@PathVariable</u>로도 바꿔서 요청 URL를 ```http://localhost:8080/api/member/withdraw/1``` 이렇게 했을 때도 성공 👏🏻👏🏻