import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class MenuHandler {
    public static String handle() {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardRow secondRow = new KeyboardRow();

        ReplyKeyboard.pingPongIsOn = false;
        ReplyKeyboard.calculatorIsOn = false;
        firstRow.add("Ping-pong");
        secondRow.add("Calculator");

        keyboard.add(firstRow);
        keyboard.add(secondRow);
        ReplyKeyboard.replyKeyboardMarkup.setKeyboard(keyboard);
        return "Welcome";
    }

}
