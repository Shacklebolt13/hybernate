package app.example.hybernate;

import app.example.hybernate.models.Laptop;
import app.example.hybernate.models.Name;
import app.example.hybernate.models.Person;
import app.example.hybernate.models.Person_;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import lombok.var;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * First Test With Hibernate
 *
 */
public class App {

  ArrayList<Person> persons = new ArrayList<>();

  void addData(Session session) {
    Transaction transaction = session.beginTransaction();

    persons.add(new Person(new Name("pinkey"), "pinkey@gmail.com", "pinkey"));
    persons.add(new Person(new Name("hasib"), "hasib@gmail.com", "hasib"));
    persons.add(new Person(new Name("rishav"), "rishav@gmail.com", "rishav"));
    persons.add(
      new Person(new Name("abhishek"), "abhishek@gmail.com", "abhishek")
    );
    persons.add(new Person(new Name("saumya"), "saumya@gmail.com", "saumya"));
    persons.add(new Person(new Name("gagan"), "gagan@gmail.com", "gagan"));
    persons.add(new Person(new Name("vinay"), "vinay@gmail.com", "vinay"));

    for (Person person : persons) session.save(person);
    Laptop lenovoLaptop = new Laptop("Lenovo");
    persons.get(0).getLaptops().add(lenovoLaptop);

    session.save(lenovoLaptop);

    transaction.commit();
  }

  public static void main(String[] args) {
    Session session1 = new SessionManager().getSession();
    App app = new App();
    app.addData(session1);

    CriteriaBuilder cbuilder = session1.getCriteriaBuilder();
    CriteriaQuery<Object> crit = cbuilder.createQuery(Object.class);

    var root = crit.from(Person.class);

    Join<Person, Laptop> join = root.join(Person_.laptops);

    crit.multiselect(root, join);
    // crit.where(cbuilder.ge(cbuilder.countDistinct(join), 1));
    // crit.where();
    // System.out.println(session1.createQuery(crit).uniqueResult());
    session1.createQuery(crit).getResultList().forEach(System.out::println);
  }
}
