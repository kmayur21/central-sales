package org.example;

import Base.BaseClass;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class TestOpp extends BaseClass {
    private Page page;

    private Opportunity opp;
    private Questions ques;
    private Concessions concessions;
    private RoomNights roomNights;
    private RFP rfp;
    private Login loginConnex;


    @Test
    public void launchChrome()
    {


        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200)
                        .setArgs(List.of("--start-maximized")))
                        .newContext(new Browser.NewContextOptions().setViewportSize(null))
                                .newPage();
        page.navigate(prop.getProperty("URL"));

//        page.navigate("https://login.salesforce.com/");
//        launchBrowser();
        loginConnex = new Login(page);
        loginConnex.loginWithStandardUserAndNavigateToClassic(prop.getProperty("username"), prop.getProperty("password"));
        opp = new Opportunity(page);
        opp.createOpportunityWithMandatoryFields(dataFile.getProperty("opportunityName"),dataFile.getProperty("closeDate"),dataFile.getProperty("opportunityStage"),dataFile.getProperty("meetingStartDate"));
//        opp.createOpportunityWithMandatoryFields("testing opp5", "11/15/2023", "Prospecting", "11/14/2023");
//            concessions = new Concessions(page);
//            concessions.createNewConcession("Testing concession");
            ques = new Questions(page);
            ques.clickQuestionOnOpportunity();
            ques.enterQuestionText("automation test");
            ques.clickSaveButton();
            roomNights = new RoomNights(page);
            roomNights.quickCreateRoomNight("2","3","3","100");
            rfp = new RFP(page);
            rfp.createRFP("Mk_saved search test", "R10");
            rfp.sendRFP();

    }
}
