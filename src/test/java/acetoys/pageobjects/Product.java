package acetoys.pageobjects;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Product {

//    private static final FeederBuilder<Object> productFeeder =
//            jsonFile("data/productDetails.json").random(); //можем использовать так как в Category

    public static ChainBuilder addProductToCart_Product3 =
            exec(
                    http("Add Product to Cart: ProductID: 3")
                            .get("/cart/add/3")
                            .check(substring("You have <span>1</span> products in your Basket.")) //assertion
            );

    public static ChainBuilder addProductToCart_Product2 =
            exec(
                    http("Add Product to Cart: ProductID: 2")
                            .get("/cart/add/2")
                            .check(substring("You have <span>2</span> products in your Basket.")) //assertion
            );

    public static ChainBuilder addProductToCart_Product5 =
            exec(
                    http("Add Product to Cart: ProductID: 6")
                            .get("/cart/add/5")
                            .check(substring("You have <span>3</span> products in your Basket.")) //assertion
            );
}
