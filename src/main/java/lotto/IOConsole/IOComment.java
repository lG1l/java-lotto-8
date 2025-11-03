package lotto.IOConsole;

public enum IOComment {
    ASK_LOTTO_COUNT("구입금액을 입력해 주세요."),
    ASK_LOTTO_RESULT("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    IOComment(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
