package slider;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import setup.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Slider extends TestBase {

    @Test
    public void sliderTest() {

        driver.get("http://51.75.61.161:9102/slider.php");

        WebElement slider = driver.findElement(By.id("custom-handle"));

        int step=  50- getStartingPoint(slider);
        for (int i = 0; i < step; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(slider.getText()).isEqualTo("50");

        int step2=  80- getStartingPoint(slider);
        for (int i = 0; i <step2; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(slider.getText()).isEqualTo("80");


        int step3=  80- getStartingPoint(slider);
        for (int i = 0; i < step3; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(slider.getText()).isEqualTo("80");

        int step4= getStartingPoint(slider)-20;
        System.out.println(step4);
        for (int i = 0; i <step4; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(slider.getText()).isEqualTo("20");


        int step5= getStartingPoint(slider)+80;
        System.out.println("step 5 "+step5);
        for (int i = 0; i < step5; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(slider.getText()).isEqualTo("0");

    }


    public int getStartingPoint(WebElement slider) {

        int startPoint = Integer.parseInt(slider.getText());
        return startPoint;

    }
}


