package lotto.Domain;

import java.util.List;

public class ResultLotto {
    private final Lotto resultLotto;
    private final int bonus;

    public ResultLotto(List<Integer> resultNumbers, int bonus) {
        resultLotto = new Lotto(resultNumbers);
        this.bonus = bonus;
    }
}
