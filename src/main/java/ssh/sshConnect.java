package ssh;
import com.jcraft.jsch.*;

import java.io.File;
import java.io.IOException;

public class sshConnect {
    static int lport;
    static String rhost;
    static int rport;
    public static void connectToServer(String username, String password,
                                       String host, int port) throws Exception {

        Session session = null;
        ChannelExec channel = null;

        try {
            session = new JSch().getSession(username, host, port);
            lport = 4321;
            rport = 3306;
            rhost = "192.168.1.73";
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
    }

    private static ChannelSftp setupJsch(String username, String password, String host, int port) throws JSchException {
        JSch jsch = new JSch();
        jsch.setKnownHosts("C:\\Users\\soumi\\.ssh\\known_hosts");
        Session jschSession = jsch.getSession(username, host, port);
        jschSession.setPassword(password);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    public static void uploadFile(String localPath, String filename,String ext) throws JSchException, SftpException, IOException {
        String username ="DELL";
        String host = "192.168.1.73";
        String password = "Kashyap@123";
        int port = 22;

        JSch jsch = new JSch();
        jsch.setKnownHosts("C:\\Users\\soumi\\.ssh\\known_hosts");
        Session jschSession = jsch.getSession(username, host, port);
        jschSession.setPassword(password);
        jschSession.connect();

        ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");
        channelSftp.connect();
        channelSftp.cd("Olympus/reports/"+filename+"/");
        channelSftp.put(localPath,channelSftp.pwd()+filename+ext);
        channelSftp.exit();
        channelSftp.disconnect();
        jschSession.disconnect();

    }

    public static void uploadReport(String localpathname, long report_id, String filename) throws JSchException, SftpException, IOException {
        String username ="DELL";
        String host = "192.168.1.73";
        String password = "Kashyap@123";
        int port = 22;

        JSch jsch = new JSch();
        jsch.setKnownHosts("C:\\Users\\soumi\\.ssh\\known_hosts");
        Session jschSession = jsch.getSession(username, host, port);
        jschSession.setPassword(password);
        jschSession.connect();

        ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");
        channelSftp.connect();
        channelSftp.cd("Olympus/reports/"+report_id+"/");
        channelSftp.put(localpathname,channelSftp.pwd()+filename);
        channelSftp.exit();
        channelSftp.disconnect();
        jschSession.disconnect();

    }

    public static String downloadFile(String localPath, String remotePath, String ext) throws JSchException, SftpException {
        String username ="DELL";
        String host = "192.168.1.73";
        String password = "Kashyap@123";
        int port = 22;

        JSch jsch = new JSch();
        jsch.setKnownHosts("C:\\Users\\soumi\\.ssh\\known_hosts");
        Session jschSession = jsch.getSession(username, host, port);
        jschSession.setPassword(password);
        jschSession.connect();

        ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");
        channelSftp.connect();
        channelSftp.cd("Olympus/reports/"+remotePath+"/");
        String path="C:\\Program File\\Olympus\\temp\\"+localPath+"\\";
        new File(path).mkdirs();
        channelSftp.get(channelSftp.pwd()+remotePath+ext,path+localPath+ext);
        channelSftp.exit();
        channelSftp.disconnect();
        jschSession.disconnect();
        return path+localPath+ext;

    }


}
