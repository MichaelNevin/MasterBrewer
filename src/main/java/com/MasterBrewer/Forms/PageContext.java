package com.MasterBrewer.Forms;

import java.util.Set;

import com.MasterBrewer.Entities.UserEntity;
import com.MasterBrewer.Views.ProjectItem;

/**
 * This object contains all the attributes for the page.
 *
 * Called by thymeleaf: '*{<function>}' from inside the body tag
 *
 */
public class PageContext {

    private Set<ProjectItem> projectEntities;
    private UserEntity userEntity;
    private Boolean isLoggedIn;
    private String containerFragment;

    public Set<ProjectItem> getProjectEntities() {
        return projectEntities;
    }

    public void setProjectEntities(Set<ProjectItem> projectEntities) {
        this.projectEntities = projectEntities;
    }

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getContainerFragment() {

        return isLoggedIn ? containerFragment : "login_page";
    }

    public void setContainerFragment(String containerFragment) {
        this.containerFragment = containerFragment;
    }
    
    public UserEntity getUserEntity(){
    	return userEntity;
    }

	public void setUserEntity(UserEntity user) {
		userEntity = user;
		
	}
}
