public class Expenditure extends Deal{
    public Expenditure(String productName, int price) {
        super( String.format("Покупка %s на %d руб.", productName, price), 0, price);
    }
}
