package handlers;

import app.ReplyKeyboardManager;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class MenuHandler {
    public static String handle() {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardRow secondRow = new KeyboardRow();
        KeyboardRow thirdRow = new KeyboardRow();

        ReplyKeyboardManager.pingPongIsOn = false;
        ReplyKeyboardManager.calculatorIsOn = false;
        firstRow.add("Ping-pong");
        secondRow.add("Calculator");
        thirdRow.add("Better, than Eye of God");

        keyboard.add(firstRow);
        keyboard.add(secondRow);
        keyboard.add(thirdRow);
        ReplyKeyboardManager.replyKeyboardMarkup.setKeyboard(keyboard);
        return "Welcome";
    }

}
