import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class CalculatorExpressionHandler {
    public static String handle(String message) {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardRow secondRow = new KeyboardRow();
        KeyboardRow thirdRow = new KeyboardRow();
        KeyboardRow fourthRow = new KeyboardRow();

        String literal = "";
        if (message.equals("0")) literal = "0";
        if (message.equals("1")) literal = "1";
        if (message.equals("2")) literal = "2";
        if (message.equals("3")) literal = "3";
        if (message.equals("4")) literal = "4";
        if (message.equals("5")) literal = "5";
        if (message.equals("6")) literal = "6";
        if (message.equals("7")) literal = "7";
        if (message.equals("8")) literal = "8";
        if (message.equals("9")) literal = "9";
        if (message.equals("-")) literal = " - ";
        if (message.equals("+")) literal = " + ";
        if (message.equals("/")) literal = " / ";
        if (message.equals("*")) literal = " * ";
        if (message.equals("=")) literal = " = ";
        if (message.equals("Exit")) literal = "Exit";

        if (literal.equals("Exit")) {
            ReplyKeyboard.expression = new StringBuilder();
            ReplyKeyboard.expressionResult = "";
            return ExitHandler.handle();
        }

        if (!message.equals("=")) {
            ReplyKeyboard.expression.append(literal);
        }

        if (literal.equals(" = ")) {
            String exp = ReplyKeyboard.expression.toString();
            try {
                ReplyKeyboard.expressionResult = ExpressionResolver.resolve( ReplyKeyboard.expression.toString());
                String expResult =  ReplyKeyboard.expressionResult;
                ReplyKeyboard.expression = new StringBuilder();
                ReplyKeyboard.expressionResult = "";
                return String.format("Result: %s = %s", exp, expResult);
            }
            catch (Exception e) {
                e.printStackTrace();
                return "Invalid data";
            }
        }

        return  ReplyKeyboard.expression.toString();
    }
}
