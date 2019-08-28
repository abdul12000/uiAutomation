package stepDef;

import base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }



    @Before
    public void setup() {
        String chromedriverLocation = "src/main/resources/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriverLocation);
        base.driver = new ChromeDriver();
    }

    @After
    public void cleanup() throws Exception {
        takeScreenshot();
        Thread.sleep(3000);
        base.driver.quit();

    }

    private void takeScreenshot() throws Exception{
        File srcFile = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:/AutomationProjects/TestResults/"+System.currentTimeMillis()+".png"));

    }

}
