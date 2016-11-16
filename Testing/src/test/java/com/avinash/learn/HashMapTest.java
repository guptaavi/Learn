package com.avinash.learn;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class HashMapTest {

	private Map<String, Integer> map;

	@Before
	public void setUp() {
		map = new HashMap<String, Integer>();
	}

	@Test
	@Parameters({ "Avinash, 1", "Rashmi, 2" })
	public void testPutFollowedByGetShouldReturnSameValue(String key, Integer value) {
		map.put(key, value);
		assertThat(map, hasEntry(key, value));
		assertThat(map.get(key), equalTo(value));
	}

	@Test
	public void testDoublePutReplacesValue() {
		map.put("Avinash", 1);
		assertThat(map, hasEntry("Avinash", 1));
		map.put("Avinash", 2);
		assertThat(map, hasEntry("Avinash", 2));
	}

	@Test
	public void testClearRemovesAllContent() {
		map.put("Avinash", 1);
		map.put("Rashmi", 2);
		assertThat(map, hasEntry("Avinash", 1));
		assertThat(map, hasEntry("Rashmi", 2));
		map.clear();
		assertThat(map.entrySet(), Matchers.empty());
	}
	
	@Test
	public void testNullCanBeUsedAsAKey() {
		map.put(null, 1);
		assertThat(map, hasEntry(null, 1));
	}

}
