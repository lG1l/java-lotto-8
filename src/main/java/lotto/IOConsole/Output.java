package lotto.IOConsole;

import java.util.List;

public class Output {
    public static void purchaseCount(int count) {
        System.out.printf(IOComment.PRINT_LOTTO_COUNT.getMessage(), count);
    }

    public static void userLottoNumber(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void result(List<Integer> result, float profit) {
        System.out.printf(IOComment.PRINT_RESULT.getMessage(),
                result.get(0), result.get(1), result.get(2), result.get(3), result.get(4), profit);
    }

    public static void errorMessage(String message){
        System.out.println(message);
    }
}
