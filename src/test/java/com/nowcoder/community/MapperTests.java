package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper mUserMapper;

    @Autowired
    private DiscussPostMapper mDiscussPostMapper;

    @Test
    public void testSelectUser() {
        User user = mUserMapper.selectById(101);
        System.out.println(user);

        user = mUserMapper.selectByName("liubei");
        System.out.println(user);

        user = mUserMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = mUserMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = mUserMapper.updateStatus(150, 1);
        System.out.println(rows);
        rows = mUserMapper.updateHeader(150, "http://www.nowcoder.com/103.png");
        System.out.println(rows);
        rows = mUserMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPost() {
        List<DiscussPost> list = mDiscussPostMapper.selectDiscussPosts(101, 0, 10);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }
        int rows = mDiscussPostMapper.selectDiscussPostRows(101);
        System.out.println(rows);
    }


}
