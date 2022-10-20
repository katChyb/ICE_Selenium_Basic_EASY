package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestBase;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ModalDialog extends TestBase {
    @Test
    @Tag("Modal dialog")
    public void modalDialog() {

        driver.get("http://51.75.61.161:9102/modal-dialog.php");

        WebElement createUserBtn = driver.findElement(By.id("create-user"));
        createUserBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ui-dialog"))));

        WebElement inputName = driver.findElement(By.id("name"));
        inputName.clear();
        inputName.sendKeys("Gandalf Grey");

        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.clear();
        inputEmail.sendKeys("test@o2.pl");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("testtest");

        WebElement createAccountBtn = driver.findElement(By.cssSelector(".ui-dialog-buttonset"));
        createAccountBtn.click();

        List<WebElement> allRows = driver.findElements(By.cssSelector("tbody tr"));
        assertThat(allRows.size()).isGreaterThan(0);


        for (WebElement row : allRows) {
            String name = row.findElements(By.cssSelector("td")).get(0).getText();
            String email = row.findElements(By.cssSelector("td")).get(1).getText();
            String password = row.findElements(By.cssSelector("td")).get(2).getText();
            System.out.println(name + " " + email + " " + password);
        }

        assertThat(allRows.get(1).getText()).isEqualTo("Gandalf Grey test@o2.pl testtest");

    }



    @Tag("Modal dialog with provider")
    @ParameterizedTest (name = "{0} test with provided data")
    @MethodSource("setup.DataProvider#inputData")
    public void modalDialogWithDataprovider(String nameData, String emailData, String passwordData) {


        driver.get("http://51.75.61.161:9102/modal-dialog.php");

        WebElement createUserBtn = driver.findElement(By.id("create-user"));
        createUserBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ui-dialog"))));

        WebElement inputName = driver.findElement(By.id("name"));
        inputName.clear();
        inputName.sendKeys(nameData);


        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.clear();
        inputEmail.sendKeys(emailData);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys(passwordData);

        WebElement createAccountBtn = driver.findElement(By.cssSelector(".ui-dialog-buttonset"));
        createAccountBtn.click();

        List<WebElement> allRows = driver.findElements(By.cssSelector("tbody tr"));
        assertThat(allRows.size()).isGreaterThan(0);


        for (WebElement row : allRows) {
            String name = row.findElements(By.cssSelector("td")).get(0).getText();
            String email = row.findElements(By.cssSelector("td")).get(1).getText();
            String password = row.findElements(By.cssSelector("td")).get(2).getText();
            System.out.println(name + " " + email + " " + password);
        }

        assertThat(allRows.get(1).getText()).isEqualTo(nameData +" "+ emailData + " " + passwordData);

    }

}


