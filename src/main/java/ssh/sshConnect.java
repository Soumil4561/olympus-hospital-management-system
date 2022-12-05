package ssh;
import com.jcraft.jsch.*;

import java.io.ByteArrayOutputStream;

public class sshConnect {
    static int lport;
    static String rhost;
    static int rport;
    public static void listFolderStructure(String username, String password,
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
}
