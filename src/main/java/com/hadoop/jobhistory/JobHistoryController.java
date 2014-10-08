package com.hadoop.jobhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hadoop.jobhistory.model.JobHistory;
import com.hadoop.jobhistory.service.JobHistoryService;

@Controller
public class JobHistoryController {
	
	private JobHistoryService jobHistoryService;
	
	@Autowired(required=true)
	@Qualifier(value="jobHistoryService")
	public void setjobHistoryService(JobHistoryService jhs){
		this.jobHistoryService = jhs;
	}
	
	@RequestMapping(value = "/jobHistory", method = RequestMethod.GET)
	public String listJobHistories(Model model) {
		model.addAttribute("jobHistory", new JobHistory());
		model.addAttribute("listJobHistories", this.jobHistoryService.listJobHistories());
		return "jobHistory";
	}
	
	//For add and update job history both
	@RequestMapping(value= "/jobHistory/add", method = RequestMethod.POST)
	public String addJobHistory(@ModelAttribute("jobHistory") JobHistory jh){
		
		if(jh.getId() == 0){
			//new Job History, add it
			this.jobHistoryService.addJobHistory(jh);
		}else{
			//existing Job History, call update
			this.jobHistoryService.updateJobHistory(jh);
		}
		
		return "redirect:/jobhistories";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeJobHistory(@PathVariable("id") int id){
		
        this.jobHistoryService.removeJobHistory(id);
        return "redirect:/jobhistories";
    }
 
    @RequestMapping("/edit/{id}")
    public String editJobHistory(@PathVariable("id") int id, Model model){
        model.addAttribute("jobHistory", this.jobHistoryService.getJobHistoryById(id));
        model.addAttribute("listJobHistories", this.jobHistoryService.listJobHistories());
        return "jobhistories";
    }
	
}
