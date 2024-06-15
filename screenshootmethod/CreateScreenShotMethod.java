package screenshootmethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.io.FileHandler;

public class CreateScreenShotMethod {
	
	public void capturScreenShot1(WebDriver driver, String filename) throws IOException {
	
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+filename+"//ScreenShot//"+"google.jpg";
		File file = new File(path);
		FileHandler.copy(source, file);
		
		
	}
		


}
