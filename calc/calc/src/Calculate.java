import java.util.Scanner;

public class Calculate {
    Integer[] arabic; //массив целых арабских чисел
    String[] roman; //массив строковых римских чисео

     int operand1; //первый операнд
     int operand2; //второй операнд
     char operation; //оператор

    boolean flag = false; //булевая переменная флага

    boolean minus = false;

    public boolean Minus() {
        return minus;
    }
     char resultChar = '='; //знак равно

    public int getOper1() { //метод для получения значения 1 операнда
        return operand1;
    }

    public int getOper2() { //метод для получения значения 2 операнда
        return operand2;
    }

    public char getOperation() { //метод для получения знака оператора
        return operation;
    }



    public void read() {
        arabic = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //заносим значения арабских чисел в массив
        roman = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; //заносим символы римских символов

        System.out.println("Введите выражение, не забывая в конце поставить ЗНАК РАВНО '='. Пример: '1+2='");
        Scanner scanner = new Scanner(System.in); //создаем объект класса Scanner
        String value = scanner.nextLine(); //считывает с консоли введенную строку
        String newValue = ""; //новая строка, если первый символ отрицательный

        try {
            if ((value.charAt(value.length() - 1) != resultChar)) { //если последний символ не равно, то выбрасываем исключение и выходим из программы
                throw new RuntimeException();
            }
            value = value.substring(0, value.length() - 1); //получение символов из строки
            char value1 = value.charAt(0); //получаем первый символ
            if(value1 == '-') { //если первый символ равен минусу
                minus=true;
                newValue = value.substring(0, 0); //то удаляем его из строки и формируем эту строку без минуса
                newValue += value.substring(0 + 1);
            }
            else {
                newValue = value;
            }
            String[] simbol = newValue.split("[+-/*]"); //возвращаем массив строк, вычисленных путем разделения данной строки вокруг данного регулярного выражения без символов +-/*

            M: for (String s: simbol) { //проходимся по циклу цифр
                for (String item : roman) { //проходимся по символу римских чисео
                    if (s.equals(item)) { //сравниваем содержимое цифр и римских чисел, если совпадает, то флагу присваиваем значение true
                        flag = true;
                        continue M; //и продолжаем цилк
                    }
                }
                flag = false; //если это не римские цифры, то присваиваем флагу false
            }

            if (flag) { //если flag = true
                operand1 = romanToNumber(simbol[0]); //то конвертирует римские цифры в арабские
                operand2 = romanToNumber(simbol[1]);
            } else {
                operand1 = Integer.parseInt(simbol[0]); //иначе получаем значение целого числа
                operand2 = Integer.parseInt(simbol[1]);
            }
            operation = newValue.charAt(simbol[0].length()); //получаем символ по указанному индексу строки [0]
            if ((operand1 > 10) | (operand2 > 10 )) { //если операнды больше 10, то выбрасываем исключение
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 как в римском так и в арабском счислении");
            }

        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Данные введены неверно");
        }
    }

    private static int romanToNumber(String roman) {  //римские в арабские
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return -1;
        }
    }

}

