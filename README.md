# Домашка 6
1) Реализовать два контроллера. Один контроллер должен в качестве ответа на GET запрос отдавать шаблон, в котором выводится список всех заголовков запроса. Второй контроллер должен принимать на вход JSON вида:
{
    "price": 125.0,
    "info": {
        "date": "2022-01-01"
    } 
}
и отдавать его обратно, при этом добавив в ответ свойство id:
{
    "price": 125.0,
    "info": {
        "id": 123,
        "date": "2022-01-01"
    } 
}
2) Написать обработчик ошибок, который будет возвращать кастомную 502 ошибку (@ContrllerAdvice вам в помощь)