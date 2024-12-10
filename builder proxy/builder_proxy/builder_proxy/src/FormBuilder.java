import java.util.ArrayList;
import java.util.List;


class Form{
    String welcomeMessage ="";
    List<String> buttonList = new ArrayList<String>();

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public List<String> getButtons() {
        return buttonList;
    }

}

public class FormBuilder {

    private ButtonsBuilder buttonsBuilder;
    private WelcomeMessageBuilder welcomeMessageBuilder;

    public void setButtonsBuilder( ButtonsBuilder bb ){
        this.buttonsBuilder = bb;
    }

    public void setWMBuilder( WelcomeMessageBuilder wmb ){
        this.welcomeMessageBuilder = wmb;
    }

    public Form ConstructAndGetForm() {

        Form form = new Form();

        buttonsBuilder.setForm(form);
        welcomeMessageBuilder.setForm(form);

        if (buttonsBuilder != null) {
            buttonsBuilder.setForm(form);
            buttonsBuilder.addButtons();
        }

        if (welcomeMessageBuilder != null) {
            welcomeMessageBuilder.setForm(form);
            welcomeMessageBuilder.printWM();
        }

        return form;
    }

}



abstract class ButtonsBuilder
{
    protected Form form;
    public void setForm(Form form) {
        this.form = form;
    }
    public abstract void addButtons();
}

class StudentsButtonsBuilder extends ButtonsBuilder{
    @Override
    public void addButtons(){
        form.buttonList.add( "Check Grades" );
        form.buttonList.add( "Check Schedule" );
    }
}

class AdminButtonsBuilder extends ButtonsBuilder{
    @Override
    public void addButtons(){
        form.buttonList.add( "remove student" );
        form.buttonList.add( "add student" );
        form.buttonList.add( "add class" );
        form.buttonList.add( "remove class" );
        form.buttonList.add( "give premission" );
    }
}






abstract class WelcomeMessageBuilder{

    protected Form form;
    public void setForm(Form form) {
        this.form = form;
    }
    public abstract void printWM();
}


class StudentsWMBuilder extends WelcomeMessageBuilder{
    @Override
    public void printWM()
    {
        form.welcomeMessage = "Welcome Student!";
    }
}


class AdminWMBuilder extends WelcomeMessageBuilder{
    @Override
    public void printWM()
    {
        form.welcomeMessage = "Welcome Admin!";
    }

}

