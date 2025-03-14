import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
public class JavaCryptoBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "TrackingArz_bot";
    }

    @Override
    public String getBotToken() {
        return "8053735211:AAHq8EpFkC5YpJL5fSrAcg6hO8GrGAvXblY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();
            if(text.equalsIgnoreCase("/price")){
                sendMessage(chatId,GetPrice.CryptoLivePrice());
            }else{
               new SendMessage(chatId,"😎Top 10  Cryptos are - 💵💲 /price");
            }
    }
    }
    private void sendMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    }