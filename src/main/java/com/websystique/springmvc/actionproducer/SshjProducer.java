package com.websystique.springmvc.actionproducer;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.TransportException;

import java.util.ArrayList;
import java.util.List;

public class SshjProducer {

    private String login;
    private String pass;
    private String host;
    Session session = null;
    SSHClient ssh = null;

    public SshjProducer(String login, String pass, String addr) {
        this.login = login;
        this.pass = pass;
        this.host = addr;
        this.ssh = new SSHClient();
    }

    public void exec(List<String> commands){
        try {
            session = ssh.startSession();
            ssh.loadKnownHosts();
            ssh.connect(host);
            ssh.authPassword(login, pass);

            commands.forEach(c -> {
                try {
                    Session.Command command = session.exec(c);
                    System.out.println(IOUtils.readFully(command.getInputStream()).toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
                ssh.disconnect();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        SSHClient ssh = new SSHClient();
        Session session = null;

        try {
            session = ssh.startSession();
            ssh.loadKnownHosts();
            ssh.connect("nameOfServer");
            ssh.authPassword("login", "pass");

            session.exec("conf -t");
            session.exec("int fa 1/0/45");
            session.exec("shut");
            session.exec("exit");
            session.exec("exit");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
                ssh.disconnect();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public void shut(boolean shut,int port){
        List<String> shutCommands = new ArrayList<>();
        shutCommands.add("conf-t");
        shutCommands.add("int fa 1/0/"+String.valueOf(port));
        boolean res = (shut)?shutCommands.add("shut"):shutCommands.add("noshut");
        shutCommands.add("exit");
        shutCommands.add("exit");
        exec(shutCommands);
    }

    public void shape(int speed,int port){
        List<String> shutCommands = new ArrayList<>();
        shutCommands.add("conf-t");
        shutCommands.add("int fa 1/0/"+String.valueOf(port));
        shutCommands.add("exit");
        shutCommands.add("exit");
        exec(shutCommands);
    }

}
