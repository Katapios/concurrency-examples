# concurrency-examples - Примеры многопоточности на Java

:warning: Проект постоянно дополняется и может содержать ошибки.


## О проекте:
- Каждая тема в проекте - отдельная ветка
- Примеры взяты из книг, видеоуроков и др. источников с собственными дополнениями и пояснениями
- При появлении желания что-то исправить или дополнить, жду ваших "pull requests"

### Как пользоваться?

```
git clone https://github.com/Katapios/concurrency-examples.git .
git checkout имя ветки из таблицы с описанием веток
```


### Таблица с описанием веток:


| Название ветки           | Описание кода |
|--------------------------|---------------|
| :white_check_mark:  **thread-extends-tread-with-super-constructor** | Расширение класса THREAD             |
| :white_check_mark:  **thread-runnable-with-constructor** | Реализация интерфейса RUNNABLE             |
| :white_check_mark:  **callable** | Реализация интерфейса CALLABLE             |
| :white_check_mark:  **thread-pool** | Пример пула потоков             |
| :white_check_mark:  **start-stop-threads** | Остановка и запуск потоков             |
| :white_check_mark:  **monitor-synchronization** | Синхронизация по монитору             |
| :white_check_mark:  **semaphore-synchronization** | Семафоры             |
| :white_check_mark:  **semaphore-synchronization-consumer-and-producer** | Семафоры на примере "Производитель-потребитель"            |
| :white_check_mark:  **reentrant-lock** | Реализация "замков"             |
| :white_check_mark:  **dead-lock** | Пример "DEADLOCK"             |
| :white_check_mark:  **count-down-latch** | Обратный счетчик             |
| :white_check_mark:  **cyclic-barrier** | Циклический барьер             |
| :white_check_mark:  **exchanger** | Обмен             |
| :white_check_mark:  **phaser** | Реализация фаз             |
| :white_check_mark:  **override-onAdvavce** | Перезапись метода "onAdvance"             |
| :white_check_mark:  **atom-thread** | Атомарность             |
| :white_check_mark:  **fork-join-framework-devide-and-rule** | Принцип "Разделяй и властвуй"             |
| :white_check_mark:  **fork-join-framework-multycore-version** | fork-join-framework - пример работы с многоядерными компьютерами             |



**PS** Благодарю за труд авторов, выкладывающих в gitlab свои примеры. Без Вас я бы не справился!

:warning: **Не скупимся на звездочки на github, форкаем, даем советы по улучшению и оптимизации (всегда рад).**