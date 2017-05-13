package cucumberTest.testMul;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utility.UtilityClass;

public class TestMulStepDefinationFile
{
	public TestMulData testDataSum;
	public UtilityClass utilityClass;
	public List<TestMulData> collTestDataSumGlobal;
	public int errorFlag = 0;
	public String tcID = "";

	public TestMulStepDefinationFile()
	{
		this.testDataSum = new TestMulData();
		this.utilityClass = new UtilityClass();
	}
  

	@Given("^Mul_test Data is$")
	public void test_Data_is(List<TestMulData> colltestSumData)
	{
		this.collTestDataSumGlobal = colltestSumData;
	}

	@When("^Mul_two numbers$")
	public void mul_two_numbers()
	{
		utilityClass.launchBrowser("http://google.com");
		for (int k = 0; k <= this.collTestDataSumGlobal.size() - 1; k++)
		{
			tcID = this.collTestDataSumGlobal.get(k).gettC();
			int res = utilityClass.multiply(collTestDataSumGlobal.get(k).getA(), collTestDataSumGlobal.get(k).getB());
			if (collTestDataSumGlobal.get(k).getResult() != res)
			{
				errorFlag = errorFlag + 1;
			}
			if (errorFlag != 0)
			{
				System.out.println(tcID + " -- failed");
			} else
			{
				System.out.println(tcID + " -- Passed");
			}
			errorFlag = 0;
		}
	}

}
