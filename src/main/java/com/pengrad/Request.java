package com.pengrad;

public class Request {
    ///Could be intarface
    public String getRequest(String messageText){
        return "https://translate.yandex.net/api/v1.5/tr/translate" +
                "?key=" + "trnsl.1.1.20191120T150503Z.4790ed8a0f152158.2b123e6660d0e34755c5318ceb8b6a55c1378945" +
                "&text=" + messageText +
                "&lang=ru-en";
    }
}
