import com.sao.hibernate.data.Person;
import com.sao.hibernate.data.PostIt;
import com.sao.hibernate.data.User;
import com.sao.hibernate.database.HibernateUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author saozd
 * @project com.sao.hibernate.database courseexample
 * 18.04.2023 Nis 2023
 */
public class MainTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Ahmet");
        person.setSurname("Özdemir");

        PostIt postIt = new PostIt();
        postIt.setPost("Deneme postit");

        User user = new User();
        user.setUserName("AOZDEMIR");
        user.setPerson(person);

        Session session = null;
        Transaction transaction = null;
        try {
            //BasicConfigurator.configure();
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
//            session.merge(person);
//            session.merge(postIt);
            session.merge(user);
//            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }


        Person tempPerson1 = null;
        Person tempPerson2 = null;
        User tempUser1 = null;
        User tempUser2 = null;

        try {
            //BasicConfigurator.configure();
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            //tempUser1 = session.find(User.class, user.getId());
            tempUser1 = (User) session.get(User.class, 1L);
            if (tempUser1 != null) {
                tempPerson1 = tempUser1.getPerson();
            }

            if (tempPerson1 != null) {
                tempPerson2 = session.find(Person.class, tempPerson1.getId());
                if (tempPerson2 != null) {
                    tempUser2 = tempPerson2.getUser();
                }
            }

            System.out.println(tempPerson1.getName());
            System.out.println(tempUser2.getUserName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
