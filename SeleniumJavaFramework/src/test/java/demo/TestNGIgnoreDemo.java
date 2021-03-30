package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore
public class TestNGIgnoreDemo {
	
	@Test
	@Ignore
	public void test1() {
		System.out.println("Inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside test2");
	}
	
	@Test
	public void test3() {
		System.out.println("Inside test3");
	}
}
