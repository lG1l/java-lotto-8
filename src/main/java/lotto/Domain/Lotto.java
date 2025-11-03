package lotto.Domain;

import lotto.Validator.ValidateComment;
import lotto.Validator.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkLottoCount(numbers);
        for(int number : numbers){
            Validator.checkOutOfRange(number);
        }
        Validator.checkDuplicate(numbers, ValidateComment.DUPLICATE_NUMBER_ERROR.getMessage());
    }

    public void checkBonus(int bonus){
        if(numbers.contains(bonus)){
            throw new IllegalArgumentException(ValidateComment.BONUS_NUMBER_ERROR.getMessage());
        }
    }

    public int compare(Lotto result, int bonus) {
        int count = 0;

        for (int number : result.numbers) {
            if (numbers.contains(number)) {
                count++;
            }
        }

        return matchingIndex(count, bonus);
    }

    public int matchingIndex(int count, int bonus) {
        if(count == 3) {
            return 0;
        }
        if(count == 4) {
            return 1;
        }
        if(count == 5) {
            if(numbers.contains(bonus)){
                return 3;
            }
            return 2;
        }
        if(count == 6){
            return 4;
        }
        return -1;
    }
}
