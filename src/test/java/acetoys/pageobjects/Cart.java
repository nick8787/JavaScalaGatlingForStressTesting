package acetoys.pageobjects;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Cart {

    //тут делаем логин юзера
    public static ChainBuilder viewCart =
            doIf(session -> !session.getBoolean("customerLoggedIn"))
                    .then(exec(Customer.login))
                    .exec(
                            http("View Cart")
                                    .get("/cart/view")
                                    .check(css("#CategoryHeader").is("Cart Overview"))
                    );

    public static ChainBuilder increaseProduct2InCart =
            exec(
                    http("Increase Product Quantity in Cart: Product Number 2")
                            .get("/cart/add/2?cartPage=true")
            );

    public static ChainBuilder increaseProduct3InCart =
            exec(
                    http("Increase Product Quantity in Cart: Product Number 3")
                            .get("/cart/add/3?cartPage=true")
            );

    public static ChainBuilder checkout =
            exec(
                    http("Checkout")
                            .get("/cart/checkout")
                            .check(substring("Your products are on their way to you now!!"))
            );
}
