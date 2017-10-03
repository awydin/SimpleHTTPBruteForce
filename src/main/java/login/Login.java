package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


/**
 * 
 * @author paakro@hotmail.com
 *
 */
public class Login
{
    
    public static String login(String username, String password , String url ,String userFieldId , String passFieldId )
    {

        WebDriver driver = new HtmlUnitDriver();

        driver.get(url);

        WebElement userNameField = driver.findElement(By.id(userFieldId));

        userNameField.sendKeys(username);

        WebElement passwordFiled = driver.findElement(By.id(passFieldId));

        passwordFiled.sendKeys(password);


        passwordFiled.submit();

        String msg = driver.getCurrentUrl();
        driver.quit();

        
        return msg;
    }
}