package pages;

import com.microsoft.playwright.Page;
import commonMethod.CommonMethods;

public class RFP {
    private Page page;
    private CommonMethods commonMethods;
    private String locationName ="R10 Package - Hotel - Dover";
    private String RFPAddedMessage = "1 RFP has been added to the Opportunity.";
    private String RFPSentMessage ="The following RFP's were sent successfully: R10 Package - Hotel - Dove";
    public RFP(Page page) {
        this.page = page;
        commonMethods = new CommonMethods(page);

    }

    private String RFPlinkField = ".listTitle";
    private String RFPlinkPosition = "nth=9";
    private String newRFPButton = "//*[@name='nicx__new']";
    private String RFPButtonPosition ="nth=2";
    private String saveSearchField = "//*[@id='j_id0:searchForm:savedsearches:saved_searches']";
    private String searchLocation = "//*[@id='j_id0:searchForm:savedsearches:advsearchfields:advfieldtable:0:j_id62']";
    private String searchLocationButton = "//*[@value='Search']";
    private String searchLocationPosition ="nth=1";
    private String R10PackageHotelCheckBoxField ="//*[@id='j_id0:searchForm:locationdata:j_id78:j_id99:0:checkedone']";
    private String locationNameField = "//*[@id='j_id0:searchForm:locationdata:j_id78:j_id99:0:locationname']";
    private String addButtonField = "//*[@id='addLocLA']";
    private String addedLocationField = "//*[@title='Select R10 Package - Hotel - Dover']";
    private String rfpMessageText =".messageText";
    private String closeButtonOnLocation = "//*[@value='Close']";
    private String sendButtonField = "//*[@title='Send']";
    private String sendButtonPosition = "nth =1";
    private String sendButtonOnRFPPage = "//*[@value='Send']";
    private String rfpSentMessageField = "";



    public void createRFP(String location,String searchText)
    {
        commonMethods.clickOnLocatorPosition(RFPlinkField,RFPlinkPosition);
        commonMethods.clickOnLocatorPosition(newRFPButton,RFPButtonPosition);
        commonMethods.addDropDownByName(saveSearchField,location);
        commonMethods.waitForPageToLoad();
        commonMethods.enterText(searchLocation,searchText);
        commonMethods.clickOnLocatorPosition(searchLocationButton,searchLocationPosition);
        if(page.textContent(locationNameField).contains(locationName))
        {
            commonMethods.click(R10PackageHotelCheckBoxField);
            commonMethods.click(addButtonField);
            commonMethods.waitForPageToLoad();
            if (page.textContent(rfpMessageText).contains(RFPAddedMessage))
            {
                commonMethods.waitForPageToLoad();
                commonMethods.click(closeButtonOnLocation);
            }
        }
        else{
            System.out.println("Location is not Found");
        }
    }

    public void sendRFP()
    {
        commonMethods.waitForPageToLoad();
        commonMethods.clickOnFirstPositionLocator(addedLocationField);
        commonMethods.clickOnLocatorPosition(sendButtonField,sendButtonPosition);
        commonMethods.click(sendButtonOnRFPPage);
        if(page.textContent(rfpMessageText).contains(RFPSentMessage))
        {
            commonMethods.waitForPageToLoad();
            commonMethods.click(closeButtonOnLocation);

        }
        else{
            System.out.println("RFP is not sent to location");
        }
    }

    public void verifyExternalID()
    {

    }

    public void centralSalesData()
    {
        page.getByText("Central Sales Data").click();
    }

//Mk_saved search test
//    R10

}
