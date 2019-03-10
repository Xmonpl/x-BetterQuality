package cf.xmon.quality;

import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.wrapper.Channel;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TimeTask{
    public static void update() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Map<ChannelProperty, String> properties = new HashMap<>();
                properties.put(ChannelProperty.CHANNEL_CODEC_QUALITY, "10");
                for (Channel channel : Main.api.getChannels()) {
                    int codec = channel.getCodecQuality();
                    ConfigManager configManager = new ConfigManager();
                    Config c = ConfigManager.getConfig();
                        if (codec != 10) {
                            if (!c.getInstance().getIgnore().contains(String.valueOf(channel.getId()))) {
                                if(channel.getTotalClients() >= 1) {
                                    Main.api.editChannel(channel.getId(), properties);
                                    if (Main.api.whoAmI().getChannelId() != c.getInstance().getPoczekalnia()) {
                                        Main.api.sendChannelMessage(channel.getId(), c.getInstance().getMessage());
                                    }else{
                                        Main.api.sendChannelMessage(c.getInstance().getMessage());
                                    }
                                    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
                                    Date now = new Date();
                                    String strDate = sdfDate.format(now);
                                    System.out.println("Log: (" + strDate + ") Edit Channel id " + channel.getId());
                                }
                            }
                        }
                    }
                    ConfigManager configManager = new ConfigManager();
                    Config c = ConfigManager.getConfig();
                    if (Main.api.whoAmI().getChannelId() != c.getInstance().getPoczekalnia()) {
                        Main.api.moveClient(Main.api.whoAmI().getId(), c.getInstance().getPoczekalnia());
                    }
                }
            }, TimeUnit.MINUTES.toMillis(2), TimeUnit.MINUTES.toMillis(2));
    }
}
