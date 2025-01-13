package packageone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends parameters {

	@BeforeTest
	public void MySetup() {
		ConfigrationToAccess();

	}

	@Test(priority = 1, description = "Test the defult language is English")
	public void CheckTheDefultLanguageIsEnglish() {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		Assert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
	}

	@Test(priority = 2, description = "Check THe currency Is SAR ")
	public void CheckTheDefultCurrency() {
		String ActualCurrency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, description = "Check the Mobile number")
	public void Check_The_Mobile_Number() {
		String ActualMobileNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
//		String ActualMobileNumber= driver.findElement(By.tagName("strong")).getText();
		Assert.assertEquals(ActualMobileNumber, ExpectedMobileNumber);
	}

	@Test(priority = 4, description = "Check If Qitaf Logo is Displaed")
	public void Check_If_Qitaf_Logo_is_Displaed() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		WebElement ContainerDiv = TheFooter.findElement(By.cssSelector(".sc-ghsgMZ.hIElfs"));
		WebElement QitafLogo = ContainerDiv.findElement(By.tagName("svg"));
		boolean ActualQitafLogoDisplayed = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualQitafLogoDisplayed, expectedQitafLogoDisplyed);
	}

	@Test(priority = 5, description = "Check The Hotel Tap Is Not Selected")
	public void Check_Hotel_Tap_Is_Not_Selected() {
		WebElement HotelTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValueForHotelTap = HotelTap.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualValueForHotelTap, ExpecetdValueForHotelTap);
	}

	@Test(priority = 6, description = "Check The Departure Date")
	public void Check_The_Departure_Date() {
		List<WebElement> Dates = driver.findElements(By.cssSelector(".sc-fvLVrH.hNjEjT"));
		String ActualDepartureDate = Dates.get(0).getText();

		Assert.assertEquals(ActualDepartureDate, Tommorw);
	}

	@Test(priority = 7, description = "Check The Return Date")
	public void Check_The_Return_Date() {
		List<WebElement> Dates = driver.findElements(By.cssSelector(".sc-fvLVrH.hNjEjT"));
		String ActualReturnDate = Dates.get(1).getText();

		Assert.assertEquals(ActualReturnDate, AfterTommorow);
	}

	@Test(priority = 8, description = "Change The WebSite Language Randomly")
	public void Randomly_Change_The_Languages() throws InterruptedException {
		driver.get(Websites[randomIndexForTheWebsites]);
		WebElement HotelTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTap.click();
		WebElement InputCitiyField = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

		if (driver.getCurrentUrl().contains("en")) {
			String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
			Assert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
			InputCitiyField.sendKeys(EnglishCitites[randomEnglishCitites]);
			WebElement ListofCitites = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
			ListofCitites.findElements(By.tagName("li")).get(1).click();
		} else {
			String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
			Assert.assertEquals(ActualLanguage, ExpectedArabicLanguage);
			InputCitiyField.sendKeys(ArabicCitites[randomArabicCitites]);
			WebElement ListOfCitites = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
			ListOfCitites.findElements(By.tagName("li")).get(1).click();
		}

		WebElement NumberOfVisitors = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		Select sel = new Select(NumberOfVisitors);
		int randomindex = rand.nextInt(2);
		sel.selectByIndex(randomindex);

		WebElement SearchButton = driver.findElement(By.xpath("//button[@data-testid ='HotelSearchBox__SearchButton']"));
		SearchButton.click();

		Thread.sleep(10000);
		
		WebElement Results = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));
		System.out.println(Results.getText() + "@@@@@@@@@@@@@@@");
		boolean ActualResult = Results.getText().contains("stays") || Results.getText().contains("مكان");
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

}
