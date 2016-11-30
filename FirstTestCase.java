package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kareem\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
        //Def of two websites to navigate to and back
		String firstPageUrl = "https://uptake.com/approach/";
		String secondPageUrl = "https://uptake.com/solutions/";
		
		//Launch first Website
		driver.get(firstPageUrl);
		
		//Store source code and length
		String firstPageCode = driver.getPageSource();
		int	firstPageCodeLength = firstPageCode.length();
		
		//Wait for a few Sec
		Thread.sleep(10000);
		
		//Navigate to second website
		driver.navigate().to(secondPageUrl);
		
		//Get current url of website
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals(secondPageUrl)){
        	System.out.println("Navigation to second page OK");
        	
        	//Wait for a few Sec
    		Thread.sleep(10000);
    		
        	//Navigate Back to first page
    		driver.navigate().back();
    		
    		//Get current url and source code info
    		currentUrl = driver.getCurrentUrl();
    		String currentPageCode = driver.getPageSource();
    		int currentPageCodeLength = currentPageCode.length();
    		
    		//Verify that you are back at first page
    		if(currentUrl.equals(firstPageUrl) && currentPageCode.equals(firstPageCode) && currentPageCodeLength == firstPageCodeLength){
            	System.out.println("Navigation back to first page OK");
    		}
    		else
    		{
				System.out.println("Navigation back to first page NOT OK");
    		}
    		
        }
		else
		{
			System.out.println("Navigation to page NOT OK");

		}

		//Wait for a few Sec
		Thread.sleep(10000);
		
		// Close the driver
		driver.close();
	}

}
