package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.LottoResult;
import lotto.Domain.UserLotto;
import lotto.IOConsole.Input;
import lotto.IOConsole.Output;
import lotto.Validator.Parser;

import java.util.List;

public class Controller {
    public void run(){
        UserLotto user = new UserLotto(inputPrice());
        Lotto resultLotto = new Lotto(resultNumber());
    }

    private int inputPrice(){
        while(true){
            try{
                return Parser.parsePurchasePrice(Input.requestLottoCount());
            } catch (IllegalArgumentException e){
                Output.errorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> resultNumber(){
        while(true){
            try{
                return Parser.parseResultLotto(Input.requestLottoResult());
            } catch (IllegalArgumentException e){
                Output.errorMessage(e.getMessage());
            }
        }
    }
}
