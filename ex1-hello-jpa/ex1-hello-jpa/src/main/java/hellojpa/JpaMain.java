package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager entityManager = emf.createEntityManager();

    EntityTransaction tx = entityManager.getTransaction();

    // 영속성에 대해
    // JPA 는 영속성이라는 메커니즘이 존재한다.
    // db 통신 사이에 영속컨텍스트 에 저장하는 프로세스를 말한다.
    // 영속 컨텍스트에 대해 컨트롤이 가능하다.
    tx.begin();
    try {
      Member member = new Member();
      member.setId("ID_A");
      member.setName("C");
      entityManager.persist(member);
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      entityManager.close();
    }
    emf.close();
  }
}
