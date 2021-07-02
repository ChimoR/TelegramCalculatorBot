import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class ReplyKeyboard {
    public static ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    public static StringBuilder expression = new StringBuilder();
    public static String expressionResult = "";
    public static boolean pingPongIsOn = false;
    public static boolean calculatorIsOn = false;

    public static ReplyKeyboardMarkup getReplyKeyboard() {
        return replyKeyboardMarkup;
    }

    public static String getMessage(String message) {
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        if (message.equals("/start") || message.equalsIgnoreCase("Menu")) {
            return MenuHandler.handle();
        }

        if (message.equals("Ping-pong") && !pingPongIsOn) {
            return PingPongHandler.handle();
        }

        if (message.equals("Exit") && pingPongIsOn) {
            return ExitHandler.handle();
        }

        if (!pingPongIsOn) {
            if (message.equals("Calculator")) {
                return MainCalculatorHandler.handle();
            }

            if (calculatorIsOn) {
                return CalculatorExpressionHandler.handle(message);
            }

            return MenuHandler.handle();
        }
        return message;
    }
}
