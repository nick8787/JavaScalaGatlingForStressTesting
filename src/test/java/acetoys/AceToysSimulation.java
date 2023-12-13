package acetoys;

import acetoys.simulation.TestPopulation;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class AceToysSimulation extends Simulation {

  //переменная TEST_TYPE и ее тестовый сценарий, который определен (сейчас это - INSTANT_USERS)
  private static final String TEST_TYPE = System.getProperty("TEST_TYPE", "INSTANT_USERS");

  private static final String URL = "https://acetoys.uk";

  private HttpProtocolBuilder httpProtocol = http //это настройки ВЕБ
          .baseUrl(URL)
          .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
          .acceptEncodingHeader("gzip, deflate")
          .acceptLanguageHeader("ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");

  /*блок ниже проверяет значение переменной TEST_TYPE,
   если она - INSTANT_USERS - значит будет настроен именно этот сценарий (а она сейчас INSTANT_USERS)
   тест будет выполнять тестовый сценарий INSTANT_USERS, которая определна в TestPopulation*/
  {
    if (TEST_TYPE == "INSTANT_USERS") {
      setUp(TestPopulation.instantUsers).protocols(httpProtocol);
    } else if (TEST_TYPE == "RAMP_USERS") {
      setUp(TestPopulation.rampUsers).protocols(httpProtocol);
    } else if (TEST_TYPE == "COMPLEX_INJECTION") {
      setUp(TestPopulation.complexInjection).protocols(httpProtocol);
    } else if (TEST_TYPE == "CLOSED_MODEL") {
      setUp(TestPopulation.closedModel).protocols(httpProtocol);
    } else {
      setUp(TestPopulation.instantUsers).protocols(httpProtocol); //Если значение TEST_TYPE не соответствует ни одному из перечисленных случаев, то по умолчанию будет настроена TestPopulation - "instantUsers".
    }
  }
}

  /*Другие разные варианты тестов ниже:*/
//#1  {
//    setUp(TestScenario.highPurchaseLoadTest
//            .injectOpen(atOnceUsers(10))) //кол-во виртуальных юзеров
//            .protocols(httpProtocol);
//  }

//#2  {
//    setUp(TestPopulation.complexInjection).protocols(httpProtocol);
//  }

//#3  private ScenarioBuilder scn = scenario("AceToysSimulation")
//          .exec(UserJourney.addingProductsToBasket);
//  {
//	  setUp(scn.injectOpen(atOnceUsers(1)))
//              .protocols(httpProtocol);
//  }