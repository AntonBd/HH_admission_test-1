import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in;

    public static void main(String[] args) {
        int result = 0;

        //1. Ввод строки с клавиатуры и присвоение значения переменным
        String[] line_parts = newScanner();         //Чтение строки с кливиатуры и возврат массива
        int n = Integer.parseInt(line_parts[0]);    //Размер 1-ой стопки
        int m = Integer.parseInt(line_parts[1]);    //Размер 2-ой стопки
        int s = Integer.parseInt(line_parts[2]);    //Максимальная сумма зарплат

        //2. Добавление значений в стопки
        ArrayList<Integer> stack_a = new ArrayList<>();     //1-ая стопка
        ArrayList<Integer> stack_b = new ArrayList<>();     //2-ая стопка
        int line_counts = n > m ? n : m;                    //Размер наиболее толстой стопки

        for (int i = 0; i < line_counts; i++) {
            String[] value_line = newScanner();             //Чтение очередной строки с зарплатой, возврат массива

            for (int j = 0; j < 2; j++) {                                     //Цикл для 0-го и 1-го элементов массива
                ArrayList<Integer> array = (j == 0) ? stack_a : stack_b;      //Временный лист со ссылкой на нужный лист

                if (!value_line[j].equals("-") && value_line[j] != null) {    //Если значение не "-"
                    array.add(Integer.parseInt(value_line[j]));               //Парс значения и помещение в лист
                }
            }
        }

        //3. Расчет суммы зарплат в резюме
        ArrayList<Integer> temp = new ArrayList<>();        //Временная переменная для одной стопки
        ArrayList<Integer> temp2 = new ArrayList<>();       //Временная переменная для другой стопки
        int sum = 0;                                        //Сумма зарплат в отобранных резюме

        //3.1. Вариант решения для ситуации, когда в 1-ом столбце сумма зарплат < s
        int stack_a_sum = sumOfArrayValues(stack_a);        //Сумма всех значений в 1-ой стопке
        int stack_b_sum = sumOfArrayValues(stack_b);        //Сумма всех значений во 2-ой стопке

        //3.2. Если сумма значений в одной стопке <=s и < суммы другой стопки, то temp присваивается ссылка на эту стопку
        if (stack_a_sum <= s && stack_b_sum <= s) {
            temp = stack_a_sum < stack_b_sum ? stack_a : stack_b;
            temp2 = stack_a_sum >= stack_b_sum ? stack_a : stack_b;
        } else if (stack_a_sum <= s) {
            temp = stack_a;
            temp2 = stack_b;
        } else if (stack_b_sum <= s) {
            temp = stack_b;
            temp2 = stack_a;
        }

        //3.3. Расчет суммы значений в стопке со ссылкой temp
        for (int i = temp.size(); i > 0; i--) {
            sum += temp.remove(0);
            result++;
        }

        //3.4. Логика для ситуации, когда до значения s еще можно добрать из другой стопки
        for (int i = temp2.size(); i > 0; i--) {
            sum += temp2.remove(0);
            if (sum <= s) {
                result++;
            }
            else {
                break;                      //Прерывание цикла при выходе за пределы s
            }
        }

        //4. Вариант решения для ситуации, когда оптимальнее брать резюме с наименьшей зарплатой из верхних резюме в стопках
        if (result == 0) {                  //Если логика выше не реализована и поэтому result = 0
            while (true) {
                temp = stack_a.get(0) < stack_b.get(0) ? stack_a : stack_b;   //Определение стопки temp на текущий цикл
                sum += temp.remove(0);                                  //Расчет суммы и удаление верхнего значения
                if (sum > s) {
                    break;                                                   //Прерывание при выходе за пределы s
                }
                result++;                                                    //Увеличение result в пределах s
            }
        }
        System.out.println(result);                                         //Вывод результата на экран
    }

    //Метод для ввода значений с клавиатуры
    private static String[] newScanner() {
        in = new Scanner(System.in);
        if (in.hasNextLine()) {
            String line = in.nextLine();
            return line.split(" ");
        }
        return null;
    }

    //Метод для расчета суммы всех значений внутри листа
    private static int sumOfArrayValues(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}