import org.junit.*;
import Dao.impl.Userdao;
import javabean.User;

import java.util.List;

public class UserDaoTest {

    Userdao udao = new Userdao();
    @Test
    public void testCreateUser(){
//        User user = new User();
//        user.setId(2l);
//        user.setPassword("12345");
//        user.setAge(18);
//        user.setUserName("小明");
//        user.setSex(true);

//        udao.save(user);
        User user2=new User();
        user2.setId(3l);
        user2.setPassword("222");
        user2.setAge(19);
        user2.setUserName("小白");
        user2.setSex(false);
        udao.save(user2);
    }

    @Test
    public void testupdate(){
        User user2=new User();
        user2.setId(3l);
        user2.setPassword("2225");
        user2.setAge(19);
        user2.setUserName("小白");
        user2.setSex(false);
        udao.update(user2);
    }

    @Test
    public  void testSelectAll(){
        List<User> list=udao.getAll();
        list.forEach(item->System.out.println(item.getUserName()));
    }

    @Test
    public void testLogin(){
        System.out.println(udao.Login("小明","12345"));
    }

}
