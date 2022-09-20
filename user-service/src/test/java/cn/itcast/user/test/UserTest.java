package cn.itcast.user.test;

import cn.itcast.user.mapper.UserGeneralMapper;
import cn.itcast.user.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserGeneralMapper userGeneralMapper;

    @Test
    public void testInsertList() {
        List<User> userLists = new ArrayList<User>();
        User user1 = new User();

        user1.setUsername("科比");
        user1.setAddress("USA");
        User user2 = new User();

        user2.setUsername("乔治");
        user2.setAddress("洛杉矶");
        userLists.add(user1);
        userLists.add(user2);

        //userService.saveUserList(userLists);
        userGeneralMapper.insertList(userLists);
        System.out.println("Test Successful!");
    }

    @Test
    public void testDeleteByIds() {
        Long[] ids = {109L, 110L};
        String idsStr = StringUtils.join(ids, ",");
        userGeneralMapper.deleteByIds(idsStr);
        System.out.println("Test Successful!");
    }
}
