package acetoys.simulation;

import io.gatling.javaapi.core.Choice;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;

public class TestScenario {

    //тут мы создаем сценарии и распределяем нагрузку в % и длительность (тут 30 сек)
    public static ScenarioBuilder defaultLoadTest =
        scenario("Default Load Test")
            .during(30)
                .on(
                       randomSwitch()
                             .on(
                                    Choice.withWeight(60, exec(UserJourney.webStore)),
                                    Choice.withWeight(30, exec(UserJourney.addingProductsToBasket)),
                                    Choice.withWeight(10, exec(UserJourney.completePurchase))
                             )
        );

    public static ScenarioBuilder highPurchaseLoadTest =
        scenario("High Purchase Load Test")
            .during(30)
                .on(
                      randomSwitch()
                             .on(
                                    Choice.withWeight(30, exec(UserJourney.webStore)),
                                    Choice.withWeight(30, exec(UserJourney.addingProductsToBasket)),
                                    Choice.withWeight(40, exec(UserJourney.completePurchase))
                             )
        );
}