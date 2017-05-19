package cucumberTest.testSum;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.UtilityClass;

public class TestSumStepDefinationFile
{
	public TestSumData testDataSum;
	public UtilityClass utilityClass;
	public List<TestSumData> collTestDataSumGlobal;
	public int errorFlag = 0;
	public String tcID = "";
	private static Logger log;

	public TestSumStepDefinationFile() throws Exception
	{
		this.testDataSum = new TestSumData();
		this.utilityClass = new UtilityClass();
		Properties props = new Properties();
		String log4jFile = System.getProperty("user.dir") + "/log4j.properties";
		props.load(new FileInputStream(log4jFile));
		PropertyConfigurator.configure(props);
		log = Logger.getLogger(TestSumStepDefinationFile.class);
	}
	
	 @cucumber.api.java.Before
		public void Before()
		{
		System.out.println("Executed function Before");

		}

	@cucumber.api.java.After
	public void After()
	{
		System.out.println("Executed function After");

	}

	@Given("^two numbers are (\\d+) and (\\d+)$")
	public void testData(int arg1, int arg2)
	{
		testDataSum.setA(arg1);
		testDataSum.setB(arg2);
		System.out.println("Test data has been initilized successfully");
	}

	@When("^I will add two numbers$")
	public void i_will_add_two_numbers()
	{
		testDataSum.setResult(utilityClass.sum(testDataSum.getA(), testDataSum.getB()));
	}

	@Then("^the output should be (\\d+)$")
	public void VrifyOP(int arg1)
	{
		Assert.assertEquals(arg1, testDataSum.getResult());
	}

	@Given("^Sum_test Data is$")
	public void test_Data_is(List<TestSumData> colltestSumData)
	{
		this.collTestDataSumGlobal = colltestSumData;
	}

	@When("^Sum_two numbers$")
	public void add_two_numbers() throws IOException
	{
//		utilityClass.launchBrowser(utilityClass.getPropertyValue("urlRediff"));
		log.info("opned Rediff browser");
		for (int k = 0; k <= this.collTestDataSumGlobal.size() - 1; k++)
		{
			tcID = this.collTestDataSumGlobal.get(k).gettC();
			int res = utilityClass.sum(collTestDataSumGlobal.get(k).getA(), collTestDataSumGlobal.get(k).getB());
			if (collTestDataSumGlobal.get(k).getResult() != res)
			{
				errorFlag = errorFlag + 1;
			}
			if (errorFlag != 0)
			{
				System.out.println(tcID + " -- failed");
				log.info("failed");
			} else
			{
				System.out.println(tcID + " -- Passed");
				log.info("Passed");
			}
			errorFlag=0;
		}
	}

	@Then("^Sum_verify OP$")
	public void verify_OP()
	{
		if (errorFlag != 0)
		{
			System.out.println(tcID + " -- failed");
		} else
		{
			System.out.println(tcID + " -- Passed");
		}
	}

}
