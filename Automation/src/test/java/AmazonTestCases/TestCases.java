package AmazonTestCases;
import org.testng.annotations.Test;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import AutomationCore.BaseClass;

public class TestCases extends BaseClass{

	WebDriver driver;
	@BeforeMethod// telling compiler which method is going to run - annotaions
	public void initialization()
	{
		driver = browserintialization("Chrome");// open browser
		//driver.get("https://www.amazon.in"); //getting link - for amazon
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
		//driver.get("https://form.immigration.ca/skilled-worker/");
	//	driver.get("https://www.immigration.ca/");
		driver.manage().window().maximize(); // to maximize the page
		
	}
	
	@Test
	public void TC01()
	{
		System.out.println("Test Case 1");
		driver.findElement(By.name("field-keywords")).sendKeys("iPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String brandname = driver.findElement(By.xpath("//span[text()='Apple']")).getText(); //getText()
		String brandtagname = driver.findElement(By.xpath("//span[text()='Apple']")).getTagName();//getTagname()
		String brandclassname = driver.findElement(By.xpath("//span[text()='Apple']")).getAttribute("class");
		
		WebElement dropdown = driver.findElement(By.id("s-result-sort-select"));
		Select drop = new Select(dropdown);
		drop.selectByValue("review-rank");
		drop.selectByVisibleText("Price: Low to High");
		drop.selectByIndex(4);
		//driver.findElement(By.id("nav-search-submit-button")).submit(); alternate method for click();
	
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int prodcount = products.size();
		System.out.println(prodcount);
		System.out.println(brandname);
		System.out.println(brandtagname);
		System.out.println(brandclassname);
		
//		driver.navigate().back();
//		driver.navigate().forward();
//		driver.navigate().refresh();
//		driver.navigate().to("https://www.flipkart.com/");
//		driver.close();
		
		

	}
	
	@Test
	public void TC02()
	{
		System.out.println("Test Case 2");
		
		//1.Locating free evaluation
		driver.findElement(By.xpath("//span[text()='Free Evaluation']")).click();	//Locating free evaluation
		
		//2.Locating name ID locator
		//driver.findElement(By.id("name")).sendKeys("Ramya").sendKeys("Ramya");
		//driver.findElement(By.xpath("//div[@id='collapse-1']//descendant::input[@id='name']"));
		driver.findElement(By.xpath("//label[text()='Name: *']//following-sibling::input"));
		
		
		//3.Locating email through  xpath
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ramyaknair@gmail.com");
		
		//4.Locating phone through xpath(id and class)
		driver.findElement(By.xpath("//input[@id='phone' and @class='form-control']")).sendKeys("9074265715");
		
		//5.Locate the dropdown(select) element for Counrty of citizenship
		WebElement dropdown1 = driver.findElement(By.id("nationality"));
		//5.1.Creating a select object
		Select drop1 = new Select(dropdown1);
		//5.2.Using selectbyvisibletext
		drop1.selectByVisibleText("Andorra");
		
		
		//6.Locate the dropdown(select) element for Counrty of residence
		WebElement dropdown2 = driver.findElement(By.id("residence_country"));
		//6.1.Creating a select object
		Select drop2 = new Select(dropdown2);
		//6.2.Using selectbyvalue
		drop2.selectByValue("Brazil");
		
		//7.Locate the dropdown(select) element for age
		WebElement dropdown3 = driver.findElement(By.id("age"));
		//7.1.Creating a select object
		Select drop3 = new Select(dropdown3);
		//7.2.Using selectbyindex
		drop3.selectByIndex(27);
		
		//8.Locate the dropdown(select) element for sex
		WebElement dropdown4 = driver.findElement(By.id("sex"));
		//8.1.Creating a select object
		Select drop4 = new Select(dropdown4);
		//8.2.Using selectbyvalue
		drop4.selectByValue("Female");
		
	}
		@Test
		public void TC03() throws InterruptedException
		{
			driver.get("https://www.redbus.in/");
			driver.findElement(By.id("src")).sendKeys("Kochi");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//i[@class='icon icon-ic-city solr-icon'])[1]")).click();
			
			driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
			WebElement source = driver.findElement(By.id("column-a"));
			WebElement destination = driver.findElement(By.id("column-b"));
			//Creating object for action class(inbuilt class)
			Actions action = new Actions(driver); //in order to access the methods of action we use action class object)
			action.dragAndDrop(source, destination);
			action.contextClick();// to perform right click
			//action.contextClick(destination); to click on particular button through xpath
			driver.navigate().back();
			Thread.sleep(2000);
			//action.doubleClick(driver.findElement(By.id("search_button"))); - to double click 
			action.moveToElement(driver.findElement(By.xpath("//span[text()='Train Tickets']"))); //mouse hover
			
			driver.findElement(By.id("src")).sendKeys("Kochi");
			Thread.sleep(2000);
			action.sendKeys(Keys.ARROW_DOWN);
			action.sendKeys(Keys.ENTER);
			action.build().perform(); //manadatory always required while action object
			
		}
		
		@Test
		public void TC04()
		{
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptop");
			driver.findElement(By.id("nav-search-submit-button")).click();
			driver.findElement(By.xpath("(//input[@type='checkbox']//following-sibling::i)[1]")).click();
			driver.findElement(By.xpath("(//input[@type='checkbox']//following-sibling::i)[7]")).click();
			
			driver.navigate().to("https://form.immigration.ca/skilled-worker/");
			driver.findElement(By.xpath("(//label[text()='Yes'])[1]")).click();			
		}
		
		@Test
		public void TC05() throws InterruptedException
		{
			//driver.navigate().to("https://www.ironspider.ca/forms/checkradio.htm");
			driver.findElement(By.xpath("//input[@type=\"checkbox\" and @value='red']")).click();
			driver.findElement(By.xpath("//input[@type=\"checkbox\" and @value='purple']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type=\"checkbox\" and @value='red']")).click();
			driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();	
			
			driver.navigate().to("https://designsystem.digital.gov/components/radio-buttons/");
			driver.findElement(By.xpath("(//label[text()='Sojourner Truth'])[1]")).click();
		}
		
		
		
		
		
		
		
	
	
	
	
	
	}
	
