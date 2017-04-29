package cucumberTest.testMul;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTest.testMul.*;
import utility.UtilityClass;

public class TestMulStepDefination {
	public List<TestDatamul> collTestDataMulGlobal;
	public TestDatamul testDataSum;
	  public UtilityClass utilityClass;
	  int errorFlag=0;
	
	 @Given("^test Data is$")
	  public void test_Data_is(List<TestDatamul> colltestMulData) 
	  {
	    this.collTestDataMulGlobal=colltestMulData;        
	  }

	  @When("^Multiply two numbers$")
	  public void Mul_two_numbers() 
	  {
	    for (int k=0;k<=this.collTestDataMulGlobal.size()-1;k++)
	    {
	    	System.out.println("hello -- " + collTestDataMulGlobal.get(k).getA());
	      int res= new UtilityClass().multiply(collTestDataMulGlobal.get(k).getA(), collTestDataMulGlobal.get(k).getB());
	      System.out.println(res);
	      if (collTestDataMulGlobal.get(k).getResult()!=res)
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
