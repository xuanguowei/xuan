package exception;

/**
 * ClassName:EnemyHeroIsDeadException
 * Package:exception
 * Description:
 *
 * @Date:2020/8/4 20:47
 * @Author:xuan
 */
public class EnemyHeroIsDeadException extends Exception {
    public EnemyHeroIsDeadException(){

    }
    public EnemyHeroIsDeadException(String msg){
        super(msg);
    }
}
