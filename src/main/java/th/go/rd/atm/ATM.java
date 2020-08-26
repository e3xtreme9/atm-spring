package th.go.rd.atm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ATM {

    private Bank bank;
    private Customer cerrentCustomer;

    @Autowired
    public ATM(Bank bank){
        this.bank = bank;
    }

    public void validateCustomer(int id, String pin){
        Customer matchingCustomer = bank.findCustomer(id);
        if (matchingCustomer != null && matchingCustomer.checkPin(pin)){
            cerrentCustomer = matchingCustomer;
        }
    }

    public void deposit(double amount){
        cerrentCustomer.getAccount().deposit(amount);
    }

    public void withdraw(double amount){
        cerrentCustomer.getAccount().withdraw(amount);
    }

    public void transfer(int recieverId, double amount){
        Customer reciever = bank.findCustomer(recieverId);
        cerrentCustomer.getAccount().withdraw(amount);
        reciever.getAccount().deposit(amount);
    }

    public double getBalance(){
        return cerrentCustomer.getAccount().getBalance();
    }

    public void end(){
        cerrentCustomer = null;
    }
}
