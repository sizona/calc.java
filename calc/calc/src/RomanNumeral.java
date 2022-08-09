import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum  RomanNumeral { //перечисление для представления римских цифр
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private final int value;

    RomanNumeral(int value) {
        this.value = value;
    } //метод "set" записывает значение римского символа в переменную

    public int getValue() {
        return value;
    } //медод get - возвращает значение римского символа

    public static List<RomanNumeral> getReverseSortedValues() { //сортировка списка с римскими символами
                                                               //Этот метод позволит явно получить определенные римские цифры в порядке убывания значений
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

}
