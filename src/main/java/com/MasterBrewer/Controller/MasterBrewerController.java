package com.MasterBrewer.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.MasterBrewer.Entities.IOTDataEntity;
import com.MasterBrewer.Entities.ProjectEntity;
import com.MasterBrewer.Entities.UserEntity;
import com.MasterBrewer.Forms.PageContext;
import com.MasterBrewer.Service.ProjectService;

@Controller
@SessionAttributes(value={"user","context"})
public class MasterBrewerController {

    private PageContext pageContext = new PageContext();
    private boolean loggedUser = false;

    @Autowired
    private ProjectService projectsRepository;


    @RequestMapping(value = "/")
    public String index(Model model){
    	    
    	if(!loggedUser){
            if(!model.containsAttribute("user"))
            	model.addAttribute("user", new UserEntity());
            return "login";
    	}
    		
        // Sets the login status
        // False: login page is shown (regardless of the setContainerFragment)
        pageContext.setLoggedIn(loggedUser);

        // Gets the project items and puts it in the context
        //pageContext.setProjectEntities(projectsRepository.getProjectViewItems());
        
        // Sets the page fragment to display
       
        
        pageContext.setProjectEntities(projectsRepository.getProjectsByUser(pageContext.getUserEntity().getId()));
		pageContext.setContainerFragment("my_projects");
        //pageContext.setContainerFragment("project_listing");

        // Finally add the page context
        model.addAttribute("context", pageContext);
        
        return "index";
    }
    
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(Model model,@ModelAttribute UserEntity user){
    	
    	UserEntity users = projectsRepository.findByUname(user.getUname());
		if(users != null){
			pageContext.setUserEntity(users);
			loggedUser = true;
		}
		//loggedUser = true;
		//pageContext.setUserEntity(users);
    	
    	return "redirect:/";
    }
	
	@RequestMapping(value="/myProjects")
	public String myProjects(Model model) {
		
		pageContext.setProjectEntities(projectsRepository.getProjectsByUser(pageContext.getUserEntity().getId()));
		pageContext.setContainerFragment("my_projects");
		return "index";
	}
	@RequestMapping(value="/add")
	public String displayAddProject(Model model){
		model.addAttribute("newProject",new ProjectEntity());
		return "addProject";
	}
	
	@RequestMapping(value="/newProject",method=RequestMethod.GET)
	public String addProject(Model model, @ModelAttribute ProjectEntity newProject)
	{
		newProject.setPowner(pageContext.getUserEntity().getId());
		projectsRepository.addProject(newProject);
		return "redirect:/";
	}
	
	@RequestMapping(value="/IOTData{title}",method=RequestMethod.GET)
	public String displayAddIOTData(Model model,@RequestParam String title){
		pageContext.setProjectEntities(projectsRepository.getProjectsByTitle(title));
		model.addAttribute("newIOTData",new IOTDataEntity());
		ProjectEntity pe = new ProjectEntity();
		pe.setProjectOwner(pageContext.getProjectEntities().iterator().next().getProjectOwner());
		model.addAttribute("project", pe);
		
		pageContext.setContainerFragment("project_listing");
		return "addIOTData";
	}
	
	@RequestMapping(value="/newIOTData",method=RequestMethod.GET)
	public String AddIOTData(Model model, @ModelAttribute IOTDataEntity newIOTData)
	{
		
			newIOTData.setPowner(pageContext.getUserEntity().getId());
			newIOTData.setTarget(projectsRepository.findId(pageContext.getProjectEntities().iterator().next().getTitle()));
			projectsRepository.addIOTData(newIOTData);
			pageContext.setUserEntity(projectsRepository.findByUname(pageContext.getUserEntity().getUname()));

		return "redirect:/";
		
	}
	
	@RequestMapping(value="/addReading",method=RequestMethod.POST)
	public String addReading(Model model, @ModelAttribute IOTDataEntity newIOTData)
	{
		//IOTData_id, IOTData_OWNER_ID, TARGET_ID, AMOUNT, PERMANENT
		//newIOTData.set
		projectsRepository.addIOTData(newIOTData);
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/addDescription",method=RequestMethod.POST)
	public String updDescription(Model model, @ModelAttribute ProjectEntity projects)
	{
		
		projectsRepository.updateDescription(projects.getDescription(), pageContext.getUserEntity().getId());
		return "redirect:/";
	
	
	}
	
	
	@RequestMapping(value = "/logout")
	public String logout(Model model, WebRequest request, SessionStatus status) {

	    status.setComplete();
	    request.removeAttribute("context", WebRequest.SCOPE_SESSION);
	    pageContext.setUserEntity(null);
	    loggedUser = false;
	    return "redirect:/";
	}
	
	@RequestMapping(value="/close")
	public String closeProject(Model model){
		//TODO: differentiate between which item was clicked
		
		return "redirect:#";
	}
	
	@RequestMapping(value = "message", method = RequestMethod.GET)
    public String messages(Model model) {
            model.addAttribute("message", "hello");
            return "index";
    }
	/*
	@RestController
	@RequestMapping("/real-time-data")
	public class RealTimeDataResource {

	    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> getData() {
	        return ResponseEntity.ok(new ChartDataDto(System.currentTimeMillis(), new Random().nextInt(100)));
	    }
	}*/
	
}
