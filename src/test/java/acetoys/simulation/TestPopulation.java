package acetoys.simulation;

import io.gatling.javaapi.core.PopulationBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;

public class TestPopulation {

    //все методы ниже - методы, для создания тестирования производительности!
    //ниже - это метод, где 10 юзеров создаются мгновенно (atOnce) сразу через 5 сек
    public static PopulationBuilder instantUsers =
            TestScenario.defaultLoadTest
                    .injectOpen(
                            nothingFor(5),
                            atOnceUsers(10));

    //Это метод, в котором 10 юзеров добавляются постепенно (ramp) в течение 20 секунд, после ожидания 5 секунд.
    public static PopulationBuilder rampUsers =
            TestScenario.defaultLoadTest
                    .injectOpen(
                            nothingFor(5),
                            rampUsers(10).during(20));

    /*Этот метод включает в себя постоянное количество юзеров в секунду (constantUsersPerSec) в течение 20 секунд
     с некоторой случайной вариацией, а также нарастающее количество пользователей в секунду (rampUsersPerSec)
     от 10 до 20 секунд с случайной вариацией в течение 20 секунд.*/
    public static PopulationBuilder complexInjection =
            TestScenario.defaultLoadTest //тут мы выбираем тест сценарий
                    .injectOpen(
                            constantUsersPerSec(10).during(20).randomized(),
                            rampUsersPerSec(10).to(20).during(20).randomized()
                    );

    /*Этот метод включает постоянное количество одновременных юзеров (constantConcurrentUsers) в течение 20 секунд
     и нарастающее количество одновременных пользователей (rampConcurrentUsers)
     от 10 до 20 секунд в течение 20 секунд.*/
    public static PopulationBuilder closedModel =
            TestScenario.highPurchaseLoadTest //тут мы выбираем тест сценарий
                    .injectClosed(
                            constantConcurrentUsers(10).during(20),
                            rampConcurrentUsers(10).to(20).during(20)
                    );
}