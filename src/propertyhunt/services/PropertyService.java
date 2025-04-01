package propertyhunt.services;

import propertyhunt.models.Property;
import propertyhunt.models.User;
import propertyhunt.repositories.PropertyRepository;
import java.util.*;

public class PropertyService {
  private PropertyRepository propertyRepository = PropertyRepository.getInstance();

  public void listProperty(Property property) {
    propertyRepository.save(property);
    System.out.println("Listing created successfully.");
  }

  public void search() {
    List<Property> properties = propertyRepository.findAll();
    if (properties.size() < 1) {
      System.out.println("No properties available at the moment!");
      return ;
    }
    System.out.println("ID \t TITLE \t LOCATION \t PRICE \t SIZE \t ROOMS \t TYPE \t SOLD STATUS \n");
    properties.forEach(System.out::println);
  }

  public void markSold(int propertyId, String owner) {
    Property property = propertyRepository.findById(propertyId);
    if (property == null || !property.getOwner().equalsIgnoreCase(owner)) {
      System.out.println("Property not found or unauthorized.");
      return;
    }
    property.markSold();
    propertyRepository.update(property);
    System.out.println("Property marked as SOLD.");
  }

  public void getShortlist(User user) {
    Set<Integer> shortlistedProperties = user.getShortlistedProperties();
    if (shortlistedProperties.isEmpty()) {
      System.out.println("No properties shortlisted!");
    }

    for (int propertyId: shortlistedProperties) {
      Property property = propertyRepository.findById(propertyId);
      System.out.println(property.toString());
    }
  }
}
