package app.example.hybernate;

import app.example.hybernate.models.User;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    User user = new User(1, "gagan", "grimmgagan@gmail.com", "gagan");

    System.out.println(user.toString());
  }
}
