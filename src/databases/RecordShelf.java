package databases;

import classes.Book;
import classes.Record;
import classes.User;
import com.sun.prism.impl.Disposer;

import java.util.ArrayList;
import java.util.List;

public class RecordShelf {

    private List<Record> recordeList = new ArrayList<>();
    private static RecordShelf instance = new RecordShelf();
    public static RecordShelf getInstance() {
        return instance;
    }

    public boolean contains(User user, String ISBN) {
        for(Record record : recordeList ){
            if(record.is(user,ISBN)){
                return true;
            }
        }
        return false;
    }

    public void putRecord(User user, String ISBN) {
        Record record = new Record(user.getId(),ISBN);
        recordeList.add(record);
    }
}
