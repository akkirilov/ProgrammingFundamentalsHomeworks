package mainPackage.utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {

    public ArrayList<String> parseInput(String inputLine) {
        return new ArrayList<String>(Arrays.asList(inputLine.split("\\s+")));
    }
    
}
