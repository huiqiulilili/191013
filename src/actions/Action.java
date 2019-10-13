package actions;

import classes.Book;
import classes.User;
import databases.BookShelf;
import databases.RecordShelf;
import exceptions.BorrowedOutException;
import exceptions.NoSuchBookException;
import exceptions.YetBorrowedException;

import java.util.List;

public class Action {

    public static Book putBook(String ISBN, String title, String author, double price, int count)  {
        BookShelf bookShelf = BookShelf.getInstance();
        try {
            Book book = bookShelf.search(ISBN);
            book.increaseCount(count);
            return book;
        } catch (NoSuchBookException exc) {
            Book book = new Book(ISBN, title, author, price, count);
            bookShelf.putBook(book);
            return book;
        }
    }


    public static List<Book> queryBooks() {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBooks();
    }

    public static Book borrowBook(User user, String ISBN) throws NoSuchBookException, BorrowedOutException, YetBorrowedException {
        BookShelf bookShelf = BookShelf.getInstance();
        RecordShelf recordShelf = RecordShelf.getInstance();
        Book book = bookShelf.search(ISBN);
        if(book.getCurrentCount() <= 0){
            throw new BorrowedOutException();
        }
        if (recordShelf.contains(user, ISBN)) {
            throw new YetBorrowedException();
        }
        book.borrowBook();
        recordShelf.putRecord(user,ISBN);
        return book;
    }
}
