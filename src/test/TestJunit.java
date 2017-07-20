package test;

import org.junit.Assert;
import org.junit.Test;

public class TestJunit {
	
	@Test
	public void test(){
		int number=add(2,4);
		Assert.assertEquals("加法失败", 5, number);
	}
	
	public int add(int num1,int num2){
		int result=num1+num2;
		return result;
	}
}
