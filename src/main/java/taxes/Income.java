package taxes;

public class Income extends TaxSystem{
    @Override
    public int calcTaxFor(int debit, int credit) {
        return debit * 6 / 100;
    }
}
