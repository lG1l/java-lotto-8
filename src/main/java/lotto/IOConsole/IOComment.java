package lotto.IOConsole;

public enum IOComment {
    ASK_LOTTO_COUNT("구입금액을 입력해 주세요."),
    ASK_LOTTO_RESULT("\n당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PRINT_LOTTO_COUNT("\n%d개를 구매했습니다.\n"),
    PRINT_RESULT("\n당첨 통계\n---\n3개 일치 (5,000원) - %d개\n4개 일치 (50,000원) - %d개" +
            "\n5개 일치 (1,500,000원) - %d개\n5개 일치, 보너스 볼 일치 (30,000,000원) - %d개" +
            "\n6개 일치 (2,000,000,000원) - %d개\n총 수익률은 %f%입니다.");

    private final String message;

    IOComment(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
