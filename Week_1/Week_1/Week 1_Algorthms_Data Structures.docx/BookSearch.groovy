import java.util.ArrayList;
import java.util.List;
class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}



public class BookSearch {
    private List<Book> bookList;

    public BookSearch(List<Book> bookList) {
        this.bookList = bookList;
    }

    // Linear Search
    public Book linearSearchByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null; // not found
    }

    // Binary Search (assuming the list is sorted by title)
    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = bookList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midBook = bookList.get(mid);

            if (midBook.getTitle().equals(title)) {
                return midBook;
            } else if (midBook.getTitle().compareTo(title) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // not found
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "To Kill a Mockingbird", "Harper Lee"));
        bookList.add(new Book(2, "1984", "George Orwell"));
        bookList.add(new Book(3, "The Great Gatsby", "F. Scott Fitzgerald"));
        bookList.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
        bookList.add(new Book(5, "The Catcher in the Rye", "J.D. Salinger"));

        // Sort the list by title
        bookList.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));

        BookSearch bookSearch = new BookSearch(bookList);

        // Linear Search
        Book book = bookSearch.linearSearchByTitle("1984");
        if (book != null) {
            System.out.println("Linear Search: Found book " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Linear Search: Book not found");
        }

        // Binary Search
        book = bookSearch.binarySearchByTitle("The Great Gatsby");
        if (book != null) {
            System.out.println("Binary Search: Found book " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Binary Search: Book not found");
        }
    }
}