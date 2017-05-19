package cucumberTest.testMul;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utility.UtilityClass;

public class TestMulStepDefinationFile {
	public TestMulData testDataSum;
	public UtilityClass utilityClass;
	public List<TestMulData> collTestDataSumGlobal;
	public int errorFlag = 0;
	public String tcID = "";
	private static Logger log;

	public TestMulStepDefinationFile() throws FileNotFoundException, IOException {
		this.testDataSum = new TestMulData();
		this.utilityClass = new UtilityClass();
		Properties props = new Properties();
		System.out.println("hello Mul constructor");
		String log4jFile = System.getProperty("user.dir") + "/log4j.properties";
		props.load(new FileInputStream(log4jFile));
		PropertyConfigurator.configure(props);
		log = Logger.getLogger(TestMulStepDefinationFile.class);

	}

	@Given("^Mul_test Data is$")
	public void test_Data_is(List<TestMulData> colltestSumData) {
		this.collTestDataSumGlobal = colltestSumData;
	}

	@When("^Mul_two numbers$")
	public void mul_two_numbers() throws IOException {
		// utilityClass.launchBrowser(utilityClass.getPropertyValue("urlGoogle"));
		log.info("Opened Google");

		for (int k = 0; k <= this.collTestDataSumGlobal.size() - 1; k++) {
			tcID = this.collTestDataSumGlobal.get(k).gettC();
			int res = utilityClass.multiply(collTestDataSumGlobal.get(k).getA(), collTestDataSumGlobal.get(k).getB());
			if (collTestDataSumGlobal.get(k).getResult() != res) {
				errorFlag = errorFlag + 1;
			}
			if (errorFlag != 0) {
				log.info("Failed");
			} else {
				log.info("Passed");
			}
			errorFlag = 0;
		}
	}

}
