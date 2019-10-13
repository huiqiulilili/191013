package classes;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private double price;
    private int currentCount;
    private int totalCount;
    private int borrowedCount;
    public Book(String ISBN,String title,String author,double price,int count){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.currentCount = count;
        this.totalCount = count;
        this.borrowedCount = 0;
    }


    public boolean is(String ISBN) {
        return this.ISBN.equals(ISBN);
    }

    public void increaseCount(int count) {
        currentCount += count;
        totalCount += count;
    }



    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void borrowBook() {
        currentCount--;
        borrowedCount++;
    }
}