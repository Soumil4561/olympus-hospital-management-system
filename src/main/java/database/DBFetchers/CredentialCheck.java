package database.DBFetchers;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnectors.SqlSearchConnection;

import static database.DBFetchers.ResultsetFunctions.size;

public class CredentialCheck {
    public static boolean loginCredentials(long id, String password) throws SQLException {
        String query="SELECT * from staffidandpass where staff_id="+id+" AND password=MD5('"+password+"')";
        ResultSet data=SqlSearchConnection.connect(query);
        if(size(data)==1) {
            data.close();
            return true;
        }
        data.close();
        return false;
    }
}