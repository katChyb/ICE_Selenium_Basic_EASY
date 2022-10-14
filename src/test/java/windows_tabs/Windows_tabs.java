package windows_tabs;

import setup.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Windows_tabs extends TestBase {

public void windowTabTest(){
    driver.get("http://51.75.61.161:9102/windows-tabs.php");

    String originalWindow = driver.getWindowHandle();
    assertThat(originalWindow).isEqualTo(1);


}
}
