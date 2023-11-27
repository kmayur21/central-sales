package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;


public class TestCS{

//    private final String lightningURL ="https://r10packageorg.lightning.force.com/lightning/page/home";
//    private final String getLightningURLOneApp ="lightning.force.com/one/one.app";
//    private final String lightningTitle ="Lightning Experience";
//    private final String R10LightningURL= "https://r10packageorg.file.force.com";
//    private final String classicURL = "https://r10packageorg.my.salesforce.com/home/home.jsp";

    private Page page;
    private Opportunity opp;
    private Questions ques;
    private Concessions concessions;
    private RoomNights roomNights;
    private RFP rfp;
    private Login loginConnex;

    @Test
    public void launchBrowser() throws InterruptedException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()

                    .setHeadless(false).setSlowMo(150));
            Page page = browser.newPage();
            page.setViewportSize(1263,580);
            page.navigate("https://login.salesforce.com/");
            System.out.println(page.url());
            loginConnex = new Login(page);
            loginConnex.loginWithStandardUserAndNavigateToClassic("mayur.kumbhar@r10package.com", "1qaz!QAZ");
            //loginConnex.loginwithAdminUser("mayur.kumbhar@r10package.com","");
//            page.waitForLoadState();
            opp = new Opportunity(page);
            opp.createOpportunityWithMandatoryFields("testing opp5", "11/15/2023", "Prospecting", "11/14/2023");
//            concessions = new Concessions(page);
//            concessions.createNewConcession("Testing concession");
            ques = new Questions(page);
            ques.clickQuestionOnOpportunity();
            ques.enterQuestionText("automation test");
            ques.clickSaveButton();
//            Thread.sleep(20000);
//            roomNights = new RoomNights(page);
//            roomNights.quickCreateRoomNight("2","3","3","100");
//            rfp = new RFP(page);
//            rfp.createRFP("Mk_saved search test", "R10");
//            rfp.sendRFP();


        }
    }
}
