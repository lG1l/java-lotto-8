package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.UserLotto;
import lotto.IOConsole.Input;
import lotto.IOConsole.Output;
import lotto.Validator.Parser;

import java.util.List;

public class Controller {
    public void run() {
        UserLotto user = new UserLotto(inputPrice());
        List<Integer> resultNumbers = inputResultNumber();
        int bonus = inputBonus(resultNumbers);
    }

    private int inputPrice() {
        while (true) {
            try {
                return Parser.parsePurchasePrice(Input.requestLottoCount());
            } catch (IllegalArgumentException e) {
                Output.errorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> inputResultNumber() {
        while (true) {
            try {
                return Parser.parseResultLotto(Input.requestLottoResult());
            } catch (IllegalArgumentException e) {
                Output.errorMessage(e.getMessage());
            }
        }
    }

    private int inputBonus(List<Integer> resultLotto) {
        while (true) {
            try {
                return Parser.parseBonus(Input.requestBonusNumber(), resultLotto);
            } catch (IllegalArgumentException e) {
                Output.errorMessage(e.getMessage());
            }
        }
    }
}
