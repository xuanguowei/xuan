package exception;

/**
 * ClassName:Account
 * Package:exception
 * Description:
 *
 * @Date:2020/8/4 21:30
 * @Author:xuan
 */
public class Account {
    protected double balance;


    public Account(double balance) {
        this.balance = balance;
    }


    public void deposit(double amt) {
        this.balance +=amt;
    }


    public void withdraw(double amt) throws OverDraftException{
        if(balance<amt) {
            throw new OverDraftException("余额不足",amt-this.balance);
        }
        this.balance -= amt;
    }


    public double getBalance() {
        return balance;
    }


    public static void main(String[] args) {
        //开户存了1000
        Account a = new Account(1000);
        //存钱1000
        a.deposit(1000);
        //查看余额
        System.out.println(a.getBalance());

        try {
            //取2001
            a.withdraw(2242);
        } catch (OverDraftException e) {
            System.err.println("透支金额："+e.getDeficit());
            e.printStackTrace();
        }
        System.out.println(a.balance);
    }
}
