package cf.xmon.quality;

import java.io.File;

public class ConfigManager {
    private static Config botConfig;

    public ConfigManager(){
        try{
            ConfigManager.botConfig = GsonUtil.readConfiguration(Config.class, new File("config.json"));
        }catch(Exception e){
            e.printStackTrace();
            ConfigManager.botConfig = null;
        }
    }
    public static Config getConfig(){
        return botConfig;
    }
}
