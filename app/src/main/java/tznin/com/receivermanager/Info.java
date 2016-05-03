package tznin.com.receivermanager;

import java.io.Serializable;

/**
 * Created by PC on 2016/5/3.
 */
public class Info  implements Serializable {
    private String name;
    private String password;
    private String sendServer;
    private String port;
    private String rmail;
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSendServer() {
        return sendServer;
    }

    public void setSendServer(String sendServer) {
        this.sendServer = sendServer;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRmail() {
        return rmail;
    }

    public void setRmail(String rmail) {
        this.rmail = rmail;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



}
