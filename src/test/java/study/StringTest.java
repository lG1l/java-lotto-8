package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @DisplayName("요구사항 1 - 1")
    @Test
    void correctReturn1_1() {
        assertThat(StudyString.requirements1("1,2"))
                .contains("1")
                .contains("2");
    }

    @DisplayName("요구사항 1 - 2")
    @Test
    void correctReturn1_2() {
        assertThat(StudyString.requirements1("1"))
                .containsExactly("1");
    }

    @DisplayName("요구사항 2")
    @Test
    void correctReturn2() {
        assertThat(StudyString.requirements2("(1,2)"))
                .isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 - 1")
    @Test
    void correctReturn3_1() {
        assertThat(StudyString.requirements3("(1,2)",1))
                .isEqualTo('1');
    }

    @DisplayName("인덱스에서 벗어난 값을 인자로 넘기면 예외가 발생한다.")
    @Test
    void throwException() {
        assertThatThrownBy(() -> StudyString.requirements3("(1,2)",6))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
