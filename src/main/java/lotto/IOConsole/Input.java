package lotto.IOConsole;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String requestLottoCount() {
        System.out.println(IOComment.ASK_LOTTO_COUNT.getMessage());
        return Console.readLine();
    }

    public static String requestLottoResult() {
        System.out.println(IOComment.ASK_LOTTO_RESULT.getMessage());
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        System.out.println(IOComment.ASK_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
