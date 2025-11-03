package lotto.Validator;

public class Parser {
    private static final int LOTTO_PRICE = 1000;

    public static int parsePurchasePrice(String input) {
        try {
            int price = Integer.parseInt(input);
            checkDivisionBy1000(price);
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateComment.PARSE_INT_ERROR.getMessage());
        }
    }

    private static void checkDivisionBy1000(int input) {
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ValidateComment.DIVISION_BY_1000_ERROR.getMessage());
        }
    }
}
