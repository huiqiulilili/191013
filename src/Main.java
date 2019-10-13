

import classes.User;

public class   Main {
    public static void main(String[] args) throws Exception {
        while (true){
            User currentUser =User.login();
            boolean isQuit;
            do{
                currentUser.menu();
                isQuit = currentUser.input();
            }while(!isQuit);
        }

    }
}
