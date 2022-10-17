package Interactions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class Draggable extends TestBase {
    @Test
    @Tag("Draggable")
    public void draggable() {

        driver.get("http://51.75.61.161:9102/draggable.php");

        WebElement draggable = driver.findElement(By.id("draggable"));
        Point position1 = draggable.getLocation();


        Actions actions = new Actions(driver);

// https://sqa.stackexchange.com/questions/30583/how-to-get-the-page-size-content-rendered-in-selenium-webdriver

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        int contentHeight = (((Number) js.executeScript("return window.innerHeight")).intValue());
//        int contentWidth = (((Number) js.executeScript("return window.innerWidth")).intValue());

        actions.clickAndHold(draggable).moveByOffset(841, -44).perform();
        actions.clickAndHold(draggable).moveByOffset(0, 293).perform();

        Point position2 = draggable.getLocation();
        assertThat(position1).isNotEqualTo(position2);

        actions.clickAndHold(draggable).moveByOffset(-800, 0).perform();

        Point position3 = draggable.getLocation();

        actions.clickAndHold(draggable).moveByOffset(0, -300).perform();

        Point position4 = draggable.getLocation();

        assertThat(position3).isNotEqualTo(position4);


    }
}
