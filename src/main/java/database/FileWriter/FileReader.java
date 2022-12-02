package database.FileWriter;

import java.io.*;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<String> readReports(long report_id) throws IOException {
        File file = new File("D:\\CS Project\\Patient Reports\\"+report_id+".oly");
        BufferedReader br = new BufferedReader(new java.io.FileReader(file));
        ArrayList<String> output= new ArrayList<String>();
        String text;
        while((text=br.readLine())!=null){
            output.add(text);
        }
        return output;
    }
}
