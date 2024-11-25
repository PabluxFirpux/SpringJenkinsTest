package com.firpo.JenkinsDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JenkinsDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void checkMathsAreStillReal() {
		int x = 5+5;
		int y = 6+1;
		assertEquals(x,10);
		assertEquals(y,7);
	}

	@Test
	void checkMathsAreStillRealTheSequel() {
		int x = 5+5;
		int y = 6+1;
		assertEquals(x,11);
		assertEquals(y,7);
	}

}
