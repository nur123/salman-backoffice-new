package config;

import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class env_target extends targetPropertiesFile {

    protected static WebDriver driver;
    //private final Properties tfile;
    protected String projectPath = System.getProperty("user.dir");
    protected String os = System.getProperty("os.name");

    //protected String data_env = System.getProperty("environment");
    protected String data_env = "dev";

    protected Properties tfile = readPropertiesFile(projectPath + "\\src\\test\\java\\data\\" + data_env + "-env.properties");
    // Properties prop = readPropertiesFile(projectPath + check);
}