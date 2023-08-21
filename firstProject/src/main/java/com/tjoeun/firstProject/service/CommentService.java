package com.tjoeun.firstProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.firstProject.dto.CommentDto;
import com.tjoeun.firstProject.entity.Article;
import com.tjoeun.firstProject.entity.Comment;
import com.tjoeun.firstProject.repository.ArticleRepository;
import com.tjoeun.firstProject.repository.CommentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentService {

//	ArticleRepository와 CommentRepository의 메소드를 사용하기 위해 ArticleRepository와 CommentRepository의
//	bean을 가져온다.
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CommentRepository commentRepository;
	
//	댓글 목록 조회 - ID
	public List<CommentDto> comments(Long articleId) {
		log.info("CommentService의 comments() 메소드 실행");
		/*
		// log.info("articleId: " + articleId);
		List<Comment> comments = commentRepository.findByArticleId(articleId);
		// log.info("comments: " + comments);
		// entity를 dto로 변환
		List<CommentDto> dtos = new ArrayList<CommentDto>();
		for (int i=0; i<comments.size(); i++) {
			Comment comment = comments.get(i);
			// entity를 dto로 변환하는 메소드를 호출한다.
			CommentDto dto = CommentDto.createCommentDto(comment);
			dtos.add(dto);
		}
		// 반환
		return dtos;
		*/
		
		// stream 사용
		return commentRepository.findByArticleId(articleId)
				.stream()
				.map(comment -> CommentDto.createCommentDto(comment))
				.collect(Collectors.toList());
	}
	
//	댓글 목록 조회 - nickname
	public List<CommentDto> nickname(String nickname) {
		log.info("CommentService의 nickname() 메소드 실행");
		// log.info("nickname: " + nickname);
		List<Comment> comments = commentRepository.findByNickname(nickname);
		// log.info("comments: " + comments);
		// entity를 dto로 변환
		List<CommentDto> dtos = new ArrayList<CommentDto>();
		for (int i=0; i<comments.size(); i++) {
			Comment comment = comments.get(i);
			CommentDto dto = CommentDto.createCommentDto(comment);
			dtos.add(dto);
		}
		return dtos;
	}

//	댓글 생성
//	댓글 생성에 실패하면 실행 전 상태로 되돌려야 하므로 트랜잭션 처리를 해야 한다.
	@Transactional
	public CommentDto create(Long articleId, CommentDto dto) {
		log.info("CommentService의 create() 메소드 실행");
		// log.info("articleId: {}, dto: {}", articleId, dto);
		// 댓글을 저장하려는 메인글이 있으면 얻어오고 없으면 예외를 발생시킨다.
		Article article = articleRepository.findById(articleId)
				.orElseThrow(() -> 
					new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다."));
		// 댓글 엔티티 생성
		// dto를 entity로 변환하는 메소드를 호출한다.
		Comment comment = Comment.createComment(dto, article);
		// 댓글 entity를 저장
		Comment created = commentRepository.save(comment);
		// dto로 변환해서 반환
		return CommentDto.createCommentDto(created);
	}

}















