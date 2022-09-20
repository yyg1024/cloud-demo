package cn.itcast.user.web;

import cn.itcast.user.mapper.UserGeneralMapper;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserGeneralMapper userGeneralMapper;

    @Value("${name}")
    private String name;

    @RequestMapping("/test")
    public String test(){
        return this.name;
    }

//    @GetMapping("/{id}")
//    public User queryById(@PathVariable("id") Long id) {
//        return userService.queryById(id);
//    }

//    @PostMapping
//    public Boolean insert(@RequestBody User user) {
//        return userService.insertUser(user);
//    }

//    @DeleteMapping("/{id}")
//    public Boolean deleteById(@PathVariable("id") Long id) {
//        return userService.deleteById(id);
//    }

//    @PutMapping
//    public Boolean updateUser(@RequestBody User user) {
//        return userService.updateById(user);
//    }

    /**
     * 使用pageHelper做分页查询
     * @param currentPage 页码
     * @param pageSize    每页显示数量
     */
    @GetMapping("{currentPage}/{pageSize}")
    public List<User> findUserByPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return userService.findByPage(currentPage, pageSize);
    }

    /**
     * 通用Mapper查询全部
     */
    @GetMapping("/general")
    public List<User> selectUserAll() {
        return userGeneralMapper.selectAll();
    }

    /**
     * 通用Mapper根据主键id查询
     * @param id 主键 需要在实体类中指定，不然会拼接所有字段进行查询
     */
    @GetMapping("/{id}")
    public User queryUserById(@PathVariable Long id) {
        return userGeneralMapper.selectByPrimaryKey(id);
    }

    @PutMapping
    public Integer updateUserById(@RequestBody User user){
        return userGeneralMapper.updateByPrimaryKey(user);
    }

    @PostMapping
    public Integer saveUser(@RequestBody User user){
        return userGeneralMapper.insert(user);
    }

    @DeleteMapping("/{id}")
    public Integer removeUser(@PathVariable Long id){
        return userGeneralMapper.deleteByPrimaryKey(id);
    }

//    @PostMapping
//    public Integer saveUserList(@RequestBody List<User> lists){
//        //INSERT INTO tb_user ( username,address ) VALUES ( ?,? ) , ( ?,? )
//        return userGeneralMapper.insertList(lists);
//    }
}
