  package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	protected WebDriver driver = null;
	protected WebDriverWait wait;
	private long implicitTime = 20;
	private long explicitTime = 30;
	Properties properties;

	@BeforeMethod
	public void setUp() {

		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream("src\\main\\java\\properties\\application.properties");
			properties.load(fis);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String browser = properties.getProperty("browser.name");

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

		// Move the window to the left side
		driver.manage().window().maximize();

		// Implicit wait:
		// Does not throw <No Such Element Exception> before the set time
		String implicitTimeStr = properties.getProperty("wait.time.implicit");
		long implicitTime = Long.parseLong(implicitTimeStr);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTime));

		// Create explicit wait:
		wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(properties.getProperty("wait.time.explicit"))));

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
