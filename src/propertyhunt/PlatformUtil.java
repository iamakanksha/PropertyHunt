package propertyhunt;

import propertyhunt.models.Property;
import propertyhunt.models.User;
import propertyhunt.services.PropertyService;
import propertyhunt.services.UserService;
import java.util.*;

/**
 * Aggregator for all service layer
 */
public class PlatformUtil {
  private UserService userService = new UserService();
  private PropertyService propertyService = new PropertyService();

  public void register(String name) {
    userService.register(name);
  }

  public void login(String name) {
    userService.login(name);
  }

  public void logout() {
    userService.logout();
  }

  public void listProperty(String details) {
    User user = userService.getCurrentUser();
    if (user == null) {
      System.out.println("You must be logged in to list a property.");
      return;
    }

    String[] parts = details.split(", ");
    if (parts.length < 6) {
      System.out.println("Invalid property details format.");
      return;
    }

    Property property = new Property(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4]), "sqft", parts[5], user.getName(), new HashSet<>());
    propertyService.listProperty(property);
  }

  public void search() {
    propertyService.search();
  }

  public void markSold(int propertyId) {
    User user = userService.getCurrentUser();
    if (user == null) {
      System.out.println("You must be logged in to mark properties as sold.");
      return;
    }
    propertyService.markSold(propertyId, user.getName());
  }

  public void getShortlistedProperty() {
    User user = userService.getCurrentUser();
    if (user == null) {
      System.out.println("You must be logged in to view shortlisted properties.");
      return;
    }

    propertyService.getShortlist(user);
  }
  public void shortListProperty(int propertyId) {
    User user = userService.getCurrentUser();
    if (user == null) {
      System.out.println("You must be logged in to shortlist properties.");
      return;
    }

    userService.shortlist(user, propertyId);
  }
}

