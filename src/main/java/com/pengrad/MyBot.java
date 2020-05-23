package com.pengrad;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MyBot extends TelegramLongPollingBot {

    private Request request;
    public MyBot(){
        request = new Request();
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendMsg(update.getMessage().getChatId().toString(), update.getMessage().getText());
    }

    @Override
    public String getBotUsername() {
        return "МТС bot";
    }

    @Override
    public String getBotToken() {
        return "1036442049:AAEk3ppLdkYsJCD54iiMuVdj00VdkiqOJQk";
    }

    private void sendMsg(String chatId, String messageText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        try {
            sendMessage.setText(translate(messageText));
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String translate(String messageText) throws IOException {
        String inputLine;
        StringBuilder response = new StringBuilder();
        String urlStr = request.getRequest(makeWordCorrect(messageText));
        URL url = new URL(urlStr);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String res = findWord(response.toString());
        return res;
    }

    private String makeWordCorrect(String messageText){
        return messageText.replace(' ', '%');
    }


    private String findWord(String message){
        StringBuilder stringBuilder = new StringBuilder(message);
        String result = "";
        int index = stringBuilder.indexOf("<text>");
        stringBuilder = new StringBuilder(stringBuilder.substring(index+6));
        index = stringBuilder.indexOf("</text>");
        result = stringBuilder.substring(0, index);
        result = result.replace('%', ' ');
        return result;
    }
}