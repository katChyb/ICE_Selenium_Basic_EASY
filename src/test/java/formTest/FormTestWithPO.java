package formTest;
import setup.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class FormTestWithPO extends TestBase {

    @Test
    public void FillingFormWithSuccess() {

        driver.get("http://51.75.61.161:9102/form.php");

        FormPage formPage = new FormPage(driver);

        formPage.fillFirstName("Gandalf");
        formPage.fillLastName("Grey");
        formPage.fillEmail("test@o2.pl");
        formPage.selectRandomGender();
        formPage.fillAge("24");
        formPage.selectRandomExperience();
        formPage.selectAutomationTester();
        formPage.selectRandomContinent();
        formPage.selectMultiselectCommands();
        formPage.addingFileToForm();
        formPage.sendBtn();
        formPage.getValidatorMessage();
        assertThat(formPage.getValidatorMessage().equals("Form send with success"));


    }
}
