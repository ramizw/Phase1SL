package PageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class Home {
	
	@FindBy(how = How.XPATH, using = "//a[text()='Amazon Pay']")
    private WebElement btnAmazonPay;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Mobile Recharge']")
    private WebElement balance;
	
	public void btnClick() {
		
		btnAmazonPay.click();
		
	}
	
	public String txtGet() {
		return balance.getText();
		
		//String S = balance.getText();
		//System.out.println(S);
	}
	
	public void db() {
		
		
		
	}
	
	
}
