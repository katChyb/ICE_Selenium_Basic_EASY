package other;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HighSite extends TestBase {

    @Test
    @Tag(" HighSite")
    public void highSite() throws IOException {

        driver.get("http://51.75.61.161:9102/high-site.php");

        WebElement scrollButton = driver.findElement(By.className("show-button"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(scrollButton).scrollByAmount(0,200).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(scrollButton));

        //https://www.selenium.dev/documentation/webdriver/interactions/windows/
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));

    }
}


