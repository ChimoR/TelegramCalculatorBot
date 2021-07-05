package handlers;

import app.ReplyKeyboardManager;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class ExitHandler {
    public static String handle() {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardRow secondRow = new KeyboardRow();

        ReplyKeyboardManager.pingPongIsOn = false;
        firstRow.add("Ping-pong");
        secondRow.add("Calculator");

        keyboard.add(firstRow);
        keyboard.add(secondRow);
        ReplyKeyboardManager.replyKeyboardMarkup.setKeyboard(keyboard);

        return "Please select function";
    }

}