package cf.xmon.quality;

import com.google.gson.annotations.SerializedName;

public class Instance {
    @SerializedName("virutal-server-id")
    private int virtualServerId;
    @SerializedName("query-password")
    private String password;
    @SerializedName("query-address")
    private String ip;
    @SerializedName("query-port")
    private int port;
    @SerializedName("query-login")
    private String queryLogin;
    @SerializedName("debug")
    private boolean debug;
    @SerializedName("message")
    private String message;
    @SerializedName("ignorechannel")
    private String ignore;
    @SerializedName("poczekalniaid")
    private int poczekalnia;

    public Instance(){
        this.virtualServerId = 1;
        this.ip = "127.0.0.1";
        this.queryLogin = "serveradmin";
        this.password = "passwd";
        this.port = 10011;
        this.debug = false;
        this.message = "Tu Będzie taka fajna fajowa wiadomość, która jest fajna i fajowa.";
        this.ignore = "3;15;18;20";
        this.poczekalnia = 37;
    }

    public int getVirtualServerId() {
        return virtualServerId;
    }
    public String getPassword() {
        return password;
    }
    public boolean getDebug(){
        return debug;
    }
    public String getQueryIp(){
        return ip;
    }
    public int getPort() {
        return port;
    }
    public String getQueryLogin() { return queryLogin; }
    public String getMessage(){ return message; }
    public String getIgnore(){return ignore;}
    public int getPoczekalnia(){return poczekalnia;}
}
