package propertyhunt;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    PlatformUtil platform = new PlatformUtil();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("→ ");
      String command = scanner.nextLine();
      String[] parts = command.split(" ", 2);
      String action = parts[0].toLowerCase();

      switch (action) {
        case "register":
          platform.register(parts[1]);
          break;
        case "login":
          platform.login(parts[1]);
          break;
        case "listproperty":
          platform.listProperty(parts[1]);
          break;
        case "search":
          platform.search();
          break;
        case "marksold":
          platform.markSold(Integer.parseInt(parts[1]));
          break;
        case "logout":
          platform.logout();
          break;
        case "shortlist":
          platform.shortListProperty(Integer.parseInt(parts[1]));
          break;
        case "viewshortlist":
          platform.getShortlistedProperty();
          break;
        case "exit":
          System.out.println("Exiting...");
          return;
        default:
          System.out.println("Invalid command.");
      }
    }
  }
}
