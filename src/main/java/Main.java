import taxes.Income;
import taxes.IncomeMinusExpenses;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("ООО Фирма веников не вяжет", new IncomeMinusExpenses());

        Deal[] deals1kvartal = {
                new Sale("soup", 100),
                new Sale("pasta", 550),
                new Sale("brouny", 350),
                new Expenditure("potato", 35),
                new Expenditure("bakon", 250),
                new Expenditure("cocoa", 30)
        };

        int res = company.applyDeals(deals1kvartal);
        System.out.println(res);

        company.setTaxSystem(new Income());
        Deal[] deals2kvartal = {
                new Sale("pizza", 650),
                new Sale("potato fri", 250),
                new Sale("pepsi", 350),
                new Expenditure("tomato", 75),
                new Expenditure("potato", 25),
                new Expenditure("pepsi", 50)
        };

        company.applyDeals(deals2kvartal);
    }
}
