package com.cn.demo.entity;

/**
 * @Description 部门信息类
 * @Author Wangbo
 * @Date 2019/11/03
 * @Version V1.0
 **/
public class Department {

    private int dp_id;  //  部门编号
    private String dp_name; //  部门名称
    private int dp_numbers; //  部门人数
    private String dp_head; //  负责人

    @Override
    public String toString() {
        return "Department{" +
                "dp_id=" + dp_id +
                ", dp_name='" + dp_name + '\'' +
                ", dp_numbers=" + dp_numbers +
                ", dp_head='" + dp_head + '\'' +
                '}';
    }

    public int getDp_id() {
        return dp_id;
    }

    public void setDp_id(int dp_id) {
        this.dp_id = dp_id;
    }

    public String getDp_name() {
        return dp_name;
    }

    public void setDp_name(String dp_name) {
        this.dp_name = dp_name;
    }

    public int getDp_numbers() {
        return dp_numbers;
    }

    public void setDp_numbers(int dp_numbers) {
        this.dp_numbers = dp_numbers;
    }

    public String getDp_head() {
        return dp_head;
    }

    public void setDp_head(String dp_head) {
        this.dp_head = dp_head;
    }
}
