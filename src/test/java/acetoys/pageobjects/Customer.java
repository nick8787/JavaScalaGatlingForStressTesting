package acetoys.pageobjects;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.Choice;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Customer {

    public static ChainBuilder login =
            exec(
                    http("Login User")
                            .post("/login")
                            .formParam("_csrf", "#{csrfToken}") //csrfToken - создали для генерации уник. токена
                            .formParam("username", "user1")
                            .formParam("password", "pass")
                            .check(css("#_csrf", "content").saveAs("csrfTokenLoggedIn"))
            )
                    .exec(session -> session.set("customerLoggedIn", true));
//    private static Iterator<Map<String, Object>> loginFeeder =
//            Stream.generate((Supplier<Map<String, Object>>) () -> {
//                Random rand = new Random();
//                int userId = rand.nextInt(3 - 1 + 1) + 1;
//
//                HashMap<String, Object> hmap = new HashMap<String, Object>();
//                hmap.put("userId", "user" + userId);
//                hmap.put("password", "pass");
//                return hmap;
//            }).iterator();
//
//    public static ChainBuilder login =
//            feed(loginFeeder)
//                    .exec(
//                            http("Login User")
//                                    .post("/login")
//                                    .formParam("_csrf", "#{csrfToken}")
//                                    .formParam("username", "#{userId}")
//                                    .formParam("password", "#{password}")
//                                    .check(css("#_csrf", "content").saveAs("csrfTokenLoggedIn"))
//                    );
    //выше пример для рандомного юзера (user1, user2, user3)

    public static ChainBuilder logout =
            randomSwitch().on(
                    Choice.withWeight(10, exec(
                            http("Logout User")
                                    .post("/logout")
                                    .formParam("_csrf", "#{csrfTokenLoggedIn}") //csrfToken - создали для генерации уник. токена
                                    .check(css("#LoginLink").is("Login")) //assertion
                    )));
}
