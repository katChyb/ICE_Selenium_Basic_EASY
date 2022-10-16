package basic;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestBase;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Windows_tabs extends TestBase {
    @Test
    @Tag("Windows_tabs")
    public void windowTabTest() {

        //https://www.selenium.dev/documentation/webdriver/interactions/windows/

        driver.get("http://51.75.61.161:9102/windows-tabs.php");

        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.id("newBrowserWindow")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(numberOfWindowsToBe(2));
        loopForNewWindow(originalWindow); ////Loop through until we find a new window handle
        wait.until(titleIs("Automation Pratice"));

       // loop for Print out 'Rank', 'Peak' and 'Mountain range' of mountains that are in "Switzerland" and are higher than 4000 m
        List<WebElement> allRows = driver.findElements(By.cssSelector("tbody tr"));
        assertThat(allRows.size()).isGreaterThan(0);


        for (WebElement row : allRows) {
            String name = row.findElements(By.cssSelector("td")).get(0).getText();
            String height = row.findElements(By.cssSelector("td")).get(3).getText();
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            String mountainRange = row.findElements(By.cssSelector("td")).get(1).getText();
            String rank = row.findElements(By.cssSelector("th")).get(0).getText();

            if ((Integer.parseInt(height) > 4000) && state.contains("Switzerland")) {
                System.out.println("Rank: " + rank + " Peak: " + name + ", Mountain range: " + mountainRange);
            }

        }

        driver.close();
        driver.switchTo().window(originalWindow);

        // Click 'New Message Window' button
        driver.findElement(By.id("newMessageWindow")).click();
        wait.until(numberOfWindowsToBe(2));
        loopForNewWindow(originalWindow);
        String textInNewWindow = String.valueOf(driver.findElement(By.cssSelector("body")).getText());
        System.out.println(textInNewWindow);
        assertThat(textInNewWindow).isEqualTo("Knowledge increases by sharing but not by saving. Please share " +
                "this website with your friends and in your organization.");

        driver.close();
        driver.switchTo().window(originalWindow);


        // Click on 'New Browser Tab' button
        driver.findElement(By.id("newBrowserTab")).click();
        wait.until(numberOfWindowsToBe(2));
        loopForNewWindow(originalWindow);
        driver.switchTo().newWindow(WindowType.TAB);  // Opens a new tab and switches to new tab
        List<WebElement> newTabAllRows = driver.findElements(By.cssSelector("tbody tr"));
        assertThat(newTabAllRows.size()).isGreaterThan(0);


        for (WebElement row : newTabAllRows) {
            String name = row.findElements(By.cssSelector("td")).get(0).getText();
            String height = row.findElements(By.cssSelector("td")).get(3).getText();
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            String mountainRange = row.findElements(By.cssSelector("td")).get(1).getText();
            String rank = row.findElements(By.cssSelector("th")).get(0).getText();

            if ((Integer.parseInt(height) > 4000) && state.contains("Switzerland")) {
                System.out.println("Rank: " + rank + " Peak: " + name + ", Mountain range: " + mountainRange);
            }

        }
        driver.close();

    }


}
