package com.tjoeun.firstProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tjoeun.firstProject.entity.Article;
import com.tjoeun.firstProject.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentDto {

	private Long id;
	private String nickname;
	private String body;
//	json 데이터의 key와 dto 객체의 필드 이름이 다르면 데이터를 넘겨받지 못하기 때문에
//	@JsonProperty를 사용하여 필드 이름을 맞춰줘야 한다.
	@JsonProperty("article_id")
	private Long articleId;
	
//	entity를 dto로 변환하는 메소드
	public static CommentDto createCommentDto(Comment comment) {
		return new CommentDto(comment.getId(), comment.getNickname(), comment.getBody(), comment.getArticle().getId());
	}
	
	
}










