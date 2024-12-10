

public class Main {
    public static void main(String[] args) {
        FormBuilder fBuilderStudent = new FormBuilder ();
        FormBuilder fBuilderAdmin = new FormBuilder ();

        StudentsButtonsBuilder bBuilder = new StudentsButtonsBuilder();
        StudentsWMBuilder wmBuilder= new StudentsWMBuilder();

        AdminButtonsBuilder aBuilder = new AdminButtonsBuilder();
        AdminWMBuilder aWMBuilder = new AdminWMBuilder();

        fBuilderStudent.setButtonsBuilder(bBuilder);
        fBuilderStudent.setWMBuilder(wmBuilder);

        fBuilderAdmin.setButtonsBuilder(aBuilder);
        fBuilderAdmin.setWMBuilder(aWMBuilder);

        fBuilderStudent.constructForm();
        fBuilderAdmin.constructForm();

        Form formStudent = fBuilderStudent.getForm();
        Form formAdmin = fBuilderAdmin.getForm();

        System.out.println("Welcome Message: " + formStudent.getWelcomeMessage());
        System.out.println("Buttons: " + formStudent.getButtons());
        System.out.println();
        System.out.println("Welcome Message: " + formAdmin.getWelcomeMessage());
        System.out.println("Buttons: " + formAdmin.getButtons());

    }
}

