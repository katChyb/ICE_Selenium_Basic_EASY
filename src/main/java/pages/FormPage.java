package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;

    @FindBy(id = "inputEmail3")
    private WebElement inputEmail;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> gender;

    @FindBy(id = "inputAge3")
    private WebElement inputAge;


    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experience;

    @FindBy(id = "gridCheckAutomationTester")
    private WebElement inputAutomationTester;

    @FindBy(id = "selectContinents")
    private WebElement continents;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement multiselectCommands;


    @FindBy(id = "chooseFile")
    private WebElement addingFile;

    @FindBy(className = "btn-primary")
    private WebElement submitButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;


    public void fillFirstName(String name) {
        firstNameInput.sendKeys(name);
    }

    public void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void selectRandomGender() {
        gender.get(new Random().nextInt(gender.size())).click();
    }

    public void fillAge(String age) {
        inputAge.sendKeys(age);
    }

    public void selectRandomExperience() {
        experience.get(new Random().nextInt(experience.size())).click();
    }

    public void selectAutomationTester() {
        inputAutomationTester.click();
    }

    public void selectRandomContinent() {
       Select selectContinents = new Select(continents);
       selectContinents.selectByIndex(new Random().nextInt(6) + 1);

    }

    public void selectMultiselectCommands() {
        Select selectMultiselectCommands = new Select(multiselectCommands);
        selectMultiselectCommands.selectByValue("switch-commands");
        selectMultiselectCommands.selectByValue("wait-commands");
    }

    public void addingFileToForm(){
        File file = new File("src/main/resources/fileForSend.txt");
        addingFile.sendKeys(file.getAbsolutePath());
    }

    public String getValidatorMessage() {
        return validatorMessage.getText();
    }

    public void sendBtn(){
        submitButton.click();
    }
}
