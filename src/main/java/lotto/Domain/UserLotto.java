package lotto.Domain;

import java.util.ArrayList;
import java.util.List;

import lotto.Feature.RandomNumber;
import lotto.IOConsole.Output;

public class UserLotto {
    private List<Lotto> userLottos;

    public UserLotto(int count) {
        Output.purchaseCount(count);

        userLottos = new ArrayList<Lotto>();
        for (int i = 0; i < count; i++) {
            List<Integer> plus = RandomNumber.makeLotto();
            Output.userLottoNumber(plus);
            Lotto addLotto = new Lotto(plus);
            userLottos.add(addLotto);
        }
    }
}
