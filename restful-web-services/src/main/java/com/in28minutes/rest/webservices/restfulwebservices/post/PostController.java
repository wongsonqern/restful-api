package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PostController {

	@Autowired
	private PostDaoService postDaoService;
	
	@GetMapping(path="/users/{id}/posts")
	public List <Post> retrieveAllPostsByUser(@PathVariable Integer id)
	{
		List <Post> postList = postDaoService.retrieveAllPostsByUser(id);
		
		return postList;
	}
	
	@GetMapping(path="/users/{id}/posts/{post_id}")
	public Post retrieveDetailofPost(@PathVariable Integer id, @PathVariable Integer postId)
	{
		Post post = postDaoService.retrieveDetailofPost(postId);
		
		return post;
	}
	
	@PostMapping(path="/users/{id}/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post postWeb){
		
		
			Post post = postDaoService.createPostByUser(postWeb);
			Map <String, String> uriVariableMap = new HashMap <String, String>();
			uriVariableMap.put("id", post.getUserId().toString());
			uriVariableMap.put("post_id", post.getPostId().toString());
		
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}").buildAndExpand(uriVariableMap).toUri();
				
		
			return ResponseEntity.created(location).build();
		
	}
	
	
}
