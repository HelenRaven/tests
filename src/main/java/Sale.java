public class Sale extends Deal{
    public Sale(String productName, int price) {
        super(String.format("Продажа %s на %d руб.", productName, price), price, 0);
    }
}
