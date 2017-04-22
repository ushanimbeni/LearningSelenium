package features.multiply;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.UtilityClass;

public class TestMulStepDefination {

	private TestMulData testMulData;
	private UtilityClass utilityClass;
	
	 public TestMulStepDefination()
	{
		this.testMulData = new TestMulData();
		this.utilityClass = new UtilityClass();
	}
	
@Given("^mul_two numbers are (\\d+) and (\\d+)$")
public void TestData(int arg1, int arg2)  {
	testMulData.setM(arg1);
	testMulData.setN(arg2);
    System.out.println("Test data has been initilized successfully");
}

@When("^mul_I will Mul two numbers$")
public void MultiplyNumbers()  {
	testMulData.setOutput(utilityClass.multiply(testMulData.getM(),testMulData.getN()));
}

@Then("^mul_the output should be (\\d+)$")
public void Result(int arg1)  {
	
    Assert.assertEquals(arg1, testMulData.getOutput());

}
}
