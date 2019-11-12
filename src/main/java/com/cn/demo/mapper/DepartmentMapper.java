package com.cn.demo.mapper;

import com.cn.demo.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author Wangbo
 * @Date 2019/11/09
 * @Version V1.0
 **/
@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM Department WHERE dp_id=#{id}")
    public Department getDepById(Integer id);

    @Delete("DELETE FROM Department WHERE dp_id=#{id}")
    public int delDepById(Integer id);
}
