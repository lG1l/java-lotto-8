package lotto.Validator;

public enum ValidateComment {
    PARSE_INT_ERROR("[ERROR] 정수만 입력할 수 있습니다.\n"),
    DIVISION_BY_1000_ERROR("[ERROR] 1000원 단위로만 구매할 수 있습니다.\n"),
    PARSE_RESULT_LOTTO_ERROR("[ERROR] 콤마(,)로 구분된 정수만 입력할 수 있습니다."),
    LOTTO_COUNT_ERROR("[ERROR] 입력된 로또 리스트의 사이즈와 로또 개수가 일치하지 않습니다.\n"),
    DUPLICATE_NUMBER_ERROR("[ERROR] 중복된 숫자가 있습니다.\n"),
    OUT_OF_RANGE_ERROR("[ERROR] 1~45 사이의 정수만 입력할 수 있습니다.\n"),
    BONUS_NUMBER_ERROR("[ERROR] 당첨 번호에 없는 정수를 입력해야 합니다.\n");

    private final String message;

    ValidateComment(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
