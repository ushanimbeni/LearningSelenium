package cucumberTest.testSum;

import java.util.List;

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
  public int errorFlag=0;
  
  public TestSumStepDefinationFile()
  {
    this.testDataSum = new TestSumData();
    this.utilityClass = new UtilityClass();
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

  @Given("^test Data is$")
  public void test_Data_is(List<TestSumData> colltestSumData) 
  {
    this.collTestDataSumGlobal=colltestSumData;        
  }

  @When("^add two numbers$")
  public void add_two_numbers() 
  {
    for (int k=0;k<=this.collTestDataSumGlobal.size()-1;k++)
    {
      int res= utilityClass.sum(collTestDataSumGlobal.get(k).getA(), collTestDataSumGlobal.get(k).getB());
      System.out.println(res);
      if (collTestDataSumGlobal.get(k).getResult()!=res)
      {
        errorFlag=errorFlag+1;        
      }
    }
  }

  @Then("^verify OP$")
  public void verify_OP() 
  {
    if (errorFlag!=0)
    {
      System.out.println("test Case failed");
    }
    else
    {
      System.out.println("Test Case Passed");
    }
  }


}
