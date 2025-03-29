package propertyhunt.repositories;

import propertyhunt.models.User;

import java.util.*;

public class UserRepository {
  private static UserRepository instance;
  private Map<String, User> users = new HashMap<>();

  private UserRepository() {} // Private constructor to prevent multiple instances

  public static UserRepository getInstance() {
    if (instance == null) {
      instance = new UserRepository();
    }
    return instance;
  }
  public void save(User user) {
    users.put(user.getName(), user);
  }

  public User findByName(String name) {
    System.out.println(users);
    return users.get(name);
  }

  public boolean exists(String name) {
    return users.containsKey(name);
  }
}
