package annotations;

import java.lang.annotation.*;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * ClassName:DBConfig
 * Package:annotations
 * Description:
 *
 * @Date:2020/9/7 10:18
 * @Author:xuan
 */
@Target({METHOD,TYPE})//表示这个注解能放在什么位置上，其参数表示是只能放在类上？还是即可以放在方法上
@Retention(RetentionPolicy.RUNTIME)//表示生命周期，编译阶段?运行阶段?还是运行之后
@Inherited//可继承
@Documented//在用javadoc命令生成API文档后，DBUtil的文档里会出现该注解和说明
//@Repeatable()//修饰的时候，注解在同一个位置，只能出现一次,使用@Repeatable配合一些其他动作，就可以在同一个地方使用多次了
public @interface DBConfig {
    String url();
    String user();
    String password();
}