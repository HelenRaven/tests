package taxes;

public class IncomeMinusExpenses extends TaxSystem{
    @Override
    public int calcTaxFor(int debit, int credit) {
        return Math.max(0, (debit - credit) * 15 / 100);
    }
}
