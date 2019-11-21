package com.pengrad;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MyBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        try {
            sendMessage.setText(("messageTex"));
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Tinkoff_Meal_Bot";
    }

    @Override
    public String getBotToken() {
        return "901390376:AAFvPmf4_RXMCwMQvgYOFKu5H5YPtGlfSso";
    }
}