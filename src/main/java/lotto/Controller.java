package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.ResultLotto;
import lotto.Domain.UserLotto;
import lotto.IOConsole.Input;
import lotto.IOConsole.Output;
import lotto.Validator.Parser;

import java.util.List;

public class Controller {
    public void run() {
        UserLotto user = inputPrice();
        Lotto resultLotto = inputResultNumber();
        int bonus = inputBonus(resultLotto);
        ResultLotto result = new ResultLotto(resultLotto, bonus);

        result.makeResult(user);
    }

    private UserLotto inputPrice() {
        while (true) {
            try {
                return new UserLotto(Parser.parsePurchasePrice(Input.requestLottoCount()));
            } catch (IllegalArgumentException e) {
                Output.errorMessage(e.getMessage());
            }
        }
    }

    private Lotto inputResultNumber() {
        while (true) {
            try {
                return new Lotto(Parser.parseResultLotto(Input.requestLottoResult()));
            } catch (IllegalArgumentException e) {
                Output.errorMessage(e.getMessage());
            }
        }
    }

    private int inputBonus(Lotto resultLotto) {
        while (true) {
            try {
                return Parser.parseBonus(Input.requestBonusNumber(), resultLotto);
            } catch (IllegalArgumentException e) {
                Output.errorMessage(e.getMessage());
            }
        }
    }
}
