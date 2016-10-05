package ua.rd.pos.product;

public enum Products implements Product {
    TEA(25, "Tea"),
    COFFEE(35, "Coffee"),
    JUICE(45, "Juice");

    private int price;
    private String name;

    Products(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
