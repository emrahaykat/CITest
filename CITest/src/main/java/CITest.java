import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CITest extends Base{

    @Test
    public void CITest1() throws InterruptedException {

        getDriver().navigate().to("https://www.google.com/");
        String data="selenium";

        getDriver().findElement(By.name("q")).sendKeys(data);
        getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        String link=getDriver().findElement(By.xpath("(//div[@class=\"r\"]//a)[1]")).getText();
        System.out.println("Link is "+link);
        Assert.assertEquals("Selenium\n" + "www.selenium.dev",link);

    }
}
