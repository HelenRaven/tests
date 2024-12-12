import taxes.TaxSystem;

public class Company {
    String title;
    int debit;
    int credit;
    TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem){
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public void shiftMoney(int amount) {
        if (amount > 0){
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes(){
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.printf("Компания '%s' уплатила налог в размере: %d руб.\n\n", title, tax);
        debit = 0;
        credit = 0;
    }

    public void printDebitCredit(){
        System.out.printf("Company: %s\n", title);
        System.out.printf("debit = %d\n", debit);
        System.out.printf("credit = %d\n", credit);
    }

    public int applyDeals(Deal[] deals) {
        for (Deal deal : deals) {
            System.out.println(deal.comment);
            debit += deal.debitChange;
            credit += deal.creditChange;
        }
        int debitMinusCredit = debit - credit;
        payTaxes();

        return debitMinusCredit;
    }
}
