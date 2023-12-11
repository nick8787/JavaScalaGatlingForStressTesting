package acetoys.simulation;

import acetoys.pageobjects.*;
import io.gatling.javaapi.core.ChainBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;

import static acetoys.session.UserSession.*;

public class UserJourney {

    private static final Duration LOW_PAUSE = Duration.ofMillis(1000);
    private static final Duration HIGH_PAUSE = Duration.ofMillis(3000);

    //ниже созданы сценарии поведения юзеров, с использованием ПАУЗ, чтоб посмотреть как отрабатывает ВЕБ.
    public static ChainBuilder webStore =
            exec(initSession)
                    .exec(StaticPages.homePage)
                    .pause(HIGH_PAUSE)
                    .exec(StaticPages.ourStoryPage)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(StaticPages.getInTouchPage)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .repeat(3).on(
                            exec(Category.productList_AllProducts)
                                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    );

    public static ChainBuilder addingProductsToBasket =
            exec(initSession)
                    .exec(StaticPages.homePage)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Category.productList_AllProducts)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Product.addProductToCart_Product3)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Product.addProductToCart_Product2)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Product.addProductToCart_Product5);

    public static ChainBuilder completePurchase =
            exec(initSession)
                    .exec(StaticPages.homePage)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Category.productList_AllProducts)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Product.addProductToCart_Product3)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Product.addProductToCart_Product2)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Product.addProductToCart_Product5)
                    .exec(Cart.viewCart)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Cart.increaseProduct3InCart)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Cart.increaseProduct2InCart)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Cart.checkout)
                    .pause(LOW_PAUSE, HIGH_PAUSE)
                    .exec(Customer.logout);
}