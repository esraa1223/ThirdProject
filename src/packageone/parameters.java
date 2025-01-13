package packageone;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	WebDriver driver=new ChromeDriver();
	Random rand=new Random();
	String DefaultURL="https://www.almosafer.com/en";
	String ExpectedEnglishLanguage="en";
	String ExpectedArabicLanguage="ar";
	String ExpectedCurrency="SAR";
	String ExpectedMobileNumber="+966554400000";
	boolean expectedQitafLogoDisplyed=true;
	String ExpecetdValueForHotelTap="false";
	LocalDate date= LocalDate.now();
	int Today=date.getDayOfMonth();
	String Tommorw=Integer.toString(date.plusDays(1).getDayOfMonth());
	String AfterTommorow=Integer.toString(date.plusDays(2).getDayOfMonth());
	String[] Websites= {"https://www.almosafer.com/en" ,"https://www.almosafer.com/ar"};
	int randomIndexForTheWebsites=rand.nextInt(Websites.length);
	String[] EnglishCitites= {"Dubi","Jeddah","Riyadh"};
	int randomEnglishCitites=rand.nextInt(EnglishCitites.length);
	String[] ArabicCitites= {"جدة" ,"دبي"};
	int randomArabicCitites= rand.nextInt(ArabicCitites.length);
	boolean ExpectedResult=true;
	
	
	public void ConfigrationToAccess() {
		driver.get(DefaultURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement selectSARButton=driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		selectSARButton.click();
	}

}
