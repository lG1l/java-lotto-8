package lotto.Domain;

import lotto.IOConsole.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultLotto {
    private final int LOTTO_PRICE = 1000;
    private final Lotto resultLotto;
    private final int bonus;

    public ResultLotto(List<Integer> resultNumbers, int bonus) {
        resultLotto = new Lotto(resultNumbers);
        this.bonus = bonus;
    }

    public void makeResult(UserLotto user) {
        List<Integer> print = user.compare(resultLotto, bonus);
        String profit = calculateProfit(print, user);

        Output.result(print, profit);
    }

    private String calculateProfit(List<Integer> result, UserLotto user) {
        int totalPrice = user.getTotalPrice();
        double getMoney = getTotalPrize(result);

        double profit = getMoney / totalPrice * 1000.0;
        profit = Math.round(profit);
        profit /= 10.0;

        return String.format("%.1f", profit);
    }

    private double getTotalPrize(List<Integer> result) {
        return result.get(0) * Prize.PRICE_5TH.getPrice()
                + result.get(1) * Prize.PRICE_4TH.getPrice()
                + result.get(2) * Prize.PRICE_3RD.getPrice()
                + result.get(3) * Prize.PRICE_2ND.getPrice()
                + result.get(4) * Prize.PRICE_1ST.getPrice();
    }
}
