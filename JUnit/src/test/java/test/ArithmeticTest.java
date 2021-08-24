package test;

import com.mphasis.math.Arithmetic;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ArithmeticTest {

    @BeforeClass
    public static void startTestCase(){
        System.out.println("Testcase started");
    }

    @AfterClass
    public static void endTestCase(){
        System.out.println("Testcase ended");
    }

    @Before
    public void testStart(){
        System.out.println("Starting test method");
    }

    @After
    public void testEnd(){
        System.out.println("Ending test method");
    }

    @Test   //Annotation is mandatory
    public void testSum(){
        int expectedResult = 5;
        Arithmetic arithmetic = new Arithmetic();
        int actualResult = arithmetic.sum(2,3);
        System.out.println("Inside testSum");
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testMul(){
        System.out.println("Inside testMul");
    }
}
