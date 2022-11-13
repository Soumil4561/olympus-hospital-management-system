package database.DBFetchers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultsetFunctions {
    public static int size(ResultSet data) throws SQLException {int size =0;
        if (data != null)
        {
            data.last();    // moves cursor to the last row
            size = data.getRow(); // get row id
        }
        data.absolute(0);
        return size;
    }

}
