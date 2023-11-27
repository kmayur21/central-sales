package pages;

import com.microsoft.playwright.Page;
import commonMethod.CommonMethods;

public class Opportunity {

    private final Page page;
    private CommonMethods commonMethods;
    private  String opportunityTab ="//*[@title='Opportunities Tab']";
    private String newOpportunityButtonField ="//input[@name='new']";
    private String continueButton = "//input[@title='Continue']";
    private String cancelButton = "//input[@title='Cancel']";
    private String opportunityNameText = "//input[@name='opp3']";
    private String accountNameField = "#opp4";
    private String oppCloseDateField= "#opp9";
    private String oppStageField = "#opp11";
    private String meetingStartDateField = "//input[@id='00N8Z00000A59Y0']";
    private String locatorPosition = "n=2";
    private String saveButtonField ="//td[@id='bottomButtonRow']//input[@title='Save']";
    private String errorMessage =".errorMsg";



    public Opportunity(Page page) {
        commonMethods = new CommonMethods(page);
        this.page = page;

    }

    public void clickOnOpportunityTab(){
        page.click(opportunityTab);

    }
    public void newOpportunityButton(){
        page.click(newOpportunityButtonField);
        //page.locator(newOpportunityButton).click();
    }
    public void defaultOpportunity() {
        page.click(continueButton);
    }
    public void newOpportunityName(String name)
    {
        commonMethods.enterText(opportunityNameText,name);
//        page.fill(opportunityNameText,name);

    }
    public void closeDate(String oppCloseDate)
    {
        commonMethods.enterText(oppCloseDateField,oppCloseDate);
//        page.fill(oppCloseDateField,oppCloseDate);


    }
    public void oppStage(String oppStage)
    {
        commonMethods.addDropDownByName(oppStageField,oppStage);
//        page.selectOption(oppStageField,oppStage);

    }
    public void meetingStartDate(String date)
    {
//        Locator Loc = page.locator("");

        commonMethods.enterText(meetingStartDateField,date);
//        page.fill(meetingStartDateField,date);

    }
    public void clickSaveButton()
    {
        commonMethods.click(saveButtonField);


    }
    public void clickSaveAndNewButton()
    {

    }
    public void clickCancelButton()
    {

    }
    public void opportunityCurrency()
    {

    }
    public void hoverToQuestions()
    {
        page.locator(".listTitle").locator("nth=5").hover();
        page.locator("").locator("nth=1").click();

    }

    public void createOpportunityWithMandatoryFields(String oppName,String closeDate,String oppStage, String meetingDate)
    {

        clickOnOpportunityTab();
        newOpportunityButton();
        defaultOpportunity();
        newOpportunityName(oppName);
        closeDate(closeDate);
        oppStage(oppStage);
        meetingStartDate(meetingDate);
        clickSaveButton();



//        commonMethods.enterText(opportunityNameText,oppName);
//        commonMethods.enterText(oppCloseDateField,closeDate);

//        commonMethods.addDropDownByName(oppStageField,oppStage);
//        commonMethods.enterText(meetingStartDateField,meetingDate);
//        page.selectOption(oppStageField,oppStage);
//        page.fill(meetingStartDate,meetingDate);


    }
    public void accountName(String accountNameToAddToOpp)
    {
        page.fill(accountNameField,accountNameToAddToOpp);

    }

    public void verifyValidAccount()
    {

    }

    public void createOpportunityWithAccountAndContact(String oppName,String closeDate,String oppStage, String meetingDate,String accountName)
    {
        page.waitForLoadState();
        page.fill(opportunityNameText,oppName);
        page.fill(oppCloseDateField,closeDate);
        page.fill(accountNameField,accountName);
        page.selectOption(oppStageField,oppStage);
        page.fill(meetingStartDateField,meetingDate);

    }
}
