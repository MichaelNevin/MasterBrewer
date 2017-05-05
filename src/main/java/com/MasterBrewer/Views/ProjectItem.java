package com.MasterBrewer.Views;


import java.util.ArrayList;
import java.util.Collections;

import com.MasterBrewer.Entities.UserEntity;

public class ProjectItem {

    private String title;
    private String description;
    private String mediaUrl;
    private Integer backers;
    private Integer goalPercentage;
    private double daysRemaining;
    private UserEntity projectOwner;
    private double projectGoal;
    private double IOTDatad;
    private boolean status;
    private double FinalGoalPercentage;
    
    double m = -0.1625;
    double c = 1.1124;
    
    public double getFinalGoalPercentage() {
    	double FinalGoalPercentageRound = FinalGoalPercentage;
    	FinalGoalPercentageRound = FinalGoalPercentageRound*100;
    	FinalGoalPercentageRound = Math.round(FinalGoalPercentageRound);
    	FinalGoalPercentageRound = FinalGoalPercentageRound /100;
		return FinalGoalPercentageRound;
	}

	public void setFinalGoalPercentage(double finalGoalPercentage) {
		FinalGoalPercentage = finalGoalPercentage;
	}

	//private double[] Newpoints = {};
    ArrayList<Double> Newpoints = new ArrayList<Double>();
    
   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Integer getBackers() {
        return backers;
    }

    public void setBackers(Integer backers) {
        this.backers = backers;
    }

    public Integer getGoalPercentage() {
        return goalPercentage;
    }

    public void setGoalPercentage(Integer goalPercentage) {
        this.goalPercentage = goalPercentage;
    }

    public double getDaysRemaining() {
        return daysRemaining;
    }

    public void setDaysRemaining(double first, double last, double counter) {
    	double timeDelay = first - last;
    	double remainingHours = 0.0;
    	if (counter-1 > 0)
    		{
    			remainingHours = ((last - projectGoal) / timeDelay) * (30 * (counter-1)) / 60;
    		}
   
    	remainingHours = remainingHours*100;
    	remainingHours = Math.round(remainingHours);
    	remainingHours = remainingHours /100;
    	
        this.daysRemaining = remainingHours;
    }

    public UserEntity getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(UserEntity projectOwner) {
        this.projectOwner = projectOwner;
    }

    public double getProjectGoal() {
        return projectGoal;
    }

    public void setProjectGoal(double projectGoal) {
        this.projectGoal = projectGoal;
    }

    public double getIOTDatad() {
        return IOTDatad;
    }

    public void setIOTDatad(double IOTDatad) {
        this.IOTDatad = IOTDatad;
    }
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProjectItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", backers=" + backers +
                ", goalPercentage=" + goalPercentage +
                ", daysRemaining=" + daysRemaining +
                ", projectOwner=" + projectOwner +
                ", projectGoal=" + projectGoal +
                ", IOTDatad=" + IOTDatad +
                '}';
    }

	public ArrayList<Double> getNewpoints() {
		double FirstGravity =0.0;
		double thisGravity = 0.0;
		for (int i = 0; i < Newpoints.size(); i++) {
			
			double x = Newpoints.get(i);
			double finalPercentage = 0.0;
	
			if(i==0){
				FirstGravity = ((m * x) + c);
				//setFinalGoalPercentage((FirstGravity - this.projectGoal)*131.25);
				Newpoints.set( i, 0.0);
			}
			else{
				thisGravity = ((m * x) + c);
				double currentPercentage = ((FirstGravity - thisGravity)* 131.25);
				Newpoints.set( i, currentPercentage);
			}
	
		}
		Collections.sort(Newpoints);
		return Newpoints;
	}

	public void setNewpoints(double double1) {
		this.Newpoints.add(double1);
	}

	
}
