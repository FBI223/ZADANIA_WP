



public class ProxyBankAccount implements BankAccount
{
    private final RealBankAccount realBankAccount;
    private boolean isUserAuthenticated;
    private String storedPassword;

    ProxyBankAccount(String password) {
        this.realBankAccount = new RealBankAccount();
        this.isUserAuthenticated = false;
        this.storedPassword = password;
    }

    void authenticate(String password) {
        if (password.equals(this.storedPassword)) {
            this.isUserAuthenticated = true;
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }


    public void logout() {
        isUserAuthenticated = false;
        System.out.println("Session ended. Logged out.");
    }

    public boolean isAuthenticated() {
        return isUserAuthenticated;
    }

    @Override
    public int getBalance() {
        if (isUserAuthenticated) {
            return realBankAccount.getBalance();
        } else {
            return -1;
        }
    }

    @Override
    public void deposit(int amount) {
        if (isUserAuthenticated) {
            realBankAccount.deposit(amount);
        } else {
            System.out.println("You are not authenticated");
        }
    }

    @Override
    public void withdraw(int amount) {
        if (isUserAuthenticated) {
            realBankAccount.withdraw(amount);
        } else {
            System.out.println("You are not authenticated");
        }
    }
}


interface BankAccount {
    int getBalance();
    void deposit(int amount);
    void withdraw(int amount);
}


class RealBankAccount implements BankAccount {
    private int balance;

    @Override
    public int getBalance() {
        return balance;
    }
    @Override
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". Current balance: " + balance);
    }

    @Override
    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient funds");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Current balance: " + balance);
        }
    }
}


