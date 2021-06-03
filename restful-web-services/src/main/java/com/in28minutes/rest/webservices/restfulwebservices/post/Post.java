package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.util.Date;

public class Post {

	
	private Integer postId;
	
	private Integer userId;
	
	private Date postedDate;
	
	private String postContent;
	
	public Post(int postId, int userId, Date postedDate, String postContent) {
		// TODO Auto-generated constructor stub
		this.postId=postId;
		this.userId=userId;
		this.postedDate=postedDate;
		this.postContent=postContent;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	
	
	
}
