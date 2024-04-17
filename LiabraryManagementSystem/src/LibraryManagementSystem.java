import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LibraryManagementSystem {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.run();
    }
    
    private void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
    
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBooks();
                    break;
                case 3:
                    registerMember();
                    break;
                case 4:
                    checkoutBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Search Books");
        System.out.println("3. Register Member");
        System.out.println("4. Checkout Book");
        System.out.println("5. Return Book");
        System.out.println("6. Exit");
    }
    
    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        try {
            return Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a number.");
        }
    }
    
    private void addBook() {
        System.out.print("Enter book title: ");
        String title = System.console().readLine();
        System.out.print("Enter book author: ");
        String author = System.console().readLine();
        System.out.print("Enter book ISBN: ");
        String isbn = System.console().readLine();
    
        Book book = new Book(title, author, isbn);
        books.add(book);
        System.out.println("Added book: " + book.getTitle() + " by " + book.getAuthor());
    }
    
    private void searchBooks() {
        System.out.print("Enter search term (title or author): ");
        String searchTerm = System.console().readLine().toLowerCase();
    
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm) || book.getAuthor().toLowerCase().contains(searchTerm)) {
                matchingBooks.add(book);
            }
        }
    
        if (matchingBooks.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Matching books:");
            for (Book book : matchingBooks) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
    
    private void registerMember() {
        System.out.print("Enter member name: ");
        String name = System.console().readLine();
        System.out.print("Enter member email: ");
        String email = System.console().readLine();
    
        try {
            Member member = new Member(name, email);
            members.add(member);
            System.out.println("Registered new member: " + member.getName() + " (" + member.getEmail() + ")");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void checkoutBook() {
        System.out.print("Enter member name: ");
        String memberName = System.console().readLine();
        System.out.print("Enter book title: ");
        String bookTitle = System.console().readLine();
    
        Member member = null;
        for (Member m : members) {
            if (m.getName().equals(memberName)) {
                member = m;
                break;
            }
        }
    
        Book book = null;
        for (Book b : books) {
            if (b.getTitle().equals(bookTitle)) {
                book = b;
                break;
            }
        }
    
        if (member == null) {
            System.out.println("Member '" + memberName + "' not found.");
            return;
        }
    
        if (book == null) {
            System.out.println("Book '" + bookTitle + "' not found.");
            return;
        }
    
        try {
            member.checkoutBook(book);
            System.out.println(member.getName() + " checked out '" + book.getTitle() + "'.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void returnBook() {
        System.out.print("Enter member name: ");
        String memberName = System.console().readLine();
        System.out.print("Enter book title: ");
        String bookTitle = System.console().readLine();
    
        Member member = null;
        for (Member m : members) {
            if (m.getName().equals(memberName)) {
                member = m;
                break;
            }
        }
    
        Book book = null;
        for (Book b : books) {
            if (b.getTitle().equals(bookTitle)) {
                book = b;
                break;
            }
        }
    
        if (member == null) {
            System.out.println("Member '" + memberName + "' not found.");
            return;
        }
    
        if (book == null) {
            System.out.println("Book '" + bookTitle + "' not found.");
            return;
        }
    
        try {
            member.returnBook(book);
            System.out.println(member.getName() + " returned '" + book.getTitle() + "'.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static class Book {
        private String title;
        private String author;
        private String isbn;
    
        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
    
        public String getTitle() {
            return title;
        }
    
        public String getAuthor() {
            return author;
        }
    
        public String getISBN() {
            return isbn;
        }
    }
    
    private static class Member {
        private String name;
        private String email;
    
        public Member(String name, String email) {
            this.name = name;
            this.email = email;
        }
    
        public String getName() {
            return name;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void checkoutBook(Book book) {
            System.out.println("Not implemented.");
            
        }
    
        public void returnBook(Book book) {
            System.out.println("Not implemented.");
    
        }
    }
}
