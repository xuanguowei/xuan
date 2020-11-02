package exception;

/**
 * ClassName:OverDraftException
 * Package:exception
 * Description:
 *
 * @Date:2020/8/4 21:29
 * @Author:xuan
 */
public class OverDraftException extends Exception{
    private double deficit;

    public double getDeficit() {
        // TODO 自动生成的方法存根
        return deficit;
    }

    public OverDraftException(String msg, double deficit) {
        super(msg);
        this.deficit = deficit;
    }

}