package study;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class StudyString {
    public static List<String> requirements1(String input) {
        return new ArrayList<String>(Arrays.asList(input.split(",")));
    }

    public static String requirements2(String input) {
        int endIndex = input.length() - 1;
        return input.substring(1,endIndex);
    }

    public static char requirements3(String input, int index){
        return input.charAt(index);
    }
}
