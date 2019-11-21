package com.pengrad;

import com.pengrad.telegrambot.request.SetWebhook;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("1");

        final String portNumber = System.getenv("PORT");
        if (portNumber != null) {
            port(Integer.parseInt(portNumber));
        }

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new MyBot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        // current app url to set webhook
        // should be set via heroku config vars
        // https://devcenter.heroku.com/articles/config-vars
        // heroku config:set APP_URL=https://app-for-my-bot.herokuapp.com
        // heroku config:set APP_URL=https://tinkoffbot.herokuapp.com
        final String appUrl = System.getenv("APP_URL");

        // define list of bots
        /*BotHandler[] bots = new BotHandler[]{
                new TestTelegramBot()
        };*/

        // set bot to listen https://my-app.heroku.com/BOTTOKEN
        // register this URL as Telegram Webhook

    }

    private static class Test implements Route {
        @Override
        public Object handle(Request request, Response response) {
            return "ok, test";
        }
    }
}
