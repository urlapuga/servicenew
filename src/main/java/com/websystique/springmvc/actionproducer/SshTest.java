package com.websystique.springmvc.actionproducer;

import com.jcraft.jsch.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SshTest {
    private Properties config = new Properties();
    JSch jsch = new JSch();

    String host;
    String login;
    String password;

    public SshTest(String host, String login, String password) {
        this.host = host;
        this.login = login;
        this.password = password;
    }

    public boolean shut(int port) {
        List<String> commands = new ArrayList<>();
        commands.add("conf t");
        commands.add("int fa 1/0/" + port);
        commands.add("shut");
        commands.add("exit");
        commands.add("exit");
        try {
            execute(commands);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean up(int port) {
        List<String> commands = new ArrayList<>();
        commands.add("conf t");
        commands.add("int fa 1/0/" + port);
        commands.add("enable");
        commands.add("exit");
        commands.add("exit");
        try {
            execute(commands);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getMac(int port) {
        String macString="";
        List<String> commands = new ArrayList<>();
        commands.add("sh mac address-table int fa 1/0/"+port);
        try {
             macString = execute(commands);
        } catch (Exception e) {
        }
        return macString;
    }


    public String execute(List<String> commands) throws Exception {
        String res = "";
        try {
            config.put("StrictHostKeyChecking", "no");
            Session session = jsch.getSession(login, host, 22);
            session.setPassword(password);
            session.setConfig(config);

            session.connect();

            Channel channel = session.openChannel("shell");
            OutputStream ops = channel.getOutputStream();
            PrintStream ps = new PrintStream(ops, true);

            channel.connect();

            commands.forEach(c -> ps.println(c));
            //give commands to be executed inside println.and can have any no of commands sent.
            ps.close();

            InputStream in = channel.getInputStream();
            byte[] bt = new byte[1024];


            while (true) {

                while (in.available() > 0) {
                    int i = in.read(bt, 0, 1024);
                    if (i < 0)
                        break;
                    String str = new String(bt, 0, i);
                    //displays the output of the command executed.
                    System.out.print(str);
                    res = str;
                }
                if (channel.isClosed()) {
                    break;
                }
                Thread.sleep(1000);
                channel.disconnect();
                session.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return res;
    }
}
