package propertyhunt.services;

import propertyhunt.models.User;
import propertyhunt.repositories.UserRepository;

import java.util.Set;

public class UserService {
  private UserRepository userRepository = UserRepository.getInstance(); // Shared instance
  private static User currentUser = null;

  public void register(String name) {
    if (userRepository.exists(name)) {
      System.out.println("User already exists.");
    } else {
      userRepository.save(new User(name));
      System.out.println("User registered successfully.");
    }
  }

  public void login(String name) {
    User user = userRepository.findByName(name.toLowerCase());
    if (user == null) {
      System.out.println("User not found. Please register.");
    } else {
      currentUser = user;
      currentUser.activate();
      System.out.println("Welcome " + name);
    }
  }

  public void logout() {
    if (currentUser == null) {
      System.out.println("You aren't logged in.");
    } else {
      currentUser.deactivate();
      System.out.println("Logged out successfully.");
      currentUser = null;
    }
  }

  public void shortlist(User user, int propertyId) {
    user.shortlist(propertyId);
  }

  public User getCurrentUser() { return currentUser; }
}

