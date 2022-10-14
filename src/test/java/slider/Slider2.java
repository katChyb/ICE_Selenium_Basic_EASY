package slider;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import setup.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Slider2 extends TestBase {

    @Test
    public void sliderTest() {

        driver.get("http://51.75.61.161:9102/slider.php");

        WebElement slider = driver.findElement(By.id("custom-handle"));


        for (int i = 0; i < 50; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(slider.getText()).isEqualTo("50");


        for (int i = 50; i <80; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(slider.getText()).isEqualTo("80");



        for (int i = 80; i < 80; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(slider.getText()).isEqualTo("80");



        for (int i = 80; i >20; i--) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(slider.getText()).isEqualTo("20");


        for (int i = 20; i > 0; i--) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(slider.getText()).isEqualTo("0");

    }


}


