package pages;

import com.microsoft.playwright.Page;
import commonMethod.CommonMethods;

public class Concessions {

    private final Page page;
    private CommonMethods commonMethods;

    public Concessions(Page page) {
        this.page = page;
        commonMethods = new CommonMethods(page);
    }

    private String concessionFieldLink =".listTitle";
    private String concessionLocatorPosition = "nth=6";
    private String newConcessionButton="//input[@title='New Concession']";
    private String selectConsessionButton ="";
    private String concessionTextField = "//textarea[@name='j_id0:concessionForm:pb:pbs:j_id34:j_id38']";
    private String sectionDropDownField ="//*[@id='j_id0:concessionForm:pb:pbs:j_id39:j_id41']";
    private String saveButton = "//*[@value='Save']";


    public void clickConcessionLink()
    {
        commonMethods.clickOnLocatorPosition(concessionFieldLink,concessionLocatorPosition);
//        page.locator(concessionFieldLink).locator(concessionLocatorPosition).click();

    }
    public void clickNewConcessionButton()
    {
        commonMethods.click(newConcessionButton);

    }

    public void clickOnSaveButton()
    {
        commonMethods.clickOnFirstPositionLocator(saveButton);
    }

    public void createNewConcession(String concession)
    {
        commonMethods.waitForPageToLoad();
        commonMethods.clickOnLocatorPosition(concessionFieldLink,concessionLocatorPosition);
        commonMethods.click(newConcessionButton);
        commonMethods.enterText(concessionTextField,concession);
        commonMethods.clickOnFirstPositionLocator(saveButton);

    }





}
