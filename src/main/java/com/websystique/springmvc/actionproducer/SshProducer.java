package com.websystique.springmvc.actionproducer;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStream;
import java.util.Properties;

public class SshProducer {

    private Properties props = PropFabric.get();
    private String host;
    private String user;
    private String password;
    private int port;
    private Properties config = new Properties();
    private JSch jsch = new JSch();

    public SshProducer(String host, String user, String password, int port) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public SshProducer() {
        this.host = props.getProperty("ssh.host");
        this.user = props.getProperty("ssh.user");
        this.password = props.getProperty("ssh.password");
        this.port = Integer.parseInt(props.getProperty("ssh.port"));
    }

    public boolean exec(String command1) {

        try {
            config.put("StrictHostKeyChecking", "no");
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            channel.disconnect();
            session.disconnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
