package handlers;

import app.DatabaseManager;
import app.ReplyKeyboardManager;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import service.ExpressionResolver;

import java.util.Date;

public class CalculatorExpressionHandler {
    public static String handle(String message, Update update) {
        String literal = "";

        if (message.equals("1")) literal = "1";
        if (message.equals("2")) literal = "2";
        if (message.equals("3")) literal = "3";
        if (message.equals("4")) literal = "4";
        if (message.equals("5")) literal = "5";
        if (message.equals("6")) literal = "6";
        if (message.equals("7")) literal = "7";
        if (message.equals("8")) literal = "8";
        if (message.equals("9")) literal = "9";
        if (message.equals("0")) literal = "0";
        if (message.equals("-")) literal = " - ";
        if (message.equals("+")) literal = " + ";
        if (message.equals("/")) literal = " / ";
        if (message.equals("*")) literal = " * ";
        if (message.equals("=")) literal = " = ";

        if (!message.equals("Exit") && message.length() >= 2) {
            StringBuilder sb = new StringBuilder(message.replaceAll(" ", ""));

            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '/' || sb.charAt(i) == '+' || sb.charAt(i) == '-' || sb.charAt(i) == '*') {
                    sb.insert(i + 1, " ");
                    sb.insert(i, " ");
                    i++;
                }
            }

            if (sb.indexOf("=") == -1) {
                ReplyKeyboardManager.expression.append(sb);
            }

            if (sb.indexOf("=") != -1) {
                sb.replace(sb.indexOf("="), sb.length(), "");
                ReplyKeyboardManager.expression.append(sb);
                String exp = ReplyKeyboardManager.expression.toString();

                try {
                    ReplyKeyboardManager.expressionResult = ExpressionResolver.resolve(ReplyKeyboardManager.expression.toString());
                    String expResult =  ReplyKeyboardManager.expressionResult;
                    ReplyKeyboardManager.expression = new StringBuilder();
                    ReplyKeyboardManager.expressionResult = "";

                    DatabaseManager.insertData(
                            new Date().toString(),
                            update.getMessage().getFrom().getId(),
                            update.getMessage().getFrom().getUserName(),
                            exp, expResult);

                    return String.format("Result: %s = %s", exp, expResult);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    return "Invalid data";
                }
            }
        }

        if (message.equals("Exit")) {
            ReplyKeyboardManager.expression = new StringBuilder();
            ReplyKeyboardManager.expressionResult = "";
            return MenuHandler.handle();
        }

        if (!message.equals("=")) {
            ReplyKeyboardManager.expression.append(literal);
        }

        if (literal.equals(" = ")) {
            String exp = ReplyKeyboardManager.expression.toString();
            try {
                ReplyKeyboardManager.expressionResult = ExpressionResolver.resolve(ReplyKeyboardManager.expression.toString());
                String expResult =  ReplyKeyboardManager.expressionResult;
                ReplyKeyboardManager.expression = new StringBuilder();
                ReplyKeyboardManager.expressionResult = "";

                DatabaseManager.insertData(
                        new Date().toString(),
                        update.getMessage().getFrom().getId(),
                        update.getMessage().getFrom().getUserName(),
                        exp, expResult);

                return String.format("Result: %s = %s", exp, expResult);
            }
            catch (Exception e) {
                e.printStackTrace();
                return "Invalid data";
            }
        }

        if (message.equals("AC")) {
            ReplyKeyboardManager.expression = new StringBuilder();
            ReplyKeyboardManager.expressionResult = "";
            return "Enter expression";
        }

        return  ReplyKeyboardManager.expression.toString();
    }
}
