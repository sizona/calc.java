public class Operation { //операторы для калькулятора
    static int res;
    static int oper(int count1, int count2, char operation){ //метод с параметрами 1 операнда, второго операнда и оператора

        switch (operation){ //условный оператор, который дает возможность сравнивать переменную со списком значений.
            case '+': res = count1 + count2; break;
            case '-': res = count1 - count2; break;
            case '*': res = count1 * count2; break;
            case '/': res = count1 / count2; break;
        }
        return res;
    }
    static int operMinus(int count1, int count2, char operation){ //метод с параметрами 1 операнда, второго операнда и оператора ЕСЛИ ПЕРВЫЙ ОПЕРАНД ОТРИЦАТЕЛЬНЫЙ

        switch (operation){ //условный оператор, который дает возможность сравнивать переменную со списком значений.
            case '+': res = -count1 + count2; break;
            case '-': res = -count1 - count2; break;
            case '*': res = -count1 * count2; break;
            case '/': res = -count1 / count2; break;
        }
        return res;
    }
}
