package classes;

import actions.Action;
import exceptions.BorrowedOutException;
import exceptions.NoSuchBookException;
import exceptions.YetBorrowedException;

import java.util.Scanner;

public class Student extends User {

    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("** 同学，请选择 **");
        System.out.println("** 0.退出 **");
        System.out.println("** 1.查阅图书 **");
        System.out.println("** 2.借阅图书 **");
        System.out.println("** 3.查阅记录 **");
        System.out.println("** 4.归还图书 **");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        switch (selected) {
            case 0:
                return true;
            case 1:
                queryBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                System.out.println("查询记录");
                break;
            case 4:
                System.out.println("归还图书");
                break;
        }
        return false;
    }

    private void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅书籍的 ISBN:");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        try {
            Book book = Action.borrowBook(user, ISBN);
            System.out.printf("《%s》借阅成功！%n", book.getTitle());
        } catch (NoSuchBookException e) {
            System.out.println("错误！没有这本书");
        } catch (BorrowedOutException e) {
            System.out.println("错误！这本书已经全被借完了");
        } catch (YetBorrowedException e) {
            System.out.println("错误！这本书已经你已经借过了");
        }
    }
}
