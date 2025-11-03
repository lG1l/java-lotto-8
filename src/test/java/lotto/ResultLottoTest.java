package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.ResultLotto;
import lotto.Domain.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultLottoTest extends NsTest {
    ResultLotto result;
    UserLotto user;

    @DisplayName("로또 당첨 결과를 올바르게 출력하는지에 대한 테스트")
    @Test
    void resultTest() {
        Lotto resultLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        result = new ResultLotto(resultLotto, 7);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    user = new UserLotto(8);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );

        result.makeResult(user);
        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 62.5%입니다."
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
