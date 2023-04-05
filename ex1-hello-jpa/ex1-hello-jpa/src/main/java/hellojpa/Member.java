package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

  @Id
  private Long id;
  @Column(name = "name")
  private String username;

  private Integer age;

  // JPA 에서 Enum Type 을 쓰고싶을때는 Enumerated 쓴다
  // Enum type 에서는 EnumType.ORDINAL 을 쓰게 되면 굉장히 위험하다.
  // 예시) RoleType 을 user와 admin 이 존재 할 때 Guest 를 추가 했을 시 데이터가 제대로 입력이 안될 수 가 있다.
  // EnumType.STRING 를 반드시 넣어 주는 것이 권장한다.
  //
  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  // 날짜타입은 수정일자, 생성일자, type이 3가지가 존재한다.
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;

  //varchar를 넘어서는 큰 컨텐츠를 저장시 Lob를 쓴다.
  @Lob
  private String description;

}
