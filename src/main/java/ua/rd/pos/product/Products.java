package ua.rd.pos.product;

public enum Products implements Product {
    TEA(25),
    COFFEE(35),
    JUICE(45);

    private int price;

    Products(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return 0;
    }
}
