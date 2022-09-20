package cn.itcast.user.mappers;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper基类，不能与UserGeneralMapper在同一个包
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {

}
