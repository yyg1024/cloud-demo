package cn.itcast.user.mapper;

import cn.itcast.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    
    public User findById(Long id);
    public Boolean insert(User user);
    public Boolean deleteById(Long id);
    public Boolean updateById(User user);
    public List<User> findByPage(int currentPage,int pageSize);
}