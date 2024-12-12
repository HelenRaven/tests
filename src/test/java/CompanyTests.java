import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import taxes.Income;
import taxes.IncomeMinusExpenses;

import java.lang.reflect.Type;
import java.util.stream.Stream;

public class CompanyTests {
    static Company company;

    @BeforeAll
    public static void setInit() {
        company = new Company("ООО Фирма веников не вяжет", new IncomeMinusExpenses());
    }

    public static Stream<Arguments> testShiftMoney() {
        return Stream.of(
                Arguments.of(100, 100, 0),
                Arguments.of(500, 600, 0),
                Arguments.of(-100, 600, 100),
                Arguments.of(200, 800, 100)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testShiftMoney(int a, int expectedDebit, int expectedCredit) {
        company.shiftMoney(a);

        Assertions.assertEquals(expectedDebit, company.debit);
        Assertions.assertEquals(expectedCredit, company.credit);
    }

    @Test
    public void testSetTaxSystem(){
        company.setTaxSystem(new Income());

        Assertions.assertInstanceOf(Income.class , company.taxSystem);
    }

    @Test
    public void testApplyDeals(){
        Deal[] deals = {
                new Sale("soup", 100),
                new Sale("pasta", 550),
                new Sale("brouny", 350),
                new Expenditure("potato", 35),
                new Expenditure("bakon", 250),
                new Expenditure("cocoa", 30)
        };

        int actual = company.applyDeals(deals);
        int expected  = -685;

        Assertions.assertEquals(expected, actual);
    }
}
