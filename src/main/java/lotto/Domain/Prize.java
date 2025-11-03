package lotto.Domain;

public enum Prize {
    PRICE_5TH(5000),
    PRICE_4TH(50000),
    PRICE_3RD(1500000),
    PRICE_2ND(30000000),
    PRICE_1ST(2000000000);

    private final int message;

    Prize(int message) {
        this.message = message;
    }

    public int getPrice() {
        return message;
    }
}
