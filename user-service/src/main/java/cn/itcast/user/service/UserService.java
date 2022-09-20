package cn.itcast.user.service;

import cn.itcast.user.mapper.UserGeneralMapper;
import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserGeneralMapper userGeneralMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }

    public Boolean insertUser(User user){
        return userMapper.insert(user);
    }

    public Boolean deleteById(Long id){
        return userMapper.deleteById(id);
    }

    public Boolean updateById(User user){
        return userMapper.updateById(user);
    }

    /**
     *分页查询
     * @param currentPage 页码
     * @param pageSize    每页显示数量
     */
    public List<User> findByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<User> lists = userMapper.findByPage(currentPage,pageSize);
        return lists;
    }
}