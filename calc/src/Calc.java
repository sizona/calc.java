public class Calc {

    public static void main(String[] args) {

        Calculate calc = new Calculate();
        int result = 0;
        while (true) { //цикл, пока flag=true
            try {
                calc.read();
            } catch (RuntimeException e) {
                System.out.println("Данные введены не верно");
                break;
            }
            if(calc.minus) { //если первый символ минус
                result = Operation.operMinus(calc.getOper1(), calc.getOper2(), calc.getOperation()); //метод, который считает со знаком минус
            } else {
                result = Operation.oper(calc.getOper1(), calc.getOper2(), calc.getOperation()); //метод, который считает без знака минус
            }
            if (calc.flag){ //если flag в значение true
                System.out.println(Converting.RomantoArab(result)); //метод конвертирования римских в арабские числа
            } else System.out.println(result);
        }
    }
}


