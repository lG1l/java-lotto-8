package lotto.Validator;

import lotto.IOConsole.IOComment;
import lotto.IOConsole.Input;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final int LOTTO_PRICE = 1000;
    private static final int ARRAY_MAX_SIZE = 46;

    public static int parsePurchasePrice(String input) {
        try {
            int price = Integer.parseInt(input);
            checkDivisionBy1000(price);
            return price / LOTTO_PRICE;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateComment.PARSE_INT_ERROR.getMessage());
        }
    }

    private static void checkDivisionBy1000(int input) {
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ValidateComment.DIVISION_BY_1000_ERROR.getMessage());
        }
    }

    public static List<Integer> parseResultLotto(String input) {
        String[] splitLotto = input.split(",");
        return checkSplitLotto(splitLotto);
    }

    private static List<Integer> checkSplitLotto(String[] input) {
        List<Integer> resultLotto = new ArrayList<Integer>();

        for (String number : input) {
            try {
                int lotto = Integer.parseInt(number);
                checkOutOfRange(lotto);
                resultLotto.add(lotto);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ValidateComment.PARSE_RESULT_LOTTO_ERROR.getMessage());
            }
        }

        checkLottoCount(resultLotto);
        checkDuplicate(resultLotto, ValidateComment.DUPLICATE_NUMBER_ERROR.getMessage());

        return resultLotto;
    }

    private static void checkOutOfRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(ValidateComment.OUT_OF_RANGE_ERROR.getMessage());
        }
    }

    private static void checkLottoCount(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(ValidateComment.LOTTO_COUNT_ERROR.getMessage());
        }
    }

    private static void checkDuplicate(List<Integer> lotto, String output) {
        boolean[] usedNumbers = new boolean[ARRAY_MAX_SIZE];

        for (Integer num : lotto) {
            if (usedNumbers[num]) {
                throw new IllegalArgumentException(output);
            }
            usedNumbers[num] = true;
        }
    }

    public static int parseBonus(String input, List<Integer> resultLotto){
        try{
            int bonus = Integer.parseInt(input);
            resultLotto.add(bonus);

            checkOutOfRange(bonus);
            checkDuplicate(resultLotto, ValidateComment.BONUS_NUMBER_ERROR.getMessage());

            return bonus;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ValidateComment.PARSE_INT_ERROR.getMessage());
        }
    }


}
