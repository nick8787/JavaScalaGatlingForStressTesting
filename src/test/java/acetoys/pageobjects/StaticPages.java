package acetoys.pageobjects;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class StaticPages {

    public static ChainBuilder homePage =
            exec(
                    http("Load Home Page")
                            .get("/")
                            .check(status().is(200)) //делаем ряд проверок ниже, на статус код, на substring
                            .check(status().not(404))
                            .check(substring("<title>Ace Toys Online Shop</title>"))
                            .check(css("#_csrf", "content").saveAs("csrfToken")) //генерация каждый раз нового токена
            );
    public static ChainBuilder ourStoryPage =
            exec(
                    http("Load Our Story Page")
                            .get("/our-story")
                            .check(regex("was founded online in 2022")) //проверка на наличие такой строки на странице
            );
    public static ChainBuilder getInTouchPage =
            exec(
                    http("Load Get In Touch Page")
                            .get("/get-in-touch")
                            .check(substring("as we are not actually a real store!"))
            );


}
