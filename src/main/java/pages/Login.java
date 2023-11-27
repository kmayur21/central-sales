package pages;

import Base.BaseClass;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import commonMethod.CommonMethods;

public class Login  extends BaseClass{
    Page page;

    private String usernamefield = "//input[@id='username']";
    private String passwordfield = "//input[@id='password']";
    private String loginButton = "//*[@value='Log In']";
    private String lightningURL = "https://r10packageorg.lightning.force.com/lightning/page/home";
    private String getLightningURLOneApp = "lightning.force.com/one/one.app";
    private String userIcon= ".profileTrigger";
    private String userProfileLinkLabel= ".profile-link-label";
    private String locatorPosition = "nth=4";
    private String lightningText = "Switch to Lightning Experience";

    CommonMethods commonMethods;

    public Login(Page page) {
        this.page = page;
        commonMethods = new CommonMethods(page);
    }

    public void loginWithStandardUserAndNavigateToClassic(String username, String password) {
        page.locator(usernamefield).fill(username);
//        commonMethods.enterText(usernamefield,username);
        commonMethods.enterText(passwordfield,password);
//        page.locator(passwordfield).fill(password);
        commonMethods.click(loginButton);
//        page.locator(loginButton).click();
        commonMethods.waitForPageToLoad();
        //page.waitForLoadState();
        if (page.url().contains(lightningURL)) {
            commonMethods.click(userIcon);
//            page.locator(userIcon).click();
            commonMethods.waitForPageToLoad();
            commonMethods.clickOnLocatorPosition(userProfileLinkLabel,locatorPosition);
//            page.locator(userProfileLinkLabel).locator(locatorPosition).click();

        }
    }
    public void loginwithLightningAdminUser(String username, String password) {

        commonMethods.waitForPageToLoad();
        commonMethods.enterText(usernamefield, username);
        commonMethods.enterText(passwordfield, password);
        commonMethods.click(loginButton);
        page.waitForLoadState();
        if (page.locator(lightningText).isVisible())
        {

            page.locator(lightningText).first().click();
        }
        else
        {
            page.hover(".appLauncher");
            page.waitForSelector(".appLauncher");
            page.locator(".appLauncher").click();
            Locator viewAll = page.locator("//button[@aria-label='View All Applications']");
            viewAll.click();
            page.waitForLoadState();
        }
    }

    public void clickOpportunityLightningLink()
    {
        page.locator("//a[@data-label='Opportunities']").click();
        Locator opportunitiesnewButton = page.locator("//a[@title='New']");
        opportunitiesnewButton.click();
        page.getByText("Next").click();
    }
}
