package browseractions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchBrowser {
		
public WebDriver driver=null;
	
	@SuppressWarnings("deprecation")
	public WebDriver OpenBrowser(WebDriver driver,String browsername) {
		
		switch(browsername) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			
			case "IE":
				System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				break;
			
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("marionette", true);
				driver = new FirefoxDriver(dc);
				driver.manage().window().maximize();
				break;
			
			case "Opera":
				System.setProperty("webdriver.opera.driver", ".\\driver\\operadriver.exe");
				driver = new OperaDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				break;
			
			default:
				System.out.println("Invalid Browser Name");
			
		}
		
		
		return driver;
	}
	
	
	public void implicitWait(WebDriver sysdriver, int second, TimeUnit timeunits) {
		driver = sysdriver;
		driver.manage().timeouts().implicitlyWait(second, timeunits);		
	}
	
	public void closedriver(WebDriver sysdriver) {
		driver = sysdriver;
		driver.close();
	}
}
	
	
