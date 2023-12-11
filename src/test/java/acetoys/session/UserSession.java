package acetoys.session;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class UserSession {

    /* Метод, инициализирующий сессию пользователя!!!
    этот метод помогает инициализировать сессию пользователя,
    устанавливая начальные значения переменных,
    которые могут использоваться в дальнейших частях тестового сценария.*/
    public static ChainBuilder initSession =
            exec(flushCookieJar())
                    .exec(session -> session.set("customerLoggedIn", false));
}