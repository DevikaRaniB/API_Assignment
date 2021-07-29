package stepdefs;



import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import com.nielsen.cucumbertestngframework.TestExecutor;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaseStepDefs {

	TestExecutor testExecutor = null;
	List<Object> oldResponse=new ArrayList<Object>();
	List<Object> newResponse=new ArrayList<Object>();

	@Before
	public void beforeScenario(Scenario scenario) {
		testExecutor = new TestExecutor();
		
}

	@After
	public void afterScenario(Scenario scenario) {
	
		
	}


	
	@When("^I request for the OLD list of result through GET request \"(.*)\"$")
	public void irequestfortheOldlistofresultthroughGETrequest(String apiDetails) {
		System.out.println(apiDetails);
		try {
			oldResponse=testExecutor.requestTheAPIGetCall(apiDetails);
			Assert.assertTrue(testExecutor.requestTheAPIGetCall(apiDetails).size()>1,"Responce Received for old API");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@And("^I request for the NEW list of result through GET request \"(.*)\"$")
	public void irequestfortheNewlistofresultthroughGETrequest(String apiDetails) {
		System.out.println(apiDetails);
		try {
			newResponse=testExecutor.requestTheAPIGetCall(apiDetails);
			Assert.assertTrue(testExecutor.requestTheAPIGetCall(apiDetails).size()>1,"Responce Received for new API");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Then("^I Validate the match in the response of both Response$")
	public void iValidatethematchintheresponseofboth() {
		System.out.println("validate response from new API " + newResponse + "and old API" +oldResponse+" must be equal");
		Assert.assertTrue(testExecutor.validateResponse(oldResponse,newResponse));

	}

	
	

}
