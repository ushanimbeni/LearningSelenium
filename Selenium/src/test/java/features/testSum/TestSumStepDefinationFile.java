package features.testSum;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.UtilityClass;

class TestSumStepDefinationFile
{
  private  TestSumData testDataSum;
  private UtilityClass utilityClass;
  
   public TestSumStepDefinationFile()
  {
    this.testDataSum = new TestSumData();
    this.utilityClass=new UtilityClass();
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


}
