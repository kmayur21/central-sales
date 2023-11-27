package pages;

import com.microsoft.playwright.Page;
import commonMethod.CommonMethods;

public class QuestionLightningPage {

    private Page page;
    private CommonMethods commonMethods;

    public QuestionLightningPage(Page page) {
        this.page = page;
        commonMethods = new CommonMethods(page);

    }

    private String questionLinkField = "Questions";
    private String newQuestionField = "New Question";
    private String newQuestionTextField = "//textarea[@name='j_id0:questionForm:pb:pbs:j_id37:j_id41']";
    private String saveButton = "";


    public void createQuestion()
    {
        commonMethods.click(questionLinkField);
        commonMethods.click(newQuestionField);



    }
}
