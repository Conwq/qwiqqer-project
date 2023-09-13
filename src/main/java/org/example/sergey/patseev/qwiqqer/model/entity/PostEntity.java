package org.example.sergey.patseev.qwiqqer.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long postId;
	@Column(name = "brief")
	private String brief;
	@Column(name = "content")
	private String content;
}
