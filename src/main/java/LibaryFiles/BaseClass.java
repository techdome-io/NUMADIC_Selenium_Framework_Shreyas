package LibaryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	static public WebDriver driver;
	public ChromeOptions co;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void BrowserIntiallization( ) throws IOException
 
	{

		co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(co);
		driver.get(UtilityClass.PropertyFile("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();


	}

	@AfterClass
	public void QuitBrowser() {
		driver.quit();
	}

	public String captureScreenshotS(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
	
	public static String PropertyFile(String key) throws IOException 
	{
		FileInputStream pf=new FileInputStream("C:\\Users\\ATM\\OneDrive\\Desktop\\sparrow\\QA\\src\\test\\resources\\PropertyFiles.properties");
		Properties p=new Properties();
		p.load(pf);
		String value = p.getProperty(key);
		return value;
	}

}
