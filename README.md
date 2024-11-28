# Домашнее задание по курсу Java Pro 2024

*Студент: Валентин Левин*

## 5. Системы обмена сообщениями

**1. Shelter (Продюсер)**

Добавьте реализацию отправки в кафку по топику: shelter-data при условии если  isGovernmentFunded — флаг, указывающий, финансируется ли приют государством — true.

**2.Shelter Worker (Консюмер)**  

Напишите сервис, который:
1.	Читает сообщения из топика shelter-data.
2.	Пытается сохранить данные в базу данных.
3.	Если данные успешно сохранены, коммитит оффсет.
4.	Если при сохранении возникает ошибка, оффсет не должен сдвигаться (например, используйте исключения).

__Пример:__  
Если вы считали сообщение id=1 и попытались его сохранить в базу, но произошла ошибка подключения к базе, это сообщение не должно считаться обработанным.
•	Логируйте все этапы: чтение сообщения, попытка сохранения, успешный коммит или обработка ошибки.  

__Проверка работы__  
•	Подготовьте скрипт или метод для генерации 10-20 сообщений через Shelter.
•	Запустите Shelter Worker, чтобы проверить корректность обработки сообщений.
•	Для проверки отказоустойчивости:
•	Остановите базу данных или добавьте искусственные ошибки (например, выброс исключения при сохранении).
•	Убедитесь, что сообщения с ошибками не коммитятся и оффсеты не сдвигаются.
