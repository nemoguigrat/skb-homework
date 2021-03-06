# Домашка №2

@SpringBootApplication содержит 6 параметров:
- exclude
- excludeName
- nameGenerator
- proxyBeanMethods
- scanBasePackageClasses
- scanBasePackages

![](image/file.jpg)

### exclude
Исключает определенные классы автоматической настройки таким образом,
чтобы они никогда не применялись.

### excludeName
Исключает определенные имена классов автоматической настройки таким образом, чтобы они никогда не применялись.

### nameGenerator
Класс BeanNameGenerator, использующийся для присвоения имен обнаруженным компонентам в контейнере Spring.
Значение по умолчанию самого интерфейса BeanNameGenerator указывает, что сканер, используемый для обработки этой аннотации @SpringBootApplication,
должен использовать свой унаследованный
генератор имен компонента, например, аннотацию по умолчанию Beannamegenerator или любой пользовательский экземпляр, предоставляемый контексту приложения во время начальной загрузки.

### scanBasePackages
Базовые пакеты для сканирования на наличие аннотированных компонентов.
Стоит использовать scanBasePackageClasses() для типобезопасной альтернативы именам пакетов на основе строк.
Примечание: этот параметр является псевдонимом только для @ComponentScan.
Это не влияет на сканирование @Entity или сканирование хранилища данных Spring.
Для них нужно добавить @EntityScan и @Enable...Аннотации репозиториев.

### scanBasePackageClasses
Типобезопасная альтернатива scanBasePackages() для указания пакетов для сканирования на наличие аннотированных компонентов. Пакет каждого указанного класса будет отсканирован.

Примечание: этот параметр является псевдонимом только для @ComponentScan.
Это не влияет на сканирование @Entity или сканирование хранилища данных Spring. Для них вы должны добавить @EntityScan и @Enable...Аннотации репозиториев.

### proxyBeanMethods
Указание, должны ли методы @Bean проксироваться для обеспечения соблюдения поведения жизненного цикла компонента, например, для возврата
общих экземпляров одноэлементного компонента даже в случае прямых вызовов метода @Bean в пользовательском коде.
Эта функция требует перехвата методов, реализованного с помощью подкласса CGLIB, созданного во время выполнения, который поставляется с такими ограничениями,
как класс конфигурации и его методы, которым не разрешается объявлять final.
Значение по умолчанию равно true, что позволяет использовать "ссылки между компонентами" внутри класса конфигурации,
а также для внешних вызовов методов @Bean этой конфигурации, например, из другого класса конфигурации. Если это не требуется, поскольку каждый из методов
@Bean этой конкретной конфигурации является автономным и разработан как простой фабричный метод для использования в контейнере, стоит установить этот флаг в значение false, чтобы избежать обработки подкласса CGLIB.

Отключение перехвата метода компонента эффективно обрабатывает методы @Bean по отдельности, как при объявлении в классах, отличных от @Configuration, также известных как "Облегченный режим @Bean".

---

@SpringBootApplication включает в себя:

- @EnableAutoConfiguration: включить механизм автоконфигурации Spring Boot

- @ComponentScan: включить сканирование @Component для пакета, в котором находится приложение

- @SpringBootConfiguration: позволяет регистрировать дополнительные компоненты (beans) в контексте или импортировать дополнительные классы конфигурации