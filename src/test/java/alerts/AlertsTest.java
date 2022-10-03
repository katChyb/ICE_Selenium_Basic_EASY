package alerts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormPage;
import setup.TestBase;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlertsTest extends TestBase {


 @Test
public void successfulSimpleAlertPopUp() {
 driver.get("http://51.75.61.161:9102/alerts.php");

 FormPage formPage = new FormPage(driver);

  WebElement simpleAlertBtn = driver.findElement(By.id("simple-alert"));
  simpleAlertBtn.click();
  driver.switchTo().alert().accept();

  WebElement simpleAlertLabel = driver.findElement(By.id("simple-alert-label"));
  simpleAlertLabel.getText();
  assertThat(simpleAlertLabel.getText()).isEqualTo("OK button pressed");

}

 @Test
 public void successfulPromptAlertBox() {
  driver.get("http://51.75.61.161:9102/alerts.php");

  FormPage formPage = new FormPage(driver);

  WebElement promptAlertBoxBtn = driver.findElement(By.id("prompt-alert"));
  promptAlertBoxBtn.click();
  driver.switchTo().alert().sendKeys("Katarzyna Wielka");
  driver.switchTo().alert().accept();


  WebElement promptLabel = driver.findElement(By.id("prompt-label"));
  promptLabel.getText();
  assertThat(promptLabel.getText()).isEqualTo("Hello Katarzyna Wielka! How are you today?");

 }


 @Test
 public void successfulConfirmAlert() {
  driver.get("http://51.75.61.161:9102/alerts.php");

  FormPage formPage = new FormPage(driver);

  WebElement confirmAlertBtn = driver.findElement(By.id("confirm-alert"));
  confirmAlertBtn.click();
  driver.switchTo().alert().accept();

  WebElement confirmAlertLabel = driver.findElement(By.id("confirm-label"));
  confirmAlertLabel.getText();
  assertThat(confirmAlertLabel.getText()).isEqualTo("You pressed OK!");


  confirmAlertBtn.click();
  driver.switchTo().alert().dismiss();

  confirmAlertLabel.getText();
  assertThat(confirmAlertLabel.getText()).isEqualTo("You pressed Cancel!");

 }

 @Test
 public void successfulDelayedAlertPopUp() {
  driver.get("http://51.75.61.161:9102/alerts.php");

  FormPage formPage = new FormPage(driver);

  WebElement delayedAlertBtn = driver.findElement(By.id("delayed-alert"));
  delayedAlertBtn.click();
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  wait.until(ExpectedConditions.alertIsPresent());
  driver.switchTo().alert().accept();

  WebElement delayedAlertLabel = driver.findElement(By.id("delayed-alert-label"));
  delayedAlertLabel.getText();
  assertThat(delayedAlertLabel.getText()).isEqualTo("OK button pressed");

 }


}
