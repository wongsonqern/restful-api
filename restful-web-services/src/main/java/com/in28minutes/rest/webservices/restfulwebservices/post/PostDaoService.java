package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
	
	private static List<Post> usersPostList= new ArrayList<>(); 
	private static int postCountId = 3;
	
	static {
		
		usersPostList.add(new Post(1,1, new Date(), "new first post"));
		usersPostList.add(new Post(1,2, new Date(), "userid 2 "));
		usersPostList.add(new Post(1,3, new Date(), "userid 3 post "));
	}
	public List<Post> retrieveAllPostsByUser(Integer userId){
		
		List<Post> userPostList= new ArrayList<>(); 
		
		 for(Post userPost: usersPostList)
		 {
			 if(userPost.getUserId() == userId)
			 userPostList.add(userPost);
			 
		 }
		return userPostList;
	}
	
	public Post retrieveDetailofPost(Integer postId){
		
		Post post = null;
		
		for(Post userPost: usersPostList)
		 {
			if(userPost.getPostId() == postId)
			post = userPost;
		 }
		return post;
	}
	
	public Post  createPostByUser(Post post) {
		
		post.setPostId(++postCountId);
		
		usersPostList.add(post);
		
		return post;
	
	}
}
