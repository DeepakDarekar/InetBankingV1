package com.inetBanking.testCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetBanking.utilities.ReadConfig;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
public class BaseClass {
	//By Creating the object of ReadConfig we can access the Methods of that Class
	
	ReadConfig readconfig = new ReadConfig();
	
	//public String baseURL = "http://demo.guru99.com/V1/index.php";
	public String baseURL = readconfig.getApplicationURL();
	//public String userName = "mngr240211";
	public String userName = readconfig.getUserName();
	//public String password = "qAbybYh";
	public String password = readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		logger = Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("Log4j.properties");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver,Object object) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" +object + ".png");
        FileUtils.copyFile(source, target);	
		System.out.println("Screenshot taken");
	}
	//Genrate the random String with specified String
	
		public String randomString() {
			String genratedstring = RandomStringUtils.randomAlphabetic(5);
			return(genratedstring);
		}
		
		//Genrate Random number with specified count
		
		public String randomNumbers() {
			String genratedstring2 = RandomStringUtils.randomNumeric(4);
			return(genratedstring2);
		}
}
