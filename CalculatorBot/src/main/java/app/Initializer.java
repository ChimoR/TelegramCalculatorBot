package app;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Initializer {
//    Create auth.properties file in resources and add two values:
//    discordBotToken=...
//    discordBotUsername=...

    private final static String PROPS_FILE = "src/main/resources/auth.properties";

    public static void init() {
        try (InputStream is = new FileInputStream(PROPS_FILE)) {
            Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
            Properties pr = new Properties();
            pr.load(reader);
            MyBot.BOT_TOKEN = pr.getProperty("discordBotToken");
            MyBot.BOT_USERNAME = pr.getProperty("discordBotUsername");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
