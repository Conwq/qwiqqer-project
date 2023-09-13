package org.example.sergey.patseev.qwiqqer.repository;

import lombok.RequiredArgsConstructor;
import org.example.sergey.patseev.qwiqqer.model.entity.PostEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
	private final SessionFactory sessionFactory;

	public List<PostEntity> getPosts(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM PostEntity", PostRepository.class);
		return query.getResultList();
	}

	public PostEntity getPostById(int postId){
		Session session = sessionFactory.getCurrentSession();
		return session.get(PostEntity.class, postId);
	}

	public void addPost(PostEntity postEntity){
		Session session = sessionFactory.getCurrentSession();
		session.save(postEntity);
	}

	public void deleteById(long postId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(postId);
	}
}
