package com.MasterBrewer.Entities;

import javax.persistence.*;

@Entity
@Table(name = "IOTData", schema = "PUBLIC", catalog = "DEFAULT")
public class IOTDataEntity {
	
    private Integer id;
    private Integer powner;
    private Integer target;
    private Double amount;
    private Boolean permanent;
    private UserEntity IOTDataOwner;
    private ProjectEntity targetProject;

    @Id
    @Column(name = "IOTData_ID")
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IOTData_OWNER_ID", referencedColumnName = "USER_ID",
            insertable = false, updatable = false)
    public UserEntity getIOTDataOwner() {
        return IOTDataOwner;
    }

    public void setIOTDataOwner(UserEntity IOTDataOwner) {
        this.IOTDataOwner = IOTDataOwner;
    }



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TARGET_ID", referencedColumnName = "PROJECT_ID",
            insertable = false, updatable = false)
    public ProjectEntity getTargetProject() {
        return targetProject;
    }

    public void setTargetProject(ProjectEntity targetProject) {
        this.targetProject = targetProject;
    }

    @Basic
    @Column(name = "IOTData_OWNER_ID")
    public Integer getPowner() {
        return powner;
    }

    public void setPowner(Integer powner) {
        this.powner = powner;
    }

    @Basic
    @Column(name = "TARGET_ID")
    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    @Basic
    @Column(name = "AMOUNT")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "PERMANENT")
    public Boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IOTDataEntity that = (IOTDataEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (powner != null ? !powner.equals(that.powner) : that.powner != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (permanent != null ? !permanent.equals(that.permanent) : that.permanent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (powner != null ? powner.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (permanent != null ? permanent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IOTDataEntity{" +
                "id=" + id +
                ", powner=" + powner +
                ", target=" + target +
                ", amount=" + amount +
                ", permanent=" + permanent +
                '}';
    }
}
