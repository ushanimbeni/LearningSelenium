package runner;

import org.junit.runner.JUnitCore;

import cucumberTest.testMul.TestMulExecution;
import cucumberTest.testSum.TestSumExecution;

public class TestMain
{
	public static void main(String[] args)
	{
		JUnitCore jUnitCore = new JUnitCore();

		jUnitCore.run(TestSumExecution.class);
		jUnitCore.run(TestMulExecution.class);

	}

}
