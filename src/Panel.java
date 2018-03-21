/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filip
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Panel {

    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;
    private Scanner reader;

    public Panel() {
        planes = new ArrayList<Plane>();
        flights = new ArrayList<Flight>();
        reader = new Scanner(System.in);
    }

    public void AirportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");

        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            String command = reader.nextLine();
            if (command.equals("1")) {
                addAirplane();
            } else if (command.equals("2")) {
                addFlight();
            } else if (command.equals("x")) {
                System.out.println("");
                break;
            }
        }
    }

    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        Plane plane = new Plane(ID, capacity);
        planes.add(plane);
    }

    private void addFlight() {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        for (Plane plane : planes) {
            if (ID.equals(plane.getID())) {
                System.out.print("Give departure airport code: ");
                String departure = reader.nextLine();
                System.out.print("Give destination airport code: ");
                String destination = reader.nextLine();
                Flight flight = new Flight(plane, departure, destination);
                flights.add(flight);
            }
        }
    }

    public void FlightService() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");

        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String command = reader.nextLine();
            if (command.equals("1")) {
                printPlanes();
            } else if (command.equals("2")) {
                printFlights();
            } else if (command.equals("3")) {
                printInfo();
            } else if (command.equals("x")) {
                System.out.println("");
                break;
            }
        }
    }
    
    private void printPlanes() {
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }
    
    private void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
    
    private void printInfo() {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        for (Plane plane : planes) {
            if (ID.equals(plane.getID())) {
                System.out.println(plane);
            }
        }
    }
}
