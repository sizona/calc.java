import java.util.List;

public class Converting extends Calculate { //класс для конвертирования римских в арабские цифры

    public static String RomantoArab(int number) { //метод римский на арабский
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues(); //создаем список перечисления римских чисел с выводом метода сортировки

        int i = 0; //счетчик
        StringBuilder sb = new StringBuilder(); //редактируемый строковый класс

        while ((number > 0) && (i < romanNumerals.size())) { //цикл продолжается до тех пор, пока цифры больше нуля и до конца списка
            RomanNumeral currentSymbol = romanNumerals.get(i); //получаем методом get текущий символ
            if (currentSymbol.getValue() <= number) { //если значение текущего символа меньше или равно, чем number(арабское число)
                sb.append(currentSymbol.name()); //Преобразовываем переданный объект в строку и добавляет к текущей строке с возвращением имени
                number -= currentSymbol.getValue(); //вычитаем из number значение текущего символа
            } else {
                i++; //если значение текущего символа меньше, чем Number, то увеличиваем счетчик и переходим на следующую итерацию
            }
        }

        return sb.toString(); //преобразовываем объект sb в строку и возвращаем значение
    }

}
