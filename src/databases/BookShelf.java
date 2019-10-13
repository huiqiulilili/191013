package databases;

import actions.Action;
import classes.Book;
import exceptions.NoSuchBookException;

import java.util.*;

public class BookShelf {
    private List<Book> bookList = new ArrayList<>();

    private static BookShelf instance = new BookShelf();

    public static BookShelf getInstance() {
        return instance;
    }

    public Book search(String ISBN) throws NoSuchBookException {
        for (Book book:bookList) {
            if(book.is(ISBN)){
                return book;
            }
        }
        throw new NoSuchBookException(ISBN);
    }

    public void putBook(Book book) {
        bookList.add(book);
    }


    public List<Book> queryBooks() {
        return bookList;
    }


}
