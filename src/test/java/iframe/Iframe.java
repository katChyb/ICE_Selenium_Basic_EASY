package iframe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import setup.TestBase;

import java.util.Random;

public class Iframe extends TestBase {

    @Test
    public void IframeSuccessfulFillingForm(){

        driver.get("http://automation-practice.emilos.pl/iframes.php");

        WebElement iframe1 = driver.findElement(By.name("iframe1"));
        driver.switchTo().frame("iframe1");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Gandalf");

        WebElement surname = driver.findElement(By.id("inputSurname3"));
        surname.sendKeys("Grey");

        WebElement submitButton = driver.findElement(By.className("btn-primary"));
        submitButton.click();

        driver.switchTo().defaultContent();

        WebElement iframe2 = driver.findElement(By.name("iframe2"));
        driver.switchTo().frame("iframe2");

        WebElement inputLogin = driver.findElement(By.id("inputLogin"));
        inputLogin.sendKeys("Maaya");

        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("Password");

        Select continents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        continents.selectByIndex((new Random().nextInt(6) + 1));

        WebElement inputYearOfExperience = driver.findElement(By.id("gridRadios2"));
        inputYearOfExperience.click();

        WebElement submitButton2 = driver.findElement(By.className("btn-primary"));
        submitButton2.click();

        driver.switchTo().defaultContent();

        WebElement BasicMenu = driver.findElement(By.linkText("Basic"));
        BasicMenu.click();


    }
}
