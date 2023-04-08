package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();

    // 영속성에 대해
    // JPA 는 영속성이라는 메커니즘이 존재한다.
    // db 통신 사이에 영속컨텍스트 에 저장하는 프로세스를 말한다.
    // 영속 컨텍스트에 대해 컨트롤이 가능하다.
    tx.begin();
    try {

      Member member = new Member();
      member.setName("member1");
//      member.setTeamId(team.getId());
      em.persist(member);
      em.flush();
      em.close();

      //조회
      Member findMember = em.find(Member.class, member.getId());
      //연관관계가 없음
//      Team findTeam = em.find(Team.class, team.getId());



      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
