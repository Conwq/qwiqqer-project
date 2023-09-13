package org.example.sergey.patseev.qwiqqer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.sergey.patseev.qwiqqer.model.dto.PostResponse;
import org.example.sergey.patseev.qwiqqer.model.entity.PostEntity;
import org.example.sergey.patseev.qwiqqer.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
	private final PostRepository postRepository;

	@Transactional(readOnly = true)
	public List<PostResponse> getPosts(){
		List<PostEntity> postEntity = postRepository.getPosts();

		return postEntity.stream()
				.map(entity -> PostResponse.builder()
						.brief(entity.getBrief())
						.content(entity.getContent())
						.build())
				.toList();
	}

	@Transactional(readOnly = true)
	public PostResponse getPostById(int postId){
		PostEntity postEntity = postRepository.getPostById(postId);

		return PostResponse.builder()
				.brief(postEntity.getBrief())
				.content(postEntity.getContent())
				.build();
	}

	@Transactional
	public void addPost(PostResponse postResponse){
		PostEntity postEntity = PostEntity.builder()
				.brief(postResponse.getBrief())
				.content(postResponse.getContent())
				.build();
		postRepository.addPost(postEntity);
		log.info("Post add in DB");
	}

	@Transactional
	public void updatePost(long postId, PostResponse postResponse) {
		PostEntity postEntity = PostEntity.builder()
				.postId(postId)
				.brief(postResponse.getBrief())
				.content(postResponse.getContent())
				.build();
		postRepository.addPost(postEntity);
		log.info("Post with id {} was updated", postId);
	}

	@Transactional
	public void deletePostById(long postId) {
		postRepository.deleteById(postId);
		log.info("Post with id {} was delete", postId);
	}
}
