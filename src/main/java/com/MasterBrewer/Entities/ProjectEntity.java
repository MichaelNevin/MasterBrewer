package com.MasterBrewer.Entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "PROJECT")
public class ProjectEntity {
    private Integer id;
    private Integer powner;
    private String pname;
    private String description;
    private String picture;
    private Double goal;
    private boolean status;
    private Set<IOTDataEntity> IOTDatas;
    private UserEntity projectOwner;

    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue
    @OrderBy
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "targetProject")
    public Set<IOTDataEntity> getIOTDatas() {
        return IOTDatas;
    }

    public void setIOTDatas(Set<IOTDataEntity> IOTDatas) {
        this.IOTDatas = IOTDatas;
    }



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_OWNER_ID", insertable = false, updatable = false)
    public UserEntity getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(UserEntity projectOwner) {
        this.projectOwner = projectOwner;
    }

    @Basic
    @Column(name = "PROJECT_OWNER_ID")
    public Integer getPowner() {
        return powner;
    }

    public void setPowner(Integer powner) {
        this.powner = powner;
    }

    @Basic
    @Column(name = "PNAME")
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PICTURE")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "GOAL")
    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }
    
    @Basic
    @Column(name="STATUS")
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((goal == null) ? 0 : goal.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((IOTDatas == null) ? 0 : IOTDatas.hashCode());
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		result = prime * result + ((powner == null) ? 0 : powner.hashCode());
		result = prime * result + ((projectOwner == null) ? 0 : projectOwner.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		
		if (getClass() != obj.getClass()) return false;
		
		ProjectEntity other = (ProjectEntity) obj;
		
		if (description == null) { if (other.description != null) return false;
		} else if (!description.equals(other.description)) return false;
		if (goal == null) { if (other.goal != null) return false;
		} else if (!goal.equals(other.goal)) return false;
		if (id == null) { if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		if (picture == null) { if (other.picture != null) return false;
		} else if (!picture.equals(other.picture)) return false;
		if (IOTDatas == null) { if (other.IOTDatas != null) return false;
		} else if (!IOTDatas.equals(other.IOTDatas)) return false;
		if (pname == null) { if (other.pname != null) return false;
		} else if (!pname.equals(other.pname)) return false;
		if (powner == null) { if (other.powner != null) return false;
		} else if (!powner.equals(other.powner)) return false;
		if (projectOwner == null) { if (other.projectOwner != null) return false;
		} else if (!projectOwner.equals(other.projectOwner)) return false;
	
		if (status != other.status) return false;
		
		return true;
	}

	@Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", powner=" + powner +
                ", pname='" + pname + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", goal=" + goal +
                ", status=" + status +
                '}';
    }
}
