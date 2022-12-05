package database.FileWriter;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import ssh.sshConnect;

import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ReportGenerator {
    public static String create(long report_id) throws Exception {
        String path = Long.toString(report_id);
        String pathname="C:\\Program File\\Olympus\\temp\\"+path+"\\";
        new File(pathname).mkdirs();
        File file = new File(pathname+path+".oly");
        try{
            if (!file.createNewFile()){
                System.out.println("File already exists.");
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ssh.sshConnect.uploadFile(pathname+path+".oly",path,".oly");
        return pathname+path+".oly";
    }

    public static boolean appendFirst(long report_id, String text, String localPath) throws IOException, JSchException, SftpException {
        String path = Long.toString(report_id);
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(localPath, true);
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
        sshConnect.uploadFile(localPath,path,".oly");
        return true;
    }

    public static boolean append(long report_id, String text) throws IOException, JSchException, SftpException {
        String path = Long.toString(report_id);
        String localPath = sshConnect.downloadFile(path,path,".oly");
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(localPath, true);
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
        sshConnect.uploadFile(localPath,path,".oly");
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
