package org.example.sergey.patseev.qwiqqer.controller;

import lombok.RequiredArgsConstructor;
import org.example.sergey.patseev.qwiqqer.model.dto.PostResponse;
import org.example.sergey.patseev.qwiqqer.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	@GetMapping
	public String getPosts(Model model){
		model.addAttribute("posts", postService.getPosts());
		return "#";
	}

	@GetMapping("/{postId}")
	public String getPostById(@PathVariable("postId") int postId,
							  Model model){
		PostResponse postResponse = postService.getPostById(postId);
		model.addAttribute("post", postResponse);
		return "#";
	}

	@GetMapping("/addition-form")
	public String getAddPostForm(Model model){
		model.addAttribute("post", new PostResponse());
		return "#";
	}

	@PostMapping
	public String addPost(@RequestParam PostResponse postResponse){
		postService.addPost(postResponse);
		return "redirect:/api/post";
	}

	@GetMapping("/{postId}/edit")
	public String getUpdatePostForm(@PathVariable("postId") int postId,
									Model model){
		PostResponse postResponse = postService.getPostById(postId);
		model.addAttribute("post", postResponse);
		return "#";
	}

	@PutMapping("/{postId}/edit")
	public String updatePost(@PathVariable("postId") long postId,
							 @RequestParam PostResponse postResponse){
		postService.updatePost(postId, postResponse);
		return "redirect:/api/post";
	}

	@DeleteMapping("/{postId}")
	public String deletePostById(@PathVariable("postId") long postId) {
		postService.deletePostById(postId);
		return "redirect:/api/post";
	}
}
