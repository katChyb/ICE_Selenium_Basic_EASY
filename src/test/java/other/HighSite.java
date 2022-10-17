package other;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import setup.TestBase;

import java.io.File;
import java.io.IOException;

public class HighSite extends TestBase {

    @Test
    @Tag(" HighSite")
    public void highSite() throws IOException {

        driver.get("http://51.75.61.161:9102/high-site.php");

        WebElement scrollButton = driver.findElement(By.className("show-button"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(scrollButton).scrollByAmount(50,50).perform();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));

    }
}


