package propertyhunt.models;

import java.util.HashSet;
import java.util.Set;

public class User {
  private String name;
  private boolean isActive;
  private Set<Integer> shortlistedProperties;

  public User(String name) {
    this.name = name.toLowerCase();
    this.isActive = true;
    this.shortlistedProperties = new HashSet<>();
  }

  public String getName() { return name; }
  public boolean isActive() { return isActive; }
  public Set<Integer> getShortlistedProperties() { return shortlistedProperties; }

  public void deactivate() { this.isActive = false; }
  public void activate() { this.isActive = true; }

  public void shortlist(int propertyId) { shortlistedProperties.add(propertyId); }
}
