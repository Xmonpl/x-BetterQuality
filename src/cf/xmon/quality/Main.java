package cf.xmon.quality;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

import java.io.FileNotFoundException;

public class Main {
    public static TS3Config config;
    public static TS3Query query;
    public static TS3Api api;

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        System.out.println("Ładowanie configu..");
        ConfigManager configManager = new ConfigManager();
        Config c = ConfigManager.getConfig();
        System.out.println("Config załadowano poprawnie!");

        System.out.println("Trwa łączenie..");
        config = new TS3Config();
        config.setHost(c.getInstance().getQueryIp());
        config.setQueryPort(c.getInstance().getPort());
        config.setEnableCommunicationsLogging(c.getInstance().getDebug());

        query = new TS3Query(config);
        query.connect();
        System.out.println("Połączono poprawnie");

        System.out.println("Trwa logowanie..");
        api = query.getApi();
        api.login(c.getInstance().getQueryLogin(), c.getInstance().getPassword());
        api.selectVirtualServerById(c.getInstance().getVirtualServerId());
        api.setNickname("x-BetterQuality");
        api.moveClient(api.whoAmI().getId(), c.getInstance().getPoczekalnia());
        System.out.println("Logowanie przebiegło pomyślnie!");
        System.out.println("Uruchomiono w " + (System.currentTimeMillis() - start) + "ms!");
        System.out.println("x-BetterQuality created by Xmon for PlayTS.eu (https://github.com/xmonpl)");
        TimeTask.update();
    }
}
