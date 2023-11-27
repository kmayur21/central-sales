package org.example;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import pages.Login;
import pages.OpportunityLightningPage;
import pages.Questions;

import java.util.List;

public class testlightning {
    private String lightningURL = "https://r10packageorg.lightning.force.com/lightning/page/home";
    private final String getLightningURLOneApp ="lightning.force.com/one/one.app";

    OpportunityLightningPage opportunityLightningPage;
    Questions questions ;

    @Test
    public void launchBrowserLightning() throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(250)
                            .setArgs(List.of("--start-maximized")))
                    .newContext(new Browser.NewContextOptions().setViewportSize(null))
                    .newPage();

            page.navigate("https://login.salesforce.com/");
            System.out.println(page.url());
            Login loginConnex = new Login(page);
            loginConnex.loginwithLightningAdminUser("mayur.kumbhar@r10package.com", "1qaz!QAZ");
                page.waitForLoadState();

                opportunityLightningPage = new OpportunityLightningPage(page);
                opportunityLightningPage.createNewOpportunity("Testing Opp4","11/23/2023","11/23/2023");
                questions = new Questions(page);
                questions.createNewQuestion("automation testing question");

         }


        }
    }

