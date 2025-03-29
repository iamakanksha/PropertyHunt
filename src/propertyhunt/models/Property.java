package propertyhunt.models;

import java.util.HashSet;
import java.util.Set;

public class Property {
  private static int idCounter = 1;

  private int id;
  private String title;
  private String location;
  private int price;
  private String type;
  private int size;
  private String sizeUnit;
  private String rooms;
  private boolean isSold;
  private String owner;
  private Set<String> nearbyLocations;

  public Property(String title, String location, int price, String type, int size, String sizeUnit, String rooms, String owner, Set<String> nearbyLocations) {
    this.id = idCounter++;
    this.title = title;
    this.location = location.toLowerCase();
    this.price = price;
    this.type = type.toLowerCase();
    this.size = size;
    this.sizeUnit = sizeUnit.toLowerCase();
    this.rooms = rooms;
    this.isSold = false;
    this.owner = owner;
    this.nearbyLocations = nearbyLocations != null ? nearbyLocations : new HashSet<>();
  }

  public int getId() { return id; }
  public String getTitle() { return title; }
  public String getLocation() { return location; }
  public int getPrice() { return price; }
  public String getType() { return type; }
  public int getSize() { return size; }
  public String getSizeUnit() { return sizeUnit; }
  public String getRooms() { return rooms; }
  public boolean isSold() { return isSold; }
  public String getOwner() { return owner; }
  public Set<String> getNearbyLocations() { return nearbyLocations; }

  public void markSold() { this.isSold = true; }

  @Override
  public String toString() {
    return id + "\t" + title + "\t" + location + "\t" + price + "\t" + size + sizeUnit + "\t" + rooms + "\t" + type + (isSold ? "\t[SOLD]" : "");
  }
}
