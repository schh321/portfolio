package tests;

import org.testng.annotations.Test;

public class LoanApplicationTest extends BaseTest {
	
	@Test
	public void PurchaseLoanApplication(){		
		
		try {
			super.initialize();
			currentMortgageObj=priorityObj.clickSave(testDataPriorityNum);
			homepageObj = currentMortgageObj.submit(testDataCurrMortRowNum);
			homeInfoPage2obj =homepageObj.submit(testDataHomePageRowNum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
