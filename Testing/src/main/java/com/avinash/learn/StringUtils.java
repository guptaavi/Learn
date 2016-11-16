package com.avinash.learn;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

	public static String reverse(String inputStr) {

		if (null == inputStr) {
			throw new IllegalArgumentException("string cannot be null");
		}
		List<String> tempArray = new ArrayList<String>(inputStr.length());
		for (int i = 0; i < inputStr.length(); i++) {
			tempArray.add(inputStr.substring(i, i + 1));
		}
		StringBuilder reversedString = new StringBuilder(inputStr.length());
		for (int i = tempArray.size() - 1; i >= 0; i--) {
			reversedString.append(tempArray.get(i));
		}
		return reversedString.toString();
	}

}
