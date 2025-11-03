package lotto.Validator;

import lotto.Domain.Lotto;
import lotto.IOConsole.IOComment;
import lotto.IOConsole.Input;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final int LOTTO_PRICE = 1000;

    public static int parsePurchasePrice(String input) {
        try {
            int price = Integer.parseInt(input);
            Validator.checkDivisionBy1000(price);
            return price / LOTTO_PRICE;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateComment.PARSE_INT_ERROR.getMessage());
        }
    }

    public static List<Integer> parseResultLotto(String input) {
        String[] splitLotto = input.split(",");
        return Validator.checkSplitLotto(splitLotto);
    }

    public static int parseBonus(String input, Lotto resultLotto){
        try{
            int bonus = Integer.parseInt(input);
            Validator.checkOutOfRange(bonus);
            resultLotto.checkBonus(bonus);

            return bonus;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ValidateComment.PARSE_INT_ERROR.getMessage());
        }
    }


}
