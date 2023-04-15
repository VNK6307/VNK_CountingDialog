 # Домашнее задание к занятию 1.1 Многопоточное (параллельное) программирование. Работа с потоками.
 ## Задача 2. Межпоточный диалог со счетчиком.

 ### Описание
Модифицируйте код для потоков из предыдущей задачи таким образом, чтобы это была Callable-задача, возвращающая кол-во
выведенных в консоль сообщений, а цикл выполнения был конечен. Запустите некоторое кол-во этих задач в пул потоков
фиксированного количества и получите результаты выполнения задач. Проведите аналогичную операцию, но с получением
результата от одной из задач (pool.invokeAny())

 ### Функционал программы
1. Создание 4 потоков, каждый из которых имеет свое имя.
2. Каждые 2-3 секунды поток печатает сообщение в консоль. Обязательно в сообщении должно фигурировать имя потока

 ### Реализация
1. Создайте Callable-задачу, которую будут выполнять потоки. Задача должна печатать несколько сообщений в консоль и
 завершаться. Результатом задачи должно быть количество отправленных сообщений.
2. Создайте новый пул потоков необходимого размера.
3. Отправьте на выполнение в пул потоков необходимое количество Callable-объектов.