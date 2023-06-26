public enum Discount {
    SALE_05(0.5f),
    SALE_10(10),
    SALE_15(15),
    SALE_20(20);

    final float i;
    Discount(float i) {
        this.i = i;
    }
}
