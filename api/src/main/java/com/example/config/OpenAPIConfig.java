package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                              .title("Домашнее задание по курсу Java Pro 2024")
                              .description(
                                      "<p><i>Студент: Валентин Левин</i></p>" +
                                              "<h2>4. ORM, Hibernate, JPA, Query DSL </h2> " +
                                              "<p>Создать новый сервис в котором будет логика создания приюта.</p>" +
                                              "<p>Создаем сущность Shelter — это наша модель приюта для животных, и добавляем в нее основные поля:</p>" +
                                              "<ul>" +
                                              "     <li><b>name</b> — название приюта;</li>" +
                                              "     <li><b>location</b> — адрес приюта;</li>" +
                                              "     <li><b>capacity</b> — вместимость (количество мест);</li>" +
                                              "     <li><b>type</b> — тип приюта (например, \"для собак\", \"для кошек\" можно указать 5 типов на свое усмотрение)</li>" +
                                              "     <li><b>rating</b> — рейтинг приюта;</li>" +
                                              "     <li><b>isGovernmentFunded</b> — флаг, указывающий, финансируется ли приют государством;</li>" +
                                              "     <li><b>averageAdoptionTime</b> — среднее время ожидания на усыновление;</li>" +
                                              "     <li><b>dailyCost</b> — ежедневная стоимость содержания одного животного.</li>" +
                                              "</ul>" +
                                              "<p>На основе этой сущности создаем REST-эндпоинт для поиска приютов. Он должен поддерживать несколько фильтров и сортировку.<p/>" +
                                              "<h3>Что должны уметь фильтры:</h3>" +
                                              "<ul>" +
                                              "     <li><b>Поиск по названию приюта</b>: фильтр по полю name с частичным совпадением, чтобы можно было искать, например, по подстроке.<br/>" +
                                              "     <li><b>Фильтр по типу и местоположению</b>: по полям type и location. Для type мы будем использовать точное совпадение (чтобы искать конкретно \"для собак\", \"для кошек\" и т. д.), а для location — частичное совпадение (поиск по городу или району).<br/>" +
                                              "     <li><b>Фильтр по диапазонам значений</b>: для таких полей, как capacity, rating, averageAdoptionTime и dailyCost. Нам нужно, чтобы можно было задать диапазон значений, например, вместимость от 50 до 100 мест или рейтинг от 4 и выше.<br/>" +
                                              "     <li><b>Логические операторы</b>: чтобы фильтры поддерживали AND, OR, и NOT. Например, можно искать приюты с рейтингом не ниже 4, которые находятся не в определенном районе, и с вместимостью более 50.<br/>" +
                                              "</ul>" +
                                              "<h3>Сортировка и пагинация:</h3>" +
                                              "<p>Кроме фильтров, добавляем сортировку — пусть можно будет сортировать результаты по полям rating, capacity, и averageAdoptionTime. Также делаем пагинацию, чтобы удобно было работать с большим количеством записей.</p>" +
                                              "<p>Задание аналогично тому что делали на уроке но с учетом всех выше правил + пагинация (так же креатив к подходу приветствуется)</p>" +
                                              "<a href='https://github.com/ValentinLevin/java_pro_2024_4_orm'>Ссылка на GitHub репозиторий</a>")
                );
    }
}
