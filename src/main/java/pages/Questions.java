package pages;

import com.microsoft.playwright.Page;
import commonMethod.CommonMethods;

public class Questions {

    private final Page page;
    CommonMethods commonMethods;
    public Questions(Page page) {
        commonMethods = new CommonMethods(page);
        this.page=page;

    }

    private String questionLinkField = "//*[@title='Questions']";

    private String newQuestionLink = ".linklet";
    private String locatorPosition = "nth=5";
    private String questionposition = "nth=0";
    private String newQuestionButton = "//*[@title='New Question']";
    private String questionTextField = "//*[@name='j_id0:questionForm:pb:pbs:j_id37:j_id41']";
    private String questionTypeField ="//*[@id='j_id0:questionForm:pb:pbs:questionTypePbs:questionTypeDD']";
    private String categoryField ="//*[@id='j_id0:questionForm:pb:pbs:j_id43:j_id45']";
    private String sectionField ="";
    private String isAnswerRequiredField ="//*[@type='checkbox']";
    private String answerTextField ="";
    private String saveButtonLocatorPosition = "nth=1";
    private String saveButtonField ="//*[@name='j_id0:questionForm:pb:j_id5:j_id9']";
    private String saveAndNewButtonField ="";
    private String cancelButtonField = "";
    private String internalOnlyLocatorPosition ="";
    private String locationPosition = "nth=1";


    public void clickQuestionOnOpportunity()
    {
        commonMethods.waitForPageToLoad();
        page.locator(newQuestionLink).locator(locatorPosition).click();
        page.locator(newQuestionButton).first().click();

    }

    public void enterQuestionText(String question)
    {
        commonMethods.enterText(questionTextField,question);
    }
    public void selectQuestionType(String questionType)
    {
        commonMethods.addDropDownByName(questionTypeField,questionType);

    }
    public void selectCategoryType(String category)
    {
        commonMethods.addDropDownByName(categoryField,category);
    }
    public void clickSaveButton()
    {
        commonMethods.click(saveButtonField);
    }

    public void createNewQuestion(String questiontext)
    {

        commonMethods.clickOnLocatorPosition(questionLinkField,locationPosition);
        commonMethods.click(newQuestionButton);

        if(page.locator(questionTextField).isVisible())
        {

            commonMethods.enterText(questionTextField,questiontext);

        }
        commonMethods.click(saveButtonField);


    }

}
