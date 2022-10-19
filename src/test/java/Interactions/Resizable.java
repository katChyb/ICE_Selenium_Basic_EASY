package Interactions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class Resizable extends TestBase {

    @Test
    @Tag("Resizable")
    public void resizable() {

        driver.get("http://51.75.61.161:9102/resizable.php");

        WebElement resizable = driver.findElement(By.className("ui-icon-gripsmall-diagonal-se"));

        Point position1 = resizable.getLocation();

        Actions actions = new Actions(driver);
        actions.clickAndHold(resizable).moveByOffset(10, 0).perform();
        actions.clickAndHold(resizable).moveByOffset(0, 10).perform();
        actions.clickAndHold(resizable).moveByOffset(10, 10).perform();

        Point position2 = resizable.getLocation();
        assertThat(position1).isNotEqualTo(position2);

        System.out.println("Position1: "+ position1);
        System.out.println("Position2: "+ position2);


    }


}
