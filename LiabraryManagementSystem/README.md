# Library Management System
 
This Java program implements a simple Library Management System. Users can perform the following actions:
 
1. Add a Book
2. Search for Books
3. Register a Member
4. Checkout a Book
5. Return a Book
6. Exit
 
## Classes
### 1. Book
- Attributes:
  - Title
  - Author
  - ISBN
  - Availability status
- Methods:
  - `getTitle()`
  - `getAuthor()`
  - `getISBN()`
  - `isAvailable()`
  - `toggleAvailability()`
 
### 2. Member
- Attributes:
  - Name
  - Email
  - List of borrowed books
- Methods:
  - `getName()`
  - `getEmail()`
  - `checkoutBook(Book book)`
  - `returnBook(Book book)`
 
### 3. Assert
- Helper class for assertion checks
 
## Running the Program
- Upon running `LibraryManagementSystem.java`, the main method creates an instance of `LibraryManagementSystem` and starts the system.
- Users can interact with the system through the menu options displayed, entering their choices via the console input.
 
## How to Use
1. Enter a number corresponding to the action you want to perform.
2. Follow the prompts to input necessary details (e.g., book information or member details).
3. The system will provide feedback based on the actions taken (e.g., book added, member registered, book checked out or returned).
 