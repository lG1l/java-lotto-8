package lotto;

import lotto.Domain.Lotto;
import lotto.Validator.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    // 구매 금액 유효성 검사
    @DisplayName("구매 금액으로 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void inputCharacter() {
        assertThatThrownBy(() -> Parser.parsePurchasePrice("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수를 입력할 경우 예외가 발생한다.")
    @Test
    void notDivisibleBy1000() {
        assertThatThrownBy(() -> Parser.parsePurchasePrice("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로만 구매할 수 있습니다.\n");
    }

    @DisplayName("금액을 입력할 경우 정확한 복권 개수를 도출하는 지 테스트")
    @Test
    void checkLottoCount() {
        assertThat(Parser.parsePurchasePrice("10000"))
                .isEqualTo(10);
    }

    // 당첨번호 유효성 검사
    @DisplayName("당첨 번호로 정수가 아닌 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void inputResultLottoCharacter() {
        assertThatThrownBy(() -> Parser.parseResultLotto("a,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 콤마(,)로 구분된 정수만 입력할 수 있습니다.");
    }

    @DisplayName("당첨 번호로 콤마(,)가 아닌 구분자를 입력할 경우 예외가 발생한다.")
    @Test
    void inputResultLottoDelimiter() {
        assertThatThrownBy(() -> Parser.parseResultLotto("1/2/3/4/5/6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 콤마(,)로 구분된 정수만 입력할 수 있습니다.");
    }

    @DisplayName("당첨 번호로 45보다 큰 값을 입력한 경우 예외가 발생한다.")
    @Test
    void inputResultLottoOverOfRange() {
        assertThatThrownBy(() -> Parser.parseResultLotto("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
    }

    @DisplayName("당첨 번호로 1보다 작은 정수를 입력할 경우 예외가 발생한다.")
    @Test
    void inputResultLottoUnderOfRange() {
        assertThatThrownBy(() -> Parser.parseResultLotto("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
    }

    @DisplayName("당첨 번호의 개수로 6개를 입력하지 않을 때 예외가 발생한다.")
    @Test
    void inputResultLottoCountMatching() {
        assertThatThrownBy(() -> Parser.parseResultLotto("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력된 로또 리스트의 사이즈와 로또 개수가 일치하지 않습니다.\n");
    }

    // 보너스 번호 유효성 검사
    @DisplayName("보너스 번호로 정수가 아닌 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void inputBonusCharacter() {
        assertThatThrownBy(() -> Parser.parseBonus("a", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("보너스 번호로 45보다 큰 값을 입력한 경우 예외가 발생한다.")
    @Test
    void inputBonusOverOfRange() {
        assertThatThrownBy(() -> Parser.parseBonus("46", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
    }

    @DisplayName("보너스 번호로 1보다 작은 정수를 입력할 경우 예외가 발생한다.")
    @Test
    void inputBonusUnderOfRange() {
        assertThatThrownBy(() -> Parser.parseBonus("0", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
    }

    @DisplayName("당첨 번호에 있는 숫자를 보너스 번호로 입력하면 예외가 발생한다")
    @Test
    void inputBonusContainsResultLotto() {
        assertThatThrownBy(() -> Parser.parseBonus("1", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 없는 정수를 입력해야 합니다.\n");
    }
}