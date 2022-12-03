package database.FileWriter;

import com.sun.security.jgss.GSSUtil;

import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ReportGenerator {
    public static boolean create(long report_id){
        String pathname="D:\\CS Project\\Patient Reports\\"+report_id+".oly";
        File file = new File(pathname);
        try{
            if (!file.createNewFile()){
                System.out.println("File already exists.");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean append(long report_id, String text) throws IOException {
        String pathname = "D:\\CS Project\\Patient Reports\\"+report_id+".oly";
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(pathname, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(text);
            pw.flush();
        }  finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean encryptCreate(long report_id,String text) throws FileNotFoundException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        String pathname="D:\\CS Project\\Patient Report\\"+report_id+".oly";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey originalKey = keyGenerator.generateKey();
        EncryptDecryptFile locker = new EncryptDecryptFile(originalKey,"AES");
        locker.encrypt(text,pathname);
        return true;
    }
}
