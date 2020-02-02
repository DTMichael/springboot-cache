package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee where id= #{id}")
    public Employee getEmpById(Integer id);

    @Update(("UPDATE employee SET lastName=#{lastName} , email=#{email} , gender=#{gender},d_id=#{dId} WHERE id=#{id}"))
    public void UpdateEmp(Employee employee);

    @Delete("DELETE FROM employee where id=#{id}")
    public void deleteEmp(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO employee VALUES(#{lastName}, #{email}, #{gender}, #{dId}")
    public void insertEmp(Employee employee);

//    @Delete("DELETE FROM employee WHERE id=#{id}")
//    public void deleteById(Integer id);
}
