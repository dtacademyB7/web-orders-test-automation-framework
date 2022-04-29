package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTests {



    @Test
    public void test1(){
        Assert.assertEquals(Calculator.add(4,5), 9);
    }

    @Test
    public void test2(){
        Assert.assertEquals(Calculator.add(-23,0), -23);
    }


    @Test
    public void test3(){
        Assert.assertEquals(Calculator.divide(10,0), 0);
    }

}
