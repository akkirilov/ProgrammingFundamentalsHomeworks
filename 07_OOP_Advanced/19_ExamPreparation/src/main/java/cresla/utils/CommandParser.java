package cresla.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandParser {

	public List<String> parseBySpace(String input) {
		return Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
	}
	
}
