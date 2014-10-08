package com.hadoop.jobhistory.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hadoop.jobhistory.dao.JobHistoryDAO;
import com.hadoop.jobhistory.model.JobHistory;

@Repository
public class JobHistoryDAOImpl implements JobHistoryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(JobHistoryDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addJobHistory(JobHistory jh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(jh);
		logger.info("Job History saved successfully, Job History Details="+jh);
	}

	@Override
	public void updateJobHistory(JobHistory jh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(jh);
		logger.info("Job History updated successfully, Job History Details="+jh);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobHistory> listJobHistories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<JobHistory> jobHistoryList = session.createQuery("from JobHistory").list();
		for(JobHistory jh : jobHistoryList){
			logger.info("Job History List::"+jh);
		}
		return jobHistoryList;
	}

	@Override
	public JobHistory getJobHistoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		JobHistory jh = (JobHistory) session.load(JobHistory.class, new Integer(id));
		logger.info("Job History loaded successfully, Job History details="+jh);
		return jh;
	}

	@Override
	public void removeJobHistory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		JobHistory jh = (JobHistory) session.load(JobHistory.class, new Integer(id));
		if(null != jh){
			session.delete(jh);
		}
		logger.info("Job History deleted successfully, Job History details="+jh);
	}

}
