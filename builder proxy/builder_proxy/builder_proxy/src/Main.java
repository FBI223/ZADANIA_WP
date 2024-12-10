

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

        Form formStudent = fBuilderStudent.ConstructAndGetForm();
        Form formAdmin = fBuilderAdmin.ConstructAndGetForm();

        System.out.println("Welcome Message: " + formStudent.getWelcomeMessage());
        System.out.println("Buttons: " + formStudent.getButtons());
        System.out.println();
        System.out.println("Welcome Message: " + formAdmin.getWelcomeMessage());
        System.out.println("Buttons: " + formAdmin.getButtons());


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();



        ProxyBankAccount proxyAccount = new ProxyBankAccount("qwerty");
        proxyAccount.authenticate("qwerty");
        proxyAccount.deposit(100);
        proxyAccount.withdraw(100);
        proxyAccount.withdraw(200);
        proxyAccount.deposit(300);
        proxyAccount.deposit(400);
        proxyAccount.deposit(500);
        proxyAccount.withdraw(200);
        System.out.println( "current balance : " +  proxyAccount.getBalance());
        System.out.println( "is logged : "  + proxyAccount.isAuthenticated());
        proxyAccount.logout();
        System.out.println( "is logged : " + proxyAccount.isAuthenticated());

    }
}

