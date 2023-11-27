package commonMethod;

import Base.BaseClass;
import com.microsoft.playwright.Page;

public class CommonMethods extends BaseClass {

    private final Page page;

    public CommonMethods(Page page)
    {
        this.page = page;
    }

    public void click(String locator)
    {
        waitForPageToLoad();
        page.locator(locator).click();

    }
    public void enterText(String locator,String textToEnter)
    {
        page.locator(locator).fill(textToEnter);
    }
    public void waitForPageToLoad()
    {
        page.waitForLoadState();
    }

    public void addDropDownByName(String locator, String selectValue)
    {
        page.selectOption(locator,selectValue);
    }

    public void clickOnLocatorPosition(String locator,String position)
    {
        waitForPageToLoad();
        page.locator(locator).locator(position).click();
    }
    public void clickOnFirstPositionLocator(String loc)
    {
        waitForPageToLoad();
        page.locator(loc).first().click();
    }

    public void clickOnLinkText(String locator)
    {
        waitForPageToLoad();
        page.getByText(locator).click();
    }

    public void waitForPageToCheck(String locator)
    {
        page.check(locator);
    }
    public void wait_for_selector(String selector)
    {
        page.waitForSelector(selector,new Page.WaitForSelectorOptions().setTimeout(10000));
    }

}
