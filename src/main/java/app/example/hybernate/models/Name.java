package app.example.hybernate.models;

import java.util.Arrays;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Name {

  @NonNull
  private String fname;

  private String mname;
  private String lname;

  public String getFullName() {
    return String.join(" ", Arrays.asList(fname, mname, lname));
  }
}
