# Задача 1. Розыгрыш резюме рьяными работниками

<p>Задача представляет собой 1-ую из 2-х задач для поступления в Школу программистов, организованную HeadHunter.<br>Условие:</p>
<i>
<p>У HR Маши на столе лежат две стопки резюме, размерами n и m, в каждом из резюме указана зарплата, числа a[0..n-1] для одной стопки, и 
b[0..m-1] для второй. Нулевой индекс указывает на верхнее резюме в стопке.<br>
Маша устанавливает значение s максимальной суммы зарплат и предлагает очень активному стажеру Саше сыграть в игру:<br>
- За каждый ход Саша может взять одно верхнее резюме из любой стопки и забрать себе в работу<br>
- Саша считает сумму всех зарплат из резюме, которые он взял. Он может брать новые резюме из стопок только таким образом, чтобы эта сумма не превышала s<br>
- Игра заканчивается, если Саша больше не может брать резюме</p>
<p>Нужно выяснить, какое максимальное количество резюме Саша мог бы забрать себе в работу, если бы тоже знал зарплаты, указанные в каждом резюме.</p>
<p>Входные данные (поступают в стандартный поток ввода)<br>
Первая строка – целые числа n, m и s через пробел (1≤n≤10 000, 1≤m≤10 000, 1≤s≤200 000 000)<br>
Далее идут строки с зарплатами резюме в стопках. Всего строк столько, сколько резюме в большей из стопок, на каждой строке один из вариантов:<br>
- два целых числа a и b через пробел (1≤a≤10 000, 1≤b≤10 000),<br>
- a и символ - (если во второй стопке больше нет резюме) через пробел (1≤a≤10 000)<br>
- символ - (если в первой стопке больше нет резюме) и b через пробел (1≤b≤10 000)<br>
Все входные данные наших тестов всегда соблюдают указанные параметры, дополнительные проверки не требуются</p>
<p>Выходные данные (ожидаются в стандартном потоке вывода)<br>Одно целое число, максимальное количество резюме<p>
<p>Пример 1<br>
Ввод:<br>
3 4 11<br>
1 1<br>
2 2<br>
3 3<br>
- 4</p>
<p>Вывод: 5</p>
<p>Пример 2<br>
Ввод:<br>
5 5 10<br>
5 1<br>
1 3<br>
1 3<br>
1 3<br>
1 3</p>
<p>Вывод: 6</p>
<p>Пример 3<br>
Ввод:<br>
6 4 10<br>
4 2<br>
2 1<br>
4 8<br>
6 5<br>
1 -<br>
7 -</p>
<p>Вывод: 4</p>
</i>
<p>Согласно условия задачи и из пояснения в чате поддержки, тесты полностью соответствуют указанным требованиям (например, 1≤a≤10 000). 
Проверять этот момент в коде и обрабатывать ошибки в решении задачи не надо.</p>
