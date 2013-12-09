package mywork20131209;

/**
 * 商品の個数と単価のセット
 *
 * @author rks-user
 *
 */
public class ItemSet {
    private int number;
    private int price;

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public ItemSet (int number, int price) {
        this.number = number;
        this.price = price;
    }
}
