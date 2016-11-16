package com.avinash.learn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class StringUtilsTest {

	@Test
	@Parameters({ "Avinash, hsanivA", "A, A" })
	public void testReverse(String inputStr, String reverseString) {
		assertThat(StringUtils.reverse(inputStr)).isEqualTo(reverseString);
	}

}
