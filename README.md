# x-BetterQuality


x-BetterQuality is a bot for teamspeak that changes the quality of each channel to the highest (10). 
If there is no one on the channel with lower quality or is added to the ignored channel group, the bot will not change its quality. 
Bot uses the library [TeamSpeak 3 Java API](https://github.com/TheHolyWaffle/TeamSpeak-3-Java-API) and [Gson](https://github.com/google/gson).
## Installation

[Java](https://www.java.com) is required to run.

```bash
First inclusion:
 java -jar x-BetterQuality
Next:
  nano config.json
  screen -dmS animatedicons java -jar x-BetterQuality.jar -Xmx48M -Xms16M
```
## Information


Bot was written for the needs of one of the TeamSpeak servers - [PlayTS.eu](https://Playts.eu).

## License
[MIT](https://choosealicense.com/licenses/mit/)
