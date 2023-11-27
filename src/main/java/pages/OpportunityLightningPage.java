package pages;

import com.microsoft.playwright.Page;
import commonMethod.CommonMethods;

public class OpportunityLightningPage {

    private Page page;
    private CommonMethods commonMethods;


    public OpportunityLightningPage(Page page) {
        this.page = page;
        commonMethods = new CommonMethods(page);
    }



    private String newOpportunityButton ="//input[@name='new']";
    private String nextButtonOnOppRecordField = "Next";
    private String opportunityNameTextField = "//input[@name='Name']";
    private String closeDateField= "//*[@name='CloseDate']";
    private String stageFieldLocatorPosition ="//*[@data-value='--None--']";
    private String opportunityStage = "//*[@data-value='Prospecting']";
    private String meetingStartDateField = "//*[@name='NICX__MeetingStartDate__c']";
    private String saveButton ="//*[@name='SaveEdit']";


    public void createNewOpportunity(String oppName,String closeDate,String meetingStartDate) throws InterruptedException {
        commonMethods.enterText(opportunityNameTextField,oppName);
        commonMethods.enterText(closeDateField,closeDate);
        commonMethods.clickOnFirstPositionLocator(stageFieldLocatorPosition);
        commonMethods.click(opportunityStage);
        commonMethods.enterText(meetingStartDateField,meetingStartDate);
        commonMethods.click(saveButton);
        Thread.sleep(500);

    }



}
