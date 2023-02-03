package app.example.hybernate;

import app.example.hybernate.models.Laptop;
import app.example.hybernate.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {

  SessionFactory sessionFactory;

  public Session getSession() {
    if (this.sessionFactory != null) {
      return this.sessionFactory.openSession();
    } else {
      Configuration cnfg = new Configuration()
        .addAnnotatedClass(Person.class)
        .addAnnotatedClass(Laptop.class);
      cnfg.setProperties(HibernateProperties.properties);
      SessionFactory sf = cnfg.buildSessionFactory();
      this.sessionFactory = sf;
    }

    return this.sessionFactory.openSession();
  }
}
