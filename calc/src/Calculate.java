import java.util.Scanner;

class Calculate {
    Integer[] arabic; //массив арабских чисел
    String[] roman; //массив римских чисео

     int operand1;
     int operand2;
     char operation;

    boolean flag = false;

    boolean minus = false;

        int getOper1() { //метод для получения значения 1 операнда
        return operand1;
    }

    int getOper2() { //метод для получения значения 2 операнда
        return operand2;
    }

    char getOperation() { //метод для получения знака оператора
        return operation;
    }



    void read() {
        arabic = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        roman = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        System.out.println("Введите выражение. Например: '1+2' + Enter");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String newValue = "";

        try {

            char value1 = value.charAt(0);
            if(value1 == '-') {
                minus=true;
                newValue = value.substring(0, 0);
                newValue += value.substring(0 + 1);
            }
            else {
                newValue = value;
            }
            String[] simbol = newValue.split("[+-/*]"); //возвращаем массив строк, вычисленных путем разделения данной строки вокруг данного регулярного выражения без символов +-/*

            M: for (String s: simbol) {
                for (String item : roman) {
                    if (s.equals(item)) { //сравниваем содержимое цифр и римских чисел, если совпадает, то флагу присваиваем значение true
                        flag = true;
                        continue M;
                    }
                }
                flag = false; //если это не римские цифры, то присваиваем флагу false
            }

            if (flag) {
                operand1 = romanToNumber(simbol[0]);
                operand2 = romanToNumber(simbol[1]);
            } else {
                operand1 = Integer.parseInt(simbol[0]);
                operand2 = Integer.parseInt(simbol[1]);
            }
            operation = newValue.charAt(simbol[0].length());
            if ((operand1 > 10) | (operand2 > 10 )) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 как в римском так и в арабском счислении");
            }

        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Данные введены неверно");
        }
    }

   static int romanToNumber(String roman) {
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

