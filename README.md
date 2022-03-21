# Ветка "callable"
## "Реализация интерфейса CALLABLE и FUTURE"

### Что реалезовано в данной ветке:
В приведенном ниже примере программы демонстрируется применение интерфейсов
Callable и Future. В этой программе формируются три задачи, выполняющие три разных вида вычислений. Первая задача возвращает суммарное
значение, вторая находит длину гипотенузы прямоугольного треугольника с известными
значениями длин его сторон, а третья определяет факториал заданного
значения. Все три вида вычислений производятся одновременно.

### Особенности реализации:
#### :warning: Callable позволяет посчитать результат и вернуть его через объект типа "future"
- Имеется 3 класса вычисляющих результат поставленных задач
- Все 3 класса( "factorial", "hypot" и "sum" ), реализуют интерфейс "callable" и метод "call"
- Возвращаемый результат определяется параметризированными дженериками с типами данных возвращаемого результата (integer и double)
- Класс Main запускает пул потоков (3 фиксированных потока данных)
- Чтобы получить значение, необходимо вызвать метод get() из интерфейса Future
- Результат возвращается через объект типа "future"
- 3 потока производят вычисления параллельно и возвращают 3 результата.


**********************************************************************

:warning: **Не скупимся на звездочки на github, форкаем, даем советы по улучшению и оптимизации (всегда рад).**
