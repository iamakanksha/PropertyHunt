package propertyhunt.repositories;

import propertyhunt.models.Property;
import java.util.*;

public class PropertyRepository {
  private static PropertyRepository instance;
  private Map<Integer, Property> properties = new HashMap<>();

  private PropertyRepository() {} // Private constructor to prevent multiple instances

  public static PropertyRepository getInstance() {
    if (instance == null) {
      instance = new PropertyRepository();
    }
    return instance;
  }
  public void save(Property property) {
    properties.put(property.getId(), property);
  }

  public List<Property> findAll() {
    return new ArrayList<>(properties.values());
  }

  public Property findById(int propertyId) {
    return properties.get(propertyId);
  }

  public void update(Property property) {
    properties.put(property.getId(), property);
  }
}
