package handlers;

import app.ReplyKeyboardManager;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class PingPongHandler {
    public static String handle() {
        ReplyKeyboardManager.pingPongIsOn = true;

        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardRow secondRow = new KeyboardRow();
        KeyboardRow thirdRow = new KeyboardRow();

        firstRow.add("Ping-pong");
        secondRow.add("Calculator");
        thirdRow.add("Exit");

        keyboard.add(firstRow);
        keyboard.add(secondRow);
        keyboard.add(thirdRow);

        ReplyKeyboardManager.replyKeyboardMarkup.setKeyboard(keyboard);

        return "Press Exit to turn off ping-pong";
    }
}
