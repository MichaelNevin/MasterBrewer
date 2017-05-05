package com.MasterBrewer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MasterBrewer.Entities.IOTDataEntity;
import com.MasterBrewer.Entities.ProjectEntity;
import com.MasterBrewer.Entities.UserEntity;
import com.MasterBrewer.Repository.IOTDataRepository;
import com.MasterBrewer.Repository.ProjectsRepository;
import com.MasterBrewer.Repository.UserRepository;
import com.MasterBrewer.Views.ProjectItem;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProjectService {

    @Autowired
    ProjectsRepository projectRepo;
    
    @Autowired
    IOTDataRepository IOTDataRepo;
    
    @Autowired
    UserRepository userRepo;
    
    int number = 4;
    

    public Iterable<ProjectEntity> getProjects(){
        return projectRepo.findAll();
    }


    /**
     * Retrieves the projects from the database and creates a {@link ProjectItem}
     * <br>
     *     The ProjectItem is simply a object that calculates the progress, daysToGo etc..
     *     <br>
     *         Thymeleaf can then call the methods, and display the record.
     *
     * @return A set of ProjectItems
     */
    public Set<ProjectItem> getProjectViewItems(){
        Set<ProjectItem> projectItems = new HashSet<>();
        for (ProjectEntity entity : projectRepo.findAll()) {
            ProjectItem projectItem = new ProjectItem();
            Set<IOTDataEntity> IOTDataEntitySet = entity.getIOTDatas();

            projectItem.setTitle(entity.getPname());
            projectItem.setDescription(entity.getDescription());
            projectItem.setProjectGoal(entity.getGoal());
            projectItem.setMediaUrl(entity.getPicture());
            projectItem.setBackers(IOTDataEntitySet.size());
            projectItem.setProjectOwner(entity.getProjectOwner());
            projectItem.setStatus(entity.getStatus());
       
            double counter = 0.0;
            double first = 0.0;
            double last = 0.0;
            double m = -0.1625;
            double c = 1.1124;
            
            // IOTDatad and percentage
            for (IOTDataEntity iOTDataEntity : IOTDataEntitySet){
        	if (first == 0.0)
        	{
        		first = iOTDataEntity.getAmount(); 		
        	}
        	last = iOTDataEntity.getAmount(); 
            	
            
            if (iOTDataEntity.getAmount() > 0)
            {
            	projectItem.setNewpoints((double)iOTDataEntity.getAmount());
            }
        	counter++;
            }

            
            double firstGrav = (m*first)+c;
            double lastGrav = (m*last)+c;
            projectItem.setDaysRemaining(firstGrav, lastGrav, counter);
            projectItem.setFinalGoalPercentage((firstGrav - projectItem.getProjectGoal())* 131.25);
            projectItem.setGoalPercentage((int)((30*(counter-1))/(projectItem.getDaysRemaining()*60)*100));       
            projectItems.add(projectItem);
        }
        return projectItems;
    }

	public UserEntity findByUname(String uname) {
		return userRepo.findByUname(uname);
	}
	
	public int findId(String title){
		System.out.println(title);
		int id = 0;
		for (ProjectEntity entity : projectRepo.findAll()) 
		{
        	if(entity.getPname().contains(title))
        	{
        		id = entity.getId();
        		
        	}
		}
		return id;
		
	}

	public Set<ProjectItem> getProjectsByUser(Integer id) {
		Set<ProjectItem> projectItems = new HashSet<>();
        for (ProjectEntity entity : projectRepo.findAll()) {
        	if(entity.getPowner() == id){
        		ProjectItem projectItem = new ProjectItem();
                Set<IOTDataEntity> IOTDataEntitySet = entity.getIOTDatas();

                projectItem.setTitle(entity.getPname());
                projectItem.setDescription(entity.getDescription());
                projectItem.setProjectGoal(entity.getGoal());
                projectItem.setMediaUrl(entity.getPicture());
                projectItem.setBackers(IOTDataEntitySet.size());
                projectItem.setProjectOwner(entity.getProjectOwner());
                projectItem.setStatus(entity.getStatus());

                double counter = 0.0;
                double first = 0.0;
                double last = 0.0;
                double m = -0.1625;
                double c = 1.1124;
                
                // IOTDatad and percentage
                for (IOTDataEntity iOTDataEntity : IOTDataEntitySet){
            	if (first == 0.0)
            	{
            		first = iOTDataEntity.getAmount(); 		
            	}
            	last = iOTDataEntity.getAmount(); 
                	
                
                if (iOTDataEntity.getAmount() > 0)
                {
                	projectItem.setNewpoints((double)iOTDataEntity.getAmount());
                }
            	counter++;
                }

                
                double firstGrav = (m*first)+c;
                double lastGrav = (m*last)+c;
                projectItem.setDaysRemaining(firstGrav, lastGrav, counter);
                projectItem.setFinalGoalPercentage((firstGrav - projectItem.getProjectGoal())* 131.25);
                projectItem.setGoalPercentage((int)((30*(counter-1))/(projectItem.getDaysRemaining()*60)*100));       
                projectItems.add(projectItem);
        	}
        }
        
		return projectItems;
	}
	
	public Set<ProjectItem> getProjectsByTitle(String title){
		Set<ProjectItem> projectItems = new HashSet<>();
		for (ProjectEntity entity : projectRepo.findAll()){
			if(entity.getPname().contains(title)){
				ProjectItem projectItem = new ProjectItem();
                Set<IOTDataEntity> IOTDataEntitySet = entity.getIOTDatas();

                projectItem.setTitle(entity.getPname());
                projectItem.setDescription(entity.getDescription());
                projectItem.setProjectGoal(entity.getGoal());
                projectItem.setMediaUrl(entity.getPicture());
                projectItem.setBackers(IOTDataEntitySet.size());
                projectItem.setProjectOwner(entity.getProjectOwner());
                projectItem.setStatus(entity.getStatus());
             
                
                
                double counter = 0.0;
                double first = 0.0;
                double last = 0.0;
                double m = -0.1625;
                double c = 1.1124;
                
                // IOTDatad and percentage
                for (IOTDataEntity iOTDataEntity : IOTDataEntitySet){
            	if (first == 0.0)
            	{
            		first = iOTDataEntity.getAmount(); 		
            	}
            	last = iOTDataEntity.getAmount(); 
                	
                
                if (iOTDataEntity.getAmount() > 0)
                {
                	projectItem.setNewpoints((double)iOTDataEntity.getAmount());
                }
            	counter++;
                }

                
                double firstGrav = (m*first)+c;
                double lastGrav = (m*last)+c;
                projectItem.setDaysRemaining(firstGrav, lastGrav, counter);
                projectItem.setFinalGoalPercentage((firstGrav - projectItem.getProjectGoal())* 131.25);
                projectItem.setGoalPercentage((int)((30*(counter-1))/(projectItem.getDaysRemaining()*60)*100));       
                projectItems.add(projectItem);
				
			}
			
			
		}
		
		return projectItems;
		
		
	}
	
	@Transactional
	public void updateCredit(double amount, int id)
	{
		userRepo.updateCreditById(amount, id);
		
		System.out.println(amount + id);
		
		
	}
	
	@Transactional
	public void addProject(ProjectEntity pe){
		
		pe.setStatus(true);
		pe.setIOTDatas(null);
		projectRepo.save(pe);
	}
	
	@Transactional
	public void addIOTData(IOTDataEntity newIOTData) {
		newIOTData.setPermanent(false);
		IOTDataRepo.save(newIOTData);
		
	}

	@Transactional
	public void updateDescription(String description, Integer id) {
		// TODO Auto-generated method stub
		projectRepo.updateDescription(description, id);
	}
}
