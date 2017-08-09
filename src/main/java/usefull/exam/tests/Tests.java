package usefull.exam.tests;



import org.testng.Assert;
import org.testng.annotations.Test;
import utilityProject.testBase.TestBase;
import usefull.exam.drivers.Application;
import usefull.exam.drivers.components.Bug;


/**
 * Created by Andrey on 02.07.2017.
 */
public class Tests extends TestBase {
    private Application app;

    @Override
    protected void beforeTest() {
        logger.log("Open web application");
        app = new Application(driver);
        app.open();
    }

    @Test(priority = 1)
    public void firstIssueIsPresent() {
        logger.log("Check first Bug is present");
        Assert.assertTrue(app.bugsPage().getBugByName("First Bug").getNotes().getText().equals("DO NOT DELETE ME!!!!"));
    }

    @Test(priority = 2)
    public void addNewBugViaAddForm() throws Exception {
        logger.log("click Add Form");
        app.controlPanel().clickButtonAddInForm();//getButtonAddInForm().click();
        logger.log("input Name");
        app.addBugForm().fillFieldName("Andrey's first bug name");
        logger.log("input Notes");
        app.addBugForm().fillFieldNotes("Andrey's first bug notes");
        logger.log("Click Ok");
        app.addBugForm().clickButtonOk();
        logger.log("Check a new bug is created");
        Thread.sleep(1000);
        Assert.assertTrue(app.bugsPage().getBugByName("Andrey's first bug name").getNotes().getText().equals("Andrey's first bug notes"));
        logger.log("Delete created bug");
        app.bugsPage().getBugByName("Andrey's first bug name").getName().click();
        app.controlPanel().clickButtonDelete();
        app.confirmation().clickButtonYes();
        logger.log("Check if bug was deleted");
        Assert.assertFalse(app.bugsPage().checkIfBugPresentByName("Andrey's first bug name"));
    }

    @Test(priority = 3)
    public void addNewBugViaAdd()  {

        logger.log("click Add");
        app.controlPanel().clickButtonAdd();
        logger.log("input Bug's name");
        Bug lastAddedBug = app.bugsPage().getBugsList().get(app.bugsPage().getBugsList().size()-1);
        lastAddedBug.doubleClickOnName(driver);
        app.bugsPage().inputText(lastAddedBug.getName(),"Andrey's second bug name");
        logger.log("input Bug's notes");
        lastAddedBug.doubleClickOnNotes(driver);
        app.bugsPage().inputText(lastAddedBug.getNotes(),"Andrey's second bug notes");
        logger.log("Click Apply");
        app.controlPanel().clickButtonApply();
        logger.log("Check if a new bug is created");
        Assert.assertTrue(app.bugsPage().getBugByName("Andrey's second bug name").getNotes().getText().equals("Andrey's second bug notes"));
        logger.log("Delete created bug");
        app.bugsPage().getBugByName("Andrey's second bug name").getName().click();
        app.controlPanel().clickButtonDelete();
        app.confirmation().clickButtonYes();
        logger.log("Check if bug was deleted");
        Assert.assertFalse(app.bugsPage().checkIfBugPresentByName("Andrey's second bug name"));
    }

}
