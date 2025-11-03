package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
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
