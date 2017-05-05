package com.MasterBrewer.Entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "USERS", schema = "PUBLIC", catalog = "DEFAULT")
public class UserEntity {
    private Integer id;
    private String uname;
    private String pass;
    private int admin;
    private Set<ProjectEntity> projects;
    private Set<IOTDataEntity> IOTDatas;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "IOTDataOwner")
    public Set<IOTDataEntity> getIOTDatas() {
        return IOTDatas;
    }

    public void setIOTDatas(Set<IOTDataEntity> IOTDatas) {
        this.IOTDatas = IOTDatas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "projectOwner")
    public Set<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectEntity> projects) {
        this.projects = projects;
    }

    @Basic
    @Column(name = "UNAME")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "PASS")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name="ADMIN")
    public int getAdmin(){
    	return admin;
    }
    
    public void setAdmin(int admin){
    	this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }



    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pass='" + pass + '\'' +
                ", IOTDatas=" + IOTDatas +
                ", projects=" + projects +
                '}';
    }



}
