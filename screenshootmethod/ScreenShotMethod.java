package screenshootmethod;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotMethod {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.navigate().refresh();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		 String path = System.getProperty("user.dir")+"//ScreenShot//"+"amazone.jpg";
		 File file = new File(path);
		 org.openqa.selenium.io.FileHandler.copy(source, file);
		 
		 
				 
		
		
	}

}
