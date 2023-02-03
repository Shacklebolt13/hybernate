package app.example.hybernate.models;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Getter
@Setter
@NoArgsConstructor
// @Cacheable
// @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Laptop {

  @Id
  @GeneratedValue
  private int id;

  private String brand;

  @ManyToOne(cascade = CascadeType.ALL)
  private Person person;

  public Laptop(String model) {
    this.brand = model;
  }

  @Override
  public String toString() {
    return (
      "Laptop [id=" +
      id +
      ", brand=" +
      brand +
      ", person=" +
      (person != null) +
      "]"
    );
  }
}
