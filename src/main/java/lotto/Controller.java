package lotto;

import lotto.Domain.UserLotto;
import lotto.IOConsole.Input;
import lotto.IOConsole.Output;
import lotto.Validator.Parser;

public class Controller {
    public void run(){
        UserLotto user = new UserLotto(inputPrice());
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
}
