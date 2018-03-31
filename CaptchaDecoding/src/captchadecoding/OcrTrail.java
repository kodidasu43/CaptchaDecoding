package captchadecoding;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import net.sourceforge.tess4j.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

//import javax.imageio.ImageIO;

//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;


public class OcrTrail {

	public static void main(String[] args) throws Exception {
System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://m.att.com/myatt");
		
		Thread.sleep(15000);
		
		//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		//WebElement logo = driver.findElement(By.id("myattLogoId"));
		
		driver.findElement(By.linkText("password")).click();
		
		//Thread.sleep(10000);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		do
		{
			
			driver.navigate().refresh();
			
			Thread.sleep(5000);
			
			driver.findElement(By.id("UserID")).sendKeys("sk3255");
			
			driver.findElement(By.id("lastName")).sendKeys("kishore");
			
			//Thread.sleep(4000);
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement captcha = driver.findElement(By.xpath("//img[@alt='Captcha']"));
		
		//Screenshot screenshot = new AShot().takeScreenshot(driver,captcha);
	     
	     //ImageIO.write(screenshot.getImage(), "PNG", new File("H:\\Selenium\\screenshots\\captcha.png"));
	     
	     //File imageFile = new File ("H:\\Selenium\\screenshots\\captcha.png");
		
        File imageFile = WebElementExtender.captureElementPicture(captcha);
        
        
     // get the Tesseract direct interace
        Tesseract instance = new Tesseract();
        instance.setDatapath("H:\\Tess4J");
        instance.setLanguage("eng");
 
        // the doOCR method of Tesseract will retrive the text
        // from image captured by Selenium
        String result = instance.doOCR(imageFile);
        
        System.out.println(result.trim());
        
        driver.findElement(By.id("captcha")).sendKeys(result.trim());
        
    	Thread.sleep(5000);
        
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
		}
		while(driver.findElements(By.id("select1a")).size() == 0);
        
       driver.findElement(By.id("select1a")).click();
       
   		Thread.sleep(10000);
      
    	driver.close();
		

	}

}
