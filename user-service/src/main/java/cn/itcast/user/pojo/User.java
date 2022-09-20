package cn.itcast.user.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_user") //实体类与其映射的数据库表名不同名时需要使用 @Table 标注说明，name用于指明数据库的表名
public class User {

    @Id
    private Long id;
    private String username;
    private String address;
}