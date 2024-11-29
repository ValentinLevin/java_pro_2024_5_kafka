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
---
### Пояснение в решению

За основу взят проект реализованный для ДЗ по работе с БД. В данный проект была добавлена реализация по отправке данных в kafka, а сам проект вынесен в модуль **api**.
Данные отправляются в Kafka при получении запроса на добавление данных приюта (POST /shelter) в случае когда `isGovernmentFunded = true`.   
Добавлен модуль **core** для хранения настроек работы с Apache Kafka которые используются в разных модулях. 
Также в модуле **core** описаны dto, через которые производится обмен данных (KafkaShelterDataDTO).   
Модуль по получению и обработке сообщений из Kafka реализован в модуле **shelter-data-worker**. В данном модуле при получении информации из Kafka производится попытка сохранения в БД. 
В случае ошибки при сохранении, в Kafka передается сообщение об отказе в приеме и через некоторое время Kafka повторно шлет данных для сохранения (на данный момент задан нулевой промежуток времени ожидания).

В итоге в проекте реализовано 3 модуля:
- **api**. 
  - Взаимодействие с пользователем посредством REST интерфейса. 
  - Сохранение данных, которые приходят в запросе на добавления, передача данных в Kafka. 
  - OpenAPI описание, swagger доступно по адресу [http://localhost:8081/lesson5/api/v1/docs/swagger-ui.html](http://localhost:8081/lesson5/api/v1/docs/swagger-ui.html) после запуска модуля api
- **core**. Общие параметры и классы по работе с Kafka, которые используются в разных модулях
- **shelter-data-worker**. Прием данных из Kafka, обработка полученного сообщения
