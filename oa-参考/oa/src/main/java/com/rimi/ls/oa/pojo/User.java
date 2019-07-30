package com.rimi.ls.oa.pojo;

import java.util.List;

/**
 * 用户实体
 */
public class User {

    private Long id;
    private String name;
    private Byte sex;
    private String address;
    private String telephone;

    private Department department;//用户所在部门

    private List<Role> roles;// 角色（岗位、职位）

    public User() {
    }

    public User(Long id, String name, Byte sex, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
