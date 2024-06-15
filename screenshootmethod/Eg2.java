package screenshootmethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Eg2 {
public static void main(String[] args) throws IOException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.selenium.dev/downloads");
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir")+"//ScreenShot//"+"selinium.jpg";
	File file = new File(path);
FileHandler.copy(source, file);
	
	
	
	
	
	
	
	
}
}
