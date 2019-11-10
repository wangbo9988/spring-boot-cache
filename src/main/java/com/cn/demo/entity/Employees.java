package com.cn.demo.entity;

/**
 * @Description 员工信息表
 * @Author Wangbo
 * @Date 2019/11/03
 * @Version V1.0
 **/
public class Employees {

    private int id; //  员工编号
    private String name; // 员工姓名
    private String sex; // 员工性别
    private int age; // 员工年龄
    private int dp_id;  //  所在部门
    private double annual_salary;   //  年薪

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", dp_id=" + dp_id +
                ", annual_salary=" + annual_salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDp_id() {
        return dp_id;
    }

    public void setDp_id(int dp_id) {
        this.dp_id = dp_id;
    }

    public double getAnnual_salary() {
        return annual_salary;
    }

    public void setAnnual_salary(double annual_salary) {
        this.annual_salary = annual_salary;
    }
}
