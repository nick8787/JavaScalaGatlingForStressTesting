package acetoys.pageobjects;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Category {

    private static final FeederBuilder<String> categoryFeeder =
    csv("data/categoryDetails.csv").circular();
    //в файле categoryDetails.csv - указали данные - этим же сократили метод и выглядит он вот так

    public static ChainBuilder productList_AllProducts =
            feed(categoryFeeder)
                    .exec(
                    http("Load Products List Page - Category: #{categoryName}")
                            .get("/category/#{categorySlug}")
                            .check(css("#CategoryName").isEL("#{categoryName}")) //asertion
            );
}
