package Base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.slf4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class BaseClass {

    Page page;
    public static FileInputStream fis;
    public static FileInputStream dataFis;
//    public static Logger log=Logger.getLogger("TestBase");
    public static Properties prop = new Properties();
    public static Properties dataFile = new Properties();

    @BeforeSuite
    public void setUp()
    {
        try{

            fis = new FileInputStream("C:\\Users\\mkumbhar\\DemoCS\\src\\main\\java\\config\\config.prop");
            dataFis = new FileInputStream("C:\\Users\\mkumbhar\\DemoCS\\src\\main\\java\\config\\DataFile.prop");
            prop.load(fis);
            dataFile.load(dataFis);
//            Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200)
//                            .setArgs(List.of("--start-maximized")))
//                    .newContext(new Browser.NewContextOptions().setViewportSize(null))
//                    .newPage();
//            page.navigate(prop.getProperty("URL"));
            try{

//                PropertyConfigurator.configure("Log4j.properties");
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    @AfterSuite
    public void tearDown()
    {

    }

    public void launchBrowser()
    {
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200)
                        .setArgs(List.of("--start-maximized")))
                .newContext(new Browser.NewContextOptions().setViewportSize(null))
                .newPage();
        page.navigate(prop.getProperty("URL"));

    }
}
