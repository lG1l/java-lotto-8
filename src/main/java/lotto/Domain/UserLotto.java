package lotto.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.IOConsole.Output;

public class UserLotto {
    private final int LOTTO_PRICE = 1000;
    private final List<Lotto> userLottos;

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

    public List<Integer> compare(Lotto resultLotto, int bonus) {
        List<Integer> print = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));

        for (Lotto lotto : userLottos) {
            int matchIndex = lotto.compare(resultLotto, bonus);
            if (matchIndex == -1) {
                continue;
            }

            int fixCount = print.get(matchIndex) + 1;
            print.set(matchIndex, fixCount);
        }

        return print;
    }

    public int getTotalPrice() {
        return userLottos.size() * LOTTO_PRICE;
    }
}
