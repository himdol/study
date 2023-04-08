package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Member_Back {


  // Identity 전략은 null로 넘어 올때 값을 넣는다. 따라서 DB에 들어가야지만 알수가 있다.
  @Id
  private String Id;



  @Column(name = "name", nullable = true)
  private String name;

  public Member_Back() {
  }

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
