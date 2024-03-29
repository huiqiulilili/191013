package classes;

import actions.Action;
import databases.BookShelf;
import exceptions.NoSuchBookException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends User{
    public Teacher(String id,String name){
        super(id,name);
    }

    @Override
    public void menu() {
        System.out.println("** 老师，请选择 **");
        System.out.println("** 0. 退出 **");
        System.out.println("** 1. 上架 **");
        System.out.println("** 2. 查阅图书 **");
        System.out.println("** 3. 查阅记录 **");
    }

    @Override
    public boolean input() throws NoSuchBookException {
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        switch (selected){
            case 0:
                System.out.println("退出");return true;
            case 1:
                putBook();
                break;
            case 2:
                queryBooks();
                break;
            case 3:
                System.out.println("查阅记录");break;
        }
        return false;
    }



    private void putBook()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 ISBN");
        String ISBN = scanner.nextLine();
        System.out.println("请输入书名");
        String title = scanner.nextLine();
        System.out.println("请输入作者: ");
        String author = scanner.nextLine();
        System.out.println("请输入价格: ");
        double price = scanner.nextDouble();
        System.out.println("请输入数量: ");
        int count = scanner.nextInt();

        Book book = Action.putBook( ISBN, title, author, price, count);
        System.out.printf("《%s》上架成功！",book.getTitle());
    }


}
