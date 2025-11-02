package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter library capacity: ");
        int n = sc.nextInt();
        sc.nextLine();

        Library library = new Library(n);

        library.add(new Novel("Novel", "Victor Hugo", 200, 15.5));
        library.add(new Dictionary("Oxford", "English"));

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Document");
            System.out.println("2. Display Documents");
            System.out.println("3. Delete Document");
            System.out.println("4. Display Authors");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter pages: ");
                    int pages = sc.nextInt();
                    sc.nextLine();
                    library.add(new Book(title, author, pages));
                }
                case 2 -> library.displayDocuments();
                case 3 -> {
                    System.out.print("Enter document number to delete: ");
                    int num = sc.nextInt();
                    Document doc = library.document(num);
                    if (doc != null && library.delete(doc))
                        System.out.println("Deleted successfully.");
                    else
                        System.out.println("Document not found.");
                }
                case 4 -> library.displayAuthors();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}

