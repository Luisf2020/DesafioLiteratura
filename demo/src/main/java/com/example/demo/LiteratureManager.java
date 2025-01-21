package com.oracleone.literature;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LiteratureManager {

    private static class Book {
        private int id;
        private String title;
        private String author;
        private int year;

        public Book(int id, String title, String author, int year) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public int getId() {
            return id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return "[ID: " + id + "] Title: " + title + ", Author: " + author + ", Year: " + year;
        }
    }

    private static class BookController {
        private final List<Book> books = new ArrayList<>();
        private int nextId = 1;

        public void addBook(String title, String author, int year) {
            books.add(new Book(nextId++, title, author, year));
            System.out.println("Book added successfully.");
        }

        public void listBooks() {
            if (books.isEmpty()) {
                System.out.println("No books available.");
                return;
            }
            books.forEach(System.out::println);
        }

        public void editBook(int id, String newTitle, String newAuthor, int newYear) {
            for (Book book : books) {
                if (book.getId() == id) {
                    book.setTitle(newTitle);
                    book.setAuthor(newAuthor);
                    book.setYear(newYear);
                    System.out.println("Book updated successfully.");
                    return;
                }
            }
            System.out.println("Book with ID " + id + " not found.");
        }

        public void deleteBook(int id) {
            books.removeIf(book -> book.getId() == id);
            System.out.println("Book deleted successfully.");
        }

        public void searchBooksOnline(String query) {
            try {
                String apiUrl = "https://gutendex.com/books?search=" + query;
                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();
                conn.disconnect();

                JsonObject jsonResponse = JsonParser.parseString(content.toString()).getAsJsonObject();
                JsonArray results = jsonResponse.getAsJsonArray("results");

                System.out.println("\n--- Search Results ---");
                for (JsonElement element : results) {
                    JsonObject book = element.getAsJsonObject();
                    String title = book.get("title").getAsString();
                    JsonArray authors = book.getAsJsonArray("authors");
                    String author = authors.size() > 0 ? authors.get(0).getAsJsonObject().get("name").getAsString() : "Unknown";
                    System.out.println("Title: " + title + ", Author: " + author);
                }
            } catch (Exception e) {
                System.out.println("An error occurred while searching online: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        BookController controller = new BookController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Literature Manager ---");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Edit Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Search Books Online");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    controller.addBook(title, author, year);
                    break;
                case 2:
                    controller.listBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new year: ");
                    int newYear = scanner.nextInt();
                    controller.editBook(editId, newTitle, newAuthor, newYear);
                    break;
                case 4:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteBook(deleteId);
                    break;
                case 5:
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();
                    controller.searchBooksOnline(query);
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
