package pages;

import com.microsoft.playwright.Page;
import commonMethod.CommonMethods;

public class RoomNights {

    private Page page;
    private CommonMethods commonMethods;
    public RoomNights(Page page)
    {
        this.page= page;
        commonMethods = new CommonMethods(page);
    }
    private String roomNightLink = ".listTitle";
    private String roomNightLocatorPosition = "nth=7";
    private String newRoomNightButton ="//*[@name='nicx__new']";
    private String roomNightQuickCreateButton ="//*[@name='nicx__quick_create']";
    private String numberOfNightsField = "//*[@id='mainPage:myForm:pBlock:pbSect:j_id59:numNights']";
    private String numberOfRoomsField = "//*[@id='mainPage:myForm:pBlock:pbSect:j_id64:numRooms']";
    private String numberOfGuestField = "//*[@id='mainPage:myForm:pBlock:pbSect:j_id69:numGuests']";
    private String budgetedRateField = "//*[@id='mainPage:myForm:pBlock:pbSect:pbSecItem:budgetedRate1']";
    private String createButtonField = "//*[@value='Create']";
    private String canceButtonField = "//*[@value='Cancel']";

    public void quickCreateRoomNight(String noOfNights, String noOfRooms, String noOfGuest, String budgetRate)
    {
        commonMethods.waitForPageToLoad();
        commonMethods.clickOnLocatorPosition(roomNightLink,roomNightLocatorPosition);
        commonMethods.click(roomNightQuickCreateButton);
        commonMethods.enterText(numberOfNightsField,noOfNights);
        commonMethods.enterText(numberOfRoomsField,noOfRooms);
        commonMethods.enterText(numberOfGuestField,noOfGuest);
        commonMethods.enterText(budgetedRateField,budgetRate);
        commonMethods.click(createButtonField);

    }




}
