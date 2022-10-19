package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setup.TestBase;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Accordion extends TestBase {

    @Test
    @Tag("Accordion")
    public void accordion() {

        driver.get("http://51.75.61.161:9102/accordion.php");



        WebElement section1hed = driver.findElement(By.id("ui-id-1"));
        section1hed.click();
        WebElement section1text = driver.findElement(By.id("ui-id-2"));
        System.out.println(section1text.getText());

        WebElement section2hed = driver.findElement(By.id("ui-id-3"));
        section2hed.click();
        WebElement section2text = driver.findElement(By.id("ui-id-4"));
        System.out.println(section2text.getText());

        WebElement section3hed = driver.findElement(By.id("ui-id-5"));
        section3hed.click();
        WebElement section3text = driver.findElement(By.id("ui-id-6"));
        System.out.println(section3text.getText());

        WebElement section4hed = driver.findElement(By.id("ui-id-7"));
        section4hed.click();
        WebElement section4text = driver.findElement(By.id("ui-id-8"));
        System.out.println(section4text.getText());



    }
}
