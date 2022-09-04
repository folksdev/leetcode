import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombinationsOfPhoneNumber {

    /*
    [[a, b, c], [d, e, f], [g, h, i]]
    "adg" = 0,0, 1,0, 2,0
    "adh" = 0,0, 1,0, 2,1,
    "adi" = 0,0, 1,0, 2,2
    ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
     */
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));

    }

    static Map<String, List<String>> phoneNumbers = Map.of(
            "2", List.of("a","b","c"),
            "3", List.of("d","e","f"),
            "4", List.of("g","h","i"),
            "5", List.of("j","k","l"),
            "6", List.of("m","n","o"),
            "7", List.of("p","q","r","s"),
            "8", List.of("t","u","v"),
            "9", List.of("w","x","y","z")
    );

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        return getLetterCombination(digits);

    }
    public static List<String> getLetterCombination(String digits){
        if(digits.length() == 0){
            return List.of("");
        }

        String firstDigit = digits.substring(0, 1);
        String restDigits = digits.substring(1);

        return phoneNumbers.get(firstDigit)
                .stream()
                .flatMap(s -> getLetterCombination(restDigits).stream().map(s1 -> s + s1))
                .collect(Collectors.toList());
    }
}
