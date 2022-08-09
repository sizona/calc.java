class Operation {
    static int res;
    static int oper(int count1, int count2, char operation){

        switch (operation){
            case '+': res = count1 + count2; break;
            case '-': res = count1 - count2; break;
            case '*': res = count1 * count2; break;
            case '/': res = count1 / count2; break;
        }
        return res;
    }
    static int operMinus(int count1, int count2, char operation){ //метод, если первый операнд отрицательный

        switch (operation){
            case '+': res = -count1 + count2; break;
            case '-': res = -count1 - count2; break;
            case '*': res = -count1 * count2; break;
            case '/': res = -count1 / count2; break;
        }
        return res;
    }
}
