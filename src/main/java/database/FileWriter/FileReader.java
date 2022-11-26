package database.FileWriter;

import java.io.*;

public class FileReader {
    public static String readReports(long report_id) throws IOException {
        File file = new File("D:\\CS Project\\Patient Reports\\"+report_id+".oly");
        BufferedReader br = new BufferedReader(new java.io.FileReader(file));
        String output="";
        String text;
        while((text=br.readLine())!=null){
            output+=text+"\n";
        }
        return output;
    }
}
