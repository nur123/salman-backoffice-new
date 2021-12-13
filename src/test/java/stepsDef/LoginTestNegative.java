package stepsDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTestNegative extends env_target {

    protected String url = tfile.getProperty("url");
    protected String username = tfile.getProperty("username_fail1");
    protected String password = tfile.getProperty("password_fail1");


    @Given("^user is not on homepage$")
    public void user_is_not_on_homepage() throws Throwable{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable--notifications");
        System.setProperty("webdriver.chrome.driver",
                projectPath+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
    }

    @When("^user not navigates to Login Page$")
    public void user_not_navigates_to_Login_Page() throws Throwable {
        Thread.sleep(1000);
    }

    @When("^user enters wrong username and Password$")
    public void user_enters_wrong_username_and_Password() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='border rounded w-full py-2 bg-alami-green text-white shadow']")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\login.homepage.png"));
    }

    @Then("^not success message is displayed$")
    public void not_success_message_is_displayed() throws Throwable{
        Thread.sleep(3000);
        File srcFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2, new File(projectPath+ "\\src\\test\\java\\screenshots\\loginfail.png"));
        driver.quit();
    }
}