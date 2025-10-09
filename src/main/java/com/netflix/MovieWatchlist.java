package com.netflix;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MovieWatchlist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Start with an empty watchlist (no sample data)
        ArrayList<String> watchlist = new ArrayList<>();
        HashMap<String, Double> ratings = new HashMap<>();
        boolean running = true;
        System.out.println(" Welcome to your Movie Watchlist!");
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a movie");
            System.out.println("2. Display all the movies");
            System.out.println("3. Give a movie a rating");
            System.out.println("4. Done with movielist ");


            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear ENTER
            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String movie = scanner.nextLine();
                    watchlist.add(movie);
                    System.out.println(movie + " added to your watchlist!");
                    try {
                        FileWriter writer = new FileWriter("src/main/resources/Movielist.txt");
                        writer.write(watchlist.toString());
                        writer.close();
                    }
                    catch(IOException e) {
                        System.out.println("womp womp error");
                    }
                    break;
                case 2:
                    System.out.println("\n Your watchlist:");
                    if (watchlist.isEmpty()) {
                        System.out.println("No movies yet — add some first!");
                    } else {
                        for (String movies : watchlist) {

                            String rating = ratings.containsKey(movies)
                                    ? "⭐" + ratings.get(movies)
                                    : "Not rated yet";
                            System.out.println("- " + movies + " (" + rating + ")");
                        }
                        System.out.println("Total movies: " + watchlist.size());
                    }
                    break;
                case 3:
                    System.out.print("Enter movie to rate: ");
                    String rateMovie = scanner.nextLine();
                    if (watchlist.contains(rateMovie)) {
                        System.out.print("Enter rating (0-10): ");
                        double rate = scanner.nextDouble();
                        scanner.nextLine();
                        ratings.put(rateMovie, rate);
                        System.out.println(rateMovie + " rated " + rate + "⭐!");
                    } else {
                        System.out.println("Movie not found in your watchlist.");
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println(" Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
