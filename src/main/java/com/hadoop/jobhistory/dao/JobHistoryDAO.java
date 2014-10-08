package com.hadoop.jobhistory.dao;

import java.util.List;
import com.hadoop.jobhistory.model.JobHistory;

public interface JobHistoryDAO {

	public void addJobHistory(JobHistory jh);
	public void updateJobHistory(JobHistory jh);
	public List<JobHistory> listJobHistories();
	public JobHistory getJobHistoryById(int id);
	public void removeJobHistory(int id);
}
