import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);

    static int[] bookid = new int[15];
    static String[] booktitle = new String[15];
    static String[] authorname = new String[15];
    static String[] publishdate = new String[15];
    static boolean[] issues = new boolean[15];

    public static void main(String[] args) {
        // flow of functions
        bookid[0] = 10;
        bookid[1] = 11;

        for (int i = 2; i < bookid.length; i++) {
            bookid[i] = -1;
            issues[i] = false;

        }

        booktitle[0] = "Rich Dad";
        booktitle[1] = "Theory Of Everything";

        authorname[0] = "Stephan Hawking";
        authorname[1] = "Jordan Paterson";

        publishdate[0] = "12/01/1998";
        publishdate[1] = "30/09/2019";

        issues[0] = false;
        issues[1] = false;

        viewBook();

    }

    public static void viewAllBooks() {
        System.out.println("                          Star Online Library");
        System.out.println("--------------------------------------------------------------");
        System.out.println("sr.no  " + "bookid  " + " Authorname  " + "Publishdate  " + "Issued");

        for (int j = 0; j < bookid.length; j++) {
            if (bookid[j] <= -1)
                return;

            System.out.print(" | ");
            System.out.print(bookid[j] + "   " + booktitle[j] + "   " + authorname[j] + "   " + publishdate[j]
                    + "   " + issues[j] + "\n");
        }

    }

    public static void add() {
        System.out.println("\n--> Add new book");

        int index = -1;

        while (index < 0 || index > 14 || bookid[index] > -1) {
            System.out.print("Enter ID from 1 to 15: ");
            int id = input.nextInt();
            index = id - 1;
            if (index > 14 || index < 0) {
                System.out.println("--> ID is out of range (1 - 15)");
            } else if (bookid[index] > -1) {
                System.out.println("--> ID has already been taken, Please try again with valid ID!!");
            } else {
                bookid[index] = id;
                System.out.print("Enter Book title: ");
                booktitle[index] = input.next();

                System.out.print("Enter Author Name: ");
                authorname[index] = input.next();

                System.out.print("Enter Published Date (DD/MM/YYYY): ");
                publishdate[index] = input.next();

                System.out.println("\n--> Your book has been added successfully!");
                displayBook(index);
                break;
            }
        }
    }

    public static void editBook() {
        System.out.println("\n--> Edit a book");
        int index = -1;
        while (index > 14 || index < 0 || bookid[index] > -1) {
            System.out.print("Enter ID from 1 to 15: ");
            int id = input.nextInt();
            index = id - 1;
            if (index > 14 || index < 0) {
                System.out.println("--> ID is out of range (1 - 15)");
            } else if (bookid[index] > -1) {
                System.out.print("--> Editing book ID: " + id + "\n");
                System.out.print("Enter Book title: ");
                booktitle[index] = input.next();

                System.out.print("Enter Author Name: ");
                authorname[index] = input.next();

                System.out.print("Enter Published Date (DD/MM/YYYY): ");
                publishdate[index] = input.next();

                System.out.println("\n--> Your book has been updated successfully!");
                displayBook(index);
                break;
            } else {
                System.out.println("--> ID does not exist!|n");
            }
        }

    }

    public static void deleteBook() {
        System.out.println("\n--> Delete a book");

        int index = -1;
        while (index > 14 || index < 0 || bookid[index] > -1) {
            System.out.print("Enter ID from 1 to 15: ");
            int id = input.nextInt();
            index = id - 1;
            if (index > 14 || index < 0) {
                System.out.println("--> ID is out of range (1 - 15)");
            } else if (bookid[index] > -1) {
                displayBook(index);

                bookid[index] = -1;
                booktitle[index] = "";
                authorname[index] = "";
                publishdate[index] = "";
                issues[index] = false;
                System.out.println("--> Your book has been deleted successfully!\n");

            } else
                System.out.println("--> Invalid book ID");
        }

    }

    public static void searchById() {
        System.out.print("Enter Id: ");
        int id = input.nextInt();
        int index = id - 1;
        displayBook(index);
    }

    public static void viewBook() {

        int index = -1;

        while (index < 0 || index > 14 || bookid[index] < 0) {
            System.out.print("Enter book ID: ");
            int id = input.nextInt();
            index = id - 1;
            if (index < 0 || index > 14) {
                System.out.println("ID is out of range.");
            } else if (bookid[index] < 0) {
                System.out.println("No book available at this ID.");
            } else if (index > -1 && index < 15) {
                displayBook(index);
                break;
            }

        }

    }

    

    public static void issuebook() {

    }

    public static void printLibMenu() {
        int y = 0;
        while (y != 7) {
            System.out.println(
                    "1. Add new book\n2. Edit a book\n3. Delete a book\n4. View all books\n5. Search a book by ID\n6. See Profile\n7. Exit");
            System.out.print("Enter from 1-7: ");
            y = input.nextInt();
            if (y == 1) {
                add();
            } else if (y == 2) {
                editBook();
            } else if (y == 3) {
                deleteBook();
            } else if (y == 4) {
                viewAllBooks();
            } else if (y == 5) {
                searchById();
            } else if (y > 7 || y < 1) {
                System.out.println("\n--> Invalid input, enter again <--");
            }
        }
        System.out.println("Exiting menu");
    }

    public static void printStudentMenu() {
        System.out.println(
                "1. View a book\n2. Issue a book\n3. Return a book\n4. Search a book\n5. See Profile\n6. Exit");
        System.out.println("Enter from 1-6: ");
        int z = input.nextInt();
        while (z != 6) {
            if (z == 1) {
                viewAllBooks();
            }
        }
    }

    public static void displayBook(int i) {
        System.out.println("----------------");
        System.out.println("ID: " + bookid[i]);
        System.out.println("Book title: " + booktitle[i]);
        System.out.println("Author name: " + authorname[i]);
        System.out.println("Published Dated: " + publishdate[i]);
        if (issues[i]) {
            System.out.println("Issue status: Not available");
        } else {
            System.out.println("Issue status: Available");
        }
        System.out.println("-------------------");

    }
}
