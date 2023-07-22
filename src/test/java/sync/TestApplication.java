package sync;

import org.testng.annotations.*;
import org.testng.Assert;

public class TestApplication {
	
	@Test
	public void test1() {
		System.out.println("Running test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Running test 2");
		Assert.fail("Failing the test");
	}

}
