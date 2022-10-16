package formTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import setup.TestBase;

import java.io.File;
import java.util.List;
import java.util.Random;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormTest extends TestBase {


    @Test
    @Tag("Form")
    public void FillingFormWithSuccess() {

        driver.get("http://51.75.61.161:9102/form.php");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Gandalf");

        WebElement lastName = driver.findElement(By.id("inputLastName3"));
        lastName.sendKeys("Grey");

        WebElement inputEmail = driver.findElement(By.id("inputEmail3"));
        inputEmail.sendKeys("test@o2.pl");

        List<WebElement> gender = driver.findElements(By.name("gridRadiosSex"));
        assertThat(gender.size()).isNotEqualTo(0);
        getRandomElementGender(gender).click();

        WebElement inputAge = driver.findElement(By.id("inputAge3"));
        inputAge.sendKeys("1841");

        List<WebElement> experience = driver.findElements(By.name("gridRadiosExperience"));
        assertThat(experience.size()).isNotEqualTo(0);
        getRandomElementExperience(experience).click();

        WebElement profession = driver.findElement(By.id("gridCheckAutomationTester"));
        profession.click();

        //obsługa dropdowna poprzez Select
        Select continents = new Select(driver.findElement(By.id("selectContinents")));
        continents.selectByIndex((new Random().nextInt(6) + 1));

        // multiselect
        Select seleniumComands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        seleniumComands.selectByValue("switch-commands");
        seleniumComands.selectByValue("wait-commands");

        //dodawanie pliku
        WebElement addingFile = driver.findElement(By.id("chooseFile"));
        File file = new File("src/main/resources/fileForSend.txt");
        addingFile.sendKeys(file.getAbsolutePath());

        WebElement submitButton = driver.findElement(By.className("btn-primary"));
        submitButton.click();

        WebElement validatorMessage = driver.findElement(By.id("validator-message"));
        assertThat(validatorMessage.getText()).isEqualTo("Form send with success");

    }

    public WebElement getRandomElementGender(List<WebElement> gender) {
        return gender.get(new Random().nextInt(gender.size()));
    }

    public WebElement getRandomElementExperience(List<WebElement> experience) {
        return experience.get(new Random().nextInt(experience.size()));
    }


}
