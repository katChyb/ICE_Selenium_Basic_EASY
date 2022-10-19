package Interactions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.TestBase;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Sortable extends TestBase {

    @Test
    @Tag("Sortable")
    public void sortable() {

        driver.get("http://51.75.61.161:9102/sortable.php");

        List<WebElement> items = driver.findElements(By.cssSelector(".ui-sortable-handle"));
        assertThat((items.size()) > 0);
        System.out.println(items.size());

        Collections.shuffle(items);
        System.out.println(items.get(6).getText());



        for (int i = 0; i < items.size(); i++) {

            Actions actions = new Actions(driver);
            actions.dragAndDrop(items.get(i),items.get(i)).perform();
        }


//TODO dokonczyc

      //  Actions actions = new Actions(driver);
        //  actions.dragAndDrop(getItemWithText(4),getItem(1));


    }


//    public WebElement getItem(int i) {
//        return driver.findElement(By.xpath("//*[@id='sortable']//li[" + (i + 1) + "]"));
//    }
//
//
//    public WebElement getItemWithText(int i) {
//
//        return driver.findElement(By.xpath("//li[.='Item" + (i + 1) + "]"));
//    }


}
