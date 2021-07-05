package handlers;

import app.ReplyKeyboardManager;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class MainCalculatorHandler {
    public static String handle() {
        ReplyKeyboardManager.calculatorIsOn = true;

        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardRow secondRow = new KeyboardRow();
        KeyboardRow thirdRow = new KeyboardRow();
        KeyboardRow fourthRow = new KeyboardRow();
        KeyboardRow fifthRow = new KeyboardRow();

        firstRow.add("7");
        firstRow.add("8");
        firstRow.add("9");
        firstRow.add("/");

        secondRow.add("4");
        secondRow.add("5");
        secondRow.add("6");
        secondRow.add("*");

        thirdRow.add("1");
        thirdRow.add("2");
        thirdRow.add("3");
        thirdRow.add("-");

        fourthRow.add(".");
        fourthRow.add("0");
        fourthRow.add("AC");
        fourthRow.add("+");

        fifthRow.add("Exit");
        fifthRow.add("=");

        keyboard.add(firstRow);
        keyboard.add(secondRow);
        keyboard.add(thirdRow);
        keyboard.add(fourthRow);
        keyboard.add(fifthRow);
        ReplyKeyboardManager.replyKeyboardMarkup.setKeyboard(keyboard);

        return "Enter expression";
    }
}
