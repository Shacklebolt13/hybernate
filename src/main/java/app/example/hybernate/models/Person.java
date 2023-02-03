package app.example.hybernate.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
// @Cacheable
// @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Person {

  @Id
  @GeneratedValue
  private int id;

  private Name name;
  private String email;
  private String password;

  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
  private Set<Laptop> laptops = new HashSet<>();

  public Person(Name name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
