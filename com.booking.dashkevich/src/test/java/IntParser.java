import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntParser {

    public int parseFirstInt(String stringToParse){
        Matcher numeral = Pattern.compile("\\d+").matcher(stringToParse);
        return numeral.find() ? Integer.parseInt(numeral.group()) : 0;
    }
}
