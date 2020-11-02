package jdbc;

import java.util.List;

/**
 * ClassName:Dao
 * Package:jdbc
 * Description:
 *
 * @Date:2020/8/30 9:15
 * @Author:xuan
 */
public interface Dao {
    //增加
    public void add(Hero hero);
    //修改
    public void update(Hero hero);
    //删除
    public void delete(int id);
    //获取
    public Hero get(int id);
    //查询
    public List<Hero> list();
    //分页查询
    public List<Hero> list(int start, int count);
}
