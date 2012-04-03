import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

public class Main {
  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAService");
  static EntityManager em = emf.createEntityManager();

  public static void main(String[] a) throws Exception {
    
	  Logger log = Logger.getLogger(Main.class);
	  log.warn("LOL");
	  
    em.getTransaction().begin();
    
    
    Student student = new Student();
   // student.setId(1);
    student.setName("Joe");
   // student.setSurname("XXX");
    student.setDateOfBirth(new Date());
    student.setGender(Gender.FEMALE);
    
    em.persist(student);
    em.flush();
    
    Student st = em.find(Student.class, student.getId());    
    System.out.println(st);
    
    em.getTransaction().commit();

    em.close();
    emf.close();
    
    //Helper.checkData();
  }
}
