import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    private static final String BOT_USERNAME = "Calculator Bot";
    private static final String BOT_TOKEN = "1803190469:AAGEnYuL0tOPYXXhmFhynsMvDcN6DiLlvRw";


    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setReplyMarkup(ReplyKeyboard.getReplyKeyboard());
        try {
            sendMessage.setText(ReplyKeyboard.getMessage(update.getMessage().getText()));
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
