package sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSeleniumWaits {

	protected WebDriver driver = null;
	protected WebDriverWait wait;
	private long implicitTime = 20;
	private Duration explicitTime;

	@BeforeMethod
	public void setUp() {

		String browser = "chrome";

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\webdriver\\geckodriver-v0.33.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();

		}
		wait = new WebDriverWait(driver, explicitTime);
		wait = new WebDriverWait(driver, explicitTime);



		// Move the window to the left side
		driver.manage().window().maximize();

		// Implicit wait:
		// Does not throw <No Such Element Exception> before the set time
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTime));

		// Create explicit wait:
		// wait = new WebDriverWait(driver, Duration.ofSeconds(explicitTime));

	}

	// @Test
	public void alertDelay() {

		// Create explicit wait:

		driver.get("file:///C:/Users/itune/Downloads/Telegram%20Desktop/waits.html");

		// 1. Delay alert
		driver.findElement(By.id("alert")).click();
		// I need wait here:
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	// @Test
	public void textMsg() {

		driver.get("file:///C:/Users/itune/Downloads/Telegram%20Desktop/waits.html");
		driver.findElement(By.id("populate-text")).click();

		// Wait here:
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("h2")), "Selenium Webdriver"));
		String text = driver.findElement(By.id("h2")).getText();

		Assert.assertEquals(text, "Selenium Webdriver");

	}

	// @Test
	public void hiddenButton() {
		driver.get("file:///C:/Users/itune/Downloads/Telegram%20Desktop/waits.html");
		driver.findElement(By.id("display-other-button")).click();

		// Wait here:
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
		driver.findElement(By.id("hidden")).click();
	}

	// @Test
	public void enableButton() {
		driver.get("file:///C:/Users/itune/Downloads/Telegram%20Desktop/waits.html");
		driver.findElement(By.id("enable-button")).click();

		// Wair here:
		wait.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
		driver.findElement(By.id("disable")).click();
	}

	//@Test
	public void checkboxButton() {
		driver.get("file:///C:/Users/itune/Downloads/Telegram%20Desktop/waits.html");
		driver.findElement(By.id("checkbox")).click();

		// Wait here:
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ch"))));
		boolean isCheckboxClicked = driver.findElement(By.id("ch")).isSelected();
		WebElement checkBox = driver.findElement(By.id("ch"));
		checkBox.click();
		Assert.assertFalse(isCheckboxClicked, "Check box is unchecked");

	}

	// @Test
	public void elementIsSelected() {
		driver.get("file:///C:/Users/itune/Downloads/Telegram%20Desktop/waits.html");
		driver.findElement(By.id("checkbox")).click();

		// Wait until button becomes enabled:
		// Create explicit wait:

		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ch"))));
		wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
		Assert.assertTrue(driver.findElement(By.id("ch")).isSelected());
//			boolean isCheckboxClicked = driver.findElement(By.id("ch")).isSelected();
//			WebElement checkBox = driver.findElement(By.id("ch"));
//			checkBox.click();
//			Assert.assertFalse(isCheckboxClicked, "Check box is unchecked");

	}

}
