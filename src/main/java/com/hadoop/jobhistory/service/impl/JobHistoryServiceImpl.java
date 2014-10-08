package com.hadoop.jobhistory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hadoop.jobhistory.dao.JobHistoryDAO;
import com.hadoop.jobhistory.model.JobHistory;
import com.hadoop.jobhistory.service.JobHistoryService;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {
	
	private JobHistoryDAO jobHistoryDAO;

	public void setJobHistoryDAO(JobHistoryDAO jobHistoryDAO) {
		this.jobHistoryDAO = jobHistoryDAO;
	}

	@Override
	@Transactional
	public void addJobHistory(JobHistory jh) {
		this.jobHistoryDAO.addJobHistory(jh);
	}

	@Override
	@Transactional
	public void updateJobHistory(JobHistory jh) {
		this.jobHistoryDAO.updateJobHistory(jh);
	}

	@Override
	@Transactional
	public List<JobHistory> listJobHistories() {
		return this.jobHistoryDAO.listJobHistories();
	}

	@Override
	@Transactional
	public JobHistory getJobHistoryById(int id) {
		return this.jobHistoryDAO.getJobHistoryById(id);
	}

	@Override
	@Transactional
	public void removeJobHistory(int id) {
		this.jobHistoryDAO.removeJobHistory(id);
	}

}
