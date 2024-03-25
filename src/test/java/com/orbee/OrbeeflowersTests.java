package com.orbee;

import static org.testng.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrbeeflowersTests {

	private static WebDriver driver;
	private static Actions action;
	private static JavascriptExecutor js;

	@BeforeClass
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://orbeeflowers.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	@Test(priority=1)
	public void orbee_flowers_home_screen() throws InterruptedException {
		WebElement homepage = driver.findElement(By.xpath("//h3[text()='Same Day Delivery']"));
		String text = homepage.getText();
		assertEquals("Same Day Delivery", text);
	}

	@Test(priority = 2)
	public void user_login() throws InterruptedException {
		WebElement login = driver.findElement(By.xpath("//span[text()='  My Account  ']"));
		action.moveToElement(login).perform();
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("anilsouth65@gmail.com");
		driver.findElement(By.id("password")).sendKeys("anilsouth65@gmail.com");
		WebElement create = driver.findElement(By.xpath("//a[@class='web_clr']"));
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,350)", create);
		driver.findElement(By.xpath("//button[@id='submitButton']")).click();
		Thread.sleep(3000);		
		WebElement loginHeader = driver
				.findElement(By.xpath("/html/body/header/div/div/div/div[2]/nav/ul/li[6]/a/span"));
		assertEquals("Anil", loginHeader.getText().split(",")[1]);
	}

	@Test(priority = 3)
	public void add_fresh_miss_to_add_card() throws InterruptedException {
		Thread.sleep(5000);
		WebElement freshmiss = driver
				.findElement(By.xpath("(//a[@href='https://orbeeflowers.com/fresh-miss/small'])[2]"));
		js.executeScript("window.scrollBy(0,750)", freshmiss);
		Thread.sleep(3000);
		freshmiss.click();
		WebElement addtocart = driver.findElement(By.xpath("(//a[@id='addtocartshow1'])[1]"));
		js.executeScript("window.scrollBy(0,500)", addtocart);
		Thread.sleep(5000);
		addtocart.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='View Product']")).click();
		driver.getWindowHandle();
		Set<String> mulipulwindow = driver.getWindowHandles();
		List<String> l = new LinkedList<String>();
		l.addAll(mulipulwindow);
		driver.switchTo().window(l.get(1));
		Thread.sleep(5000);
		WebElement addtocart2 = driver.findElement(By.xpath("(//a[@id='addtocartshow5'])[1]"));
		js.executeScript("window.scrollBy(0,500)", addtocart2);
		Thread.sleep(5000);
		addtocart2.click();
		driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		WebElement cart = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']"));
		action.moveToElement(cart).perform();
		WebElement price = driver.findElement(By.xpath("//h5[text()='QR425']"));
		String text = price.getText();
		assertEquals("QR425", text);
	}

	@Test(priority = 4)
	public void remove_fresh_miss_product_from_add_card_() throws InterruptedException {
		WebElement cart = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']"));
		action.moveToElement(cart).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='fa fa-trash'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='fa fa-trash'])[1]")).click();
		Thread.sleep(5000);
		String text = cart.getText();
		assertEquals("", text);

	}

	@Test(priority = 5)
	public void search_fresh_miss_product() throws InterruptedException {
		driver.findElement(By.xpath("(//i[@class='fa fa-search'])[1]")).click();
		WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
		search.click();
		search.sendKeys("Fresh Miss");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='Fresh Miss'])[1]")).click();
		driver.getWindowHandle();
		Set<String> mulipulwindow2 = driver.getWindowHandles();
		List<String> l = new LinkedList<String>();
		l.addAll(mulipulwindow2);
		driver.switchTo().window(l.get(2));
		Thread.sleep(5000);
		WebElement freshmiss = driver.findElement(By.xpath("//h2[@class='product-title']"));
		String title = freshmiss.getText();
		assertEquals("Fresh Miss", title);
		WebElement fremissPrice = driver.findElement(By.xpath("(//span[@class='regular-price'])[1]"));
		String price = fremissPrice.getText();
		assertEquals("QR 255", price);
	}

	@Test(priority = 6)
	private void add_card_flowers_anthurium() throws InterruptedException {
		Thread.sleep(3000);
		WebElement flowers = driver.findElement(By.xpath("(//a[@href='#'])[1]"));
		action.moveToElement(flowers).perform();
		WebElement typesofflowers = driver
				.findElement(By.xpath("(//a[@href='https://orbeeflowers.com/shop_products/types-of-flowers'])[1]"));
		action.moveToElement(typesofflowers).perform();
		WebElement Anthurium = driver
				.findElement(By.xpath("(//a[@href='https://orbeeflowers.com/shop_products/anthurium'])[1]"));
		Anthurium.click();
		WebElement yourpetal = driver
				.findElement(By.xpath("(//a[@href='https://orbeeflowers.com/yourpetal/small'])[3]"));
		js.executeScript("window.scrollBy(0,370)", yourpetal);
		Thread.sleep(5000);
		yourpetal.click();
		WebElement addtocart = driver.findElement(By.xpath("(//a[@id='addtocartshow45'])[1]"));
		js.executeScript("window.scrollBy(0,500)", addtocart);
		Thread.sleep(5000);
		addtocart.click();
		WebElement ok = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
		ok.click();
		WebElement cart = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']"));
		action.moveToElement(cart).perform();
		WebElement yourpetal1 = driver.findElement(By.xpath("//h2[@class='product-title']"));
		String yourpetalTitle = yourpetal1.getText();
		assertEquals("Yourpetal", yourpetalTitle);
	}

	@Test(priority = 7)
	private void add_cart_plants_indoor_common_aglaonema() throws InterruptedException {
		WebElement plants = driver.findElement(By.xpath("(//a[@href='#'])[2]"));
		action.moveToElement(plants).perform();
		WebElement indoorplants = driver
				.findElement(By.xpath("(//a[@href='https://orbeeflowers.com/shop_products/indoor-plants'])[1]"));
		action.moveToElement(indoorplants).perform();
		WebElement commonplants = driver
				.findElement(By.xpath("(//a[@href='https://orbeeflowers.com/shop_products/common-plants'])[1]"));
		commonplants.click();
		WebElement calathea = driver.findElement(By.xpath(
				"(//a[@href='https://orbeeflowers.com/calathea-sanderiana-ornata/calathea-sanderiana-ornata'])[3]"));
		js.executeScript("window.scrollBy(0,370)", calathea);
		Thread.sleep(5000);
		calathea.click();
		WebElement addtocart = driver.findElement(By.xpath("(//a[@id='addtocartshow62'])[1]"));
		js.executeScript("window.scrollBy(0,500)", addtocart);
		Thread.sleep(5000);
		addtocart.click();
		WebElement ok = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
		ok.click();
		WebElement cart = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']"));
		action.moveToElement(cart).perform();
		WebElement calatheadProduct = driver.findElement(By.xpath("//h2[@class='product-title']"));
		String calatheaTitle = calatheadProduct.getText();
		assertEquals("Calathea Sanderiana Ornata", calatheaTitle);
	}

	@Test(priority = 8)
	private void logout_screen() throws InterruptedException {
		WebElement userLogout = driver.findElement(By.xpath("(//span[@class='menu-text'])[3]"));
		action.moveToElement(userLogout).perform();
		WebElement logout = driver.findElement(By.xpath("(//a[@href='https://orbeeflowers.com/logout'])[1]"));
		logout.click();
		Thread.sleep(3000);
		WebElement homepage = driver.findElement(By.xpath("//h3[text()='Same Day Delivery']"));
		String text = homepage.getText();
		assertEquals("Same Day Delivery", text);
	}

	@AfterClass
	private void afterTests() {		
		//driver.quit();
	}
}