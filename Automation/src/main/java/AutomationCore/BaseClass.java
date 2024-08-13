package AutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public WebDriver driver; // WebDriver is is an interface in Selenium that provides methods to interact with the browser.
	
	public WebDriver browserintialization(String browsername)
	{
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser name");
		}
		return driver;
		
	}
}
