<h1 align="center"> Gatling Test in Scala on Java + custom script </h1>


## Summary:

### To make our own "user journey" + create script, we need:
- 1.Нажать на "Recorder" - запустить класс - откроется Gatling Recorder.
- 2.Справа сверху выбрать "HAR" - добавить "user journey" записанный в DevTools - Network (save all in HAR content). Также задать название package и названию класса. Нажать старт.
- 3.Подредактировать новый класс (его сценарий), так как здесь в проекте.
- 4.Добавить несколько проверок (check).
- 5.Сделать генерацию токенов при необходимости.
- 6.Разбить всё на классы и методы.
- 7.Запустить проект на Jenkins (сначала на GitHub - import on Jenkins).

### Making programming logic in our script:

- 1.Создать csv файлы для сокращения метода (так как в Category).
- 2.Создать UserSession, которая будет инициализировать логин (так как в Cart).


## Steps:

- 1.Load Home Page
- 2.Load Our Story Page
- 3.Load Get In Touch Page
- 4.Load Products List Page - Category: All products
- 5.Add some Products
- 6.View Cart
- 7.Login User
- 8.Increase some Products
- 9.Checkout
- 10.Logout User

## I've applied:

- site - https://acetoys.uk/
- split into Page Object
- making logic in script
- simulation for stress testing (TestScenario, UserJourney, TestPopulation)
- assertions almost in every methods


## Additional:

- My profile on GitHub - [тыць](https://github.com/nick8787)
- My tg - [тыць](https://t.me/nick8787)
- My website about testing - [тыць](https://www.testing87.online/)
