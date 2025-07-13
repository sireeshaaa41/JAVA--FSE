import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    // Book class representing individual books
    static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        // Getters
        public String getBookId() { return bookId; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }

        @Override
        public String toString() {
            return String.format("ID: %-6s | Title: %-25s | Author: %-20s", 
                    bookId, title, author);
        }
    }

    // Library class containing book collection and search methods
    static class Library {
        private Book[] books;
        private Book[] sortedBooks; // For binary search

        public Library(Book[] books) {
            this.books = books;
            // Create a sorted copy for binary search
            this.sortedBooks = Arrays.copyOf(books, books.length);
            Arrays.sort(sortedBooks, Comparator.comparing(Book::getTitle));
        }

        // Linear Search by Title - O(n)
        public Book linearSearchByTitle(String title) {
            System.out.println("\nPerforming Linear Search for: " + title);
            int comparisons = 0;
            for (Book book : books) {
                comparisons++;
                if (book.getTitle().equalsIgnoreCase(title)) {
                    System.out.println("Comparisons made: " + comparisons);
                    return book;
                }
            }
            System.out.println("Comparisons made: " + comparisons);
            return null;
        }

        // Binary Search by Title - O(log n)
        public Book binarySearchByTitle(String title) {
            System.out.println("\nPerforming Binary Search for: " + title);
            int comparisons = 0;
            int left = 0;
            int right = sortedBooks.length - 1;

            while (left <= right) {
                comparisons++;
                int mid = left + (right - left) / 2;
                int comparisonResult = sortedBooks[mid].getTitle().compareToIgnoreCase(title);

                if (comparisonResult == 0) {
                    System.out.println("Comparisons made: " + comparisons);
                    return sortedBooks[mid];
                } else if (comparisonResult < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println("Comparisons made: " + comparisons);
            return null;
        }

        // Display all books
        public void displayBooks() {
            System.out.println("\nLibrary Catalog:");
            for (Book book : books) {
                System.out.println(book);
            }
        }

        // Display sorted books (for binary search verification)
        public void displaySortedBooks() {
            System.out.println("\nBooks Sorted by Title:");
            for (Book book : sortedBooks) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        // Create sample books (intentionally unsorted)
        Book[] bookArray = {
            new Book("B1003", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B1001", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B1005", "1984", "George Orwell"),
            new Book("B1002", "Pride and Prejudice", "Jane Austen"),
            new Book("B1004", "The Hobbit", "J.R.R. Tolkien")
        };

        Library library = new Library(bookArray);

        // Display books
        library.displayBooks();
        library.displaySortedBooks();

        // Search demonstrations
        System.out.println("\n--- Search Performance Comparison ---");

        // Search existing books
        System.out.println("\n[Search for '1984']");
        Book linearResult1 = library.linearSearchByTitle("1984");
        System.out.println("Linear Search Result: " + linearResult1);
        Book binaryResult1 = library.binarySearchByTitle("1984");
        System.out.println("Binary Search Result: " + binaryResult1);

        System.out.println("\n[Search for 'Pride and Prejudice']");
        Book linearResult2 = library.linearSearchByTitle("Pride and Prejudice");
        System.out.println("Linear Search Result: " + linearResult2);
        Book binaryResult2 = library.binarySearchByTitle("Pride and Prejudice");
        System.out.println("Binary Search Result: " + binaryResult2);

        // Search non-existent book
        System.out.println("\n[Search for 'Non-existent Book']");
        Book linearResult3 = library.linearSearchByTitle("Non-existent Book");
        System.out.println("Linear Search Result: " + linearResult3);
        Book binaryResult3 = library.binarySearchByTitle("Non-existent Book");
        System.out.println("Binary Search Result: " + binaryResult3);

        // Algorithm analysis
        System.out.println("\n--- Search Algorithm Analysis ---");
        System.out.println("Linear Search:");
        System.out.println("- Time Complexity: O(n) in all cases");
        System.out.println("- Works on unsorted data");
        System.out.println("- Simple implementation");
        System.out.println("- Efficient for small datasets");

        System.out.println("\nBinary Search:");
        System.out.println("- Time Complexity: O(log n) in average and worst case");
        System.out.println("- Requires sorted data (O(n log n) preprocessing)");
        System.out.println("- More complex implementation");
        System.out.println("- Much more efficient for large datasets");

        System.out.println("\nWhen to Use Each Algorithm:");
        System.out.println("- Use Linear Search when:");
        System.out.println("  * Data is unsorted");
        System.out.println("  * Dataset is small");
        System.out.println("  * You need simple implementation");
        System.out.println("  * You search infrequently");

        System.out.println("- Use Binary Search when:");
        System.out.println("  * Data can be sorted in advance");
        System.out.println("  * Dataset is large");
        System.out.println("  * You need maximum search performance");
        System.out.println("  * You search frequently");

        System.out.println("\nFor a Library Management System:");
        System.out.println("- Binary search is recommended for the main catalog");
        System.out.println("- Consider maintaining multiple sorted indices for different search criteria");
        System.out.println("- For very small libraries (<100 books), linear search may be sufficient");
    }
}
