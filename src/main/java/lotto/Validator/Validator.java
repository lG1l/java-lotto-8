package lotto.Validator;

import lotto.Domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    private static final int ARRAY_MAX_SIZE = 46;

    public static void checkDivisionBy1000(int input) {
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ValidateComment.DIVISION_BY_1000_ERROR.getMessage());
        }
    }

    public static List<Integer> checkSplitLotto(String[] input) {
        List<Integer> resultLotto = new ArrayList<Integer>();

        for (String number : input) {
            try {
                int lotto = Integer.parseInt(number);
                resultLotto.add(lotto);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ValidateComment.PARSE_RESULT_LOTTO_ERROR.getMessage());
            }
        }

        return resultLotto;
    }

    public static void checkOutOfRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(ValidateComment.OUT_OF_RANGE_ERROR.getMessage());
        }
    }

    public static void checkLottoCount(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(ValidateComment.LOTTO_COUNT_ERROR.getMessage());
        }
    }

    public static void checkDuplicate(List<Integer> lotto, String output) {
        boolean[] usedNumbers = new boolean[ARRAY_MAX_SIZE];

        for (Integer num : lotto) {
            if (usedNumbers[num]) {
                throw new IllegalArgumentException(output);
            }
            usedNumbers[num] = true;
        }
    }
}
