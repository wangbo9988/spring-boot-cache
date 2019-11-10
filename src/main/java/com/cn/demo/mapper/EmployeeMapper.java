package com.cn.demo.mapper;

import com.cn.demo.entity.Employees;
import org.apache.ibatis.annotations.*;

/**
 * @Description
 * @Author Wangbo
 * @Date 2019/11/09
 * @Version V1.0
 **/
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM Employees WHERE id=#{id}")
    public Employees getEmpById(Integer id);

    @Update("UPDATE Employees set name=#{name},sex=#{sex},age=#{age},annual_salary=#{annual_salary} WHERE id=#{id}")
    public int updateEmp(Employees employees);

    @Delete("UPDATE Department SET dp_numbers=dp_numbers-1 WHERE dp_id=(SELECT dp_id FROM Employees WHERE id=#{id});DELETE FROM Employees em WHERE em.id=#{id};")
    public int deleteEmpById(Integer id);

    @Insert("INSERT INTO Employees(id,name,sex,age,dp_id,annual_salary) VALUES(#{id},#{name},#{sex},#{age},#{ap_id},#{annual_salary})")
    public Employees insertEmp(Employees employees);
}
