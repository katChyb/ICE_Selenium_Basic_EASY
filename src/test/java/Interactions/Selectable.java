package Interactions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.TestBase;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Selectable extends TestBase {


    @Test
    @Tag("Selectable")
    public void selectable() {

        driver.get("http://51.75.61.161:9102/selectable.php");

        String selectResultText = driver.findElement(By.id("feedback")).getText();
        assertThat(selectResultText).isEqualTo("You've selected: none.");

        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content"));
        assertThat((items.size()) > 0);
        System.out.println(items.size());

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(items.get(0)).click(items.get(2)).click(items.get(3)).perform();
        String selectResultTextAfter = driver.findElement(By.id("feedback")).getText();
        assertThat(selectResultTextAfter).isEqualTo("You've selected: #1 #3 #4.");

    }
}
