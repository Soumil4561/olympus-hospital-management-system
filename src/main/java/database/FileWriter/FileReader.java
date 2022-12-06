package database.FileWriter;

import ssh.sshConnect;

import java.io.*;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<String> readReports(long report_id) throws Exception {
        String path = Long.toString(report_id);
        String pathname = sshConnect.downloadFile(path,path,".oly");
        File file = new File(pathname);
        BufferedReader br = new BufferedReader(new java.io.FileReader(file));
        ArrayList<String> output= new ArrayList<String>();
        String text;
        while((text=br.readLine())!=null){
            output.add(text);
        }
        return output;
    }
}
