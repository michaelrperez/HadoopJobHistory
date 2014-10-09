package com.hadoop.jobhistory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mperez
 *
 */
@Entity
@Table(name="mr_job_history_dev")
public class JobHistory {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
//	@Column(name="job_name")
//	private String jobname;
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
//	/**
//	 * @return the jobname
//	 */
//	public String getJobname() {
//		return jobname;
//	}
//	/**
//	 * @param jobname the jobname to set
//	 */
//	public void setJobname(String jobname) {
//		this.jobname = jobname;
//	}
	
	
	
	
	
	
	
}
