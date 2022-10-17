package Interactions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestBase;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Droppable extends TestBase {

    @Test
    @Tag("Droppable")
    public void droppable() {

        driver.get("http://51.75.61.161:9102/droppable.php");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(drag, drop).perform();

        assertThat(drop.getText()).isEqualTo("Dropped!");

    }
}
