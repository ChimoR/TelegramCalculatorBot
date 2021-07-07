package app;

import handlers.CalculatorExpressionHandler;
import handlers.*;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class ReplyKeyboardManager {
    public static ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    public static StringBuilder expression = new StringBuilder();
    public static String expressionResult = "";
    public static boolean pingPongIsOn = false;
    public static boolean calculatorIsOn = false;

    public static ReplyKeyboardMarkup getReplyKeyboard() {
        return replyKeyboardMarkup;
    }

    public static String getMessage(String message, Update update) {
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        if (message.equals("/start") || message.equalsIgnoreCase("Menu")) {
            return MenuHandler.handle();
        }

        if (message.equals("Exit") && pingPongIsOn) {
            return MenuHandler.handle();
        }

        if (!pingPongIsOn) {
            if (message.equals("Ping-pong")) {
                return PingPongHandler.handle();
            }

            if (message.equals("Calculator")) {
                return MainCalculatorHandler.handle();
            }

            if (calculatorIsOn) {
                return CalculatorExpressionHandler.handle(message, update);
            }
        }

        if (pingPongIsOn) {
            return message;
        }

        return MenuHandler.handle();
    }
}
