package com.tjoeun.firstProject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tjoeun.firstProject.dto.CommentDto;
import com.tjoeun.firstProject.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CommentApiController {

//	CommentService의 메소드를 사용하기 위해서 CommentService 클래스의 bean을 가져온다.
	@Autowired
	private CommentService commentService;
	
//	댓글 목록 조회 - ID
//	Talend API Tester(GET) => http://localhost:9090/api/comments/4/comments
	@GetMapping("/api/comments/{articleId}/comments")
	public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
		log.info("CommentApiController의 comments() 메소드 실행");
		log.info("articleId: " + articleId);
		// 서비스에 위임
		List<CommentDto> dtos = commentService.comments(articleId);
		// 결과 응답
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
//	댓글 목록 조회 - nickname
//	Talend API Tester(GET) => http://localhost:9090/api/comments/4/comments	
	@GetMapping("/api/comments/{nickname}/nickname")
	public ResponseEntity<List<CommentDto>> nickname(@PathVariable String nickname) {
		log.info("CommentApiController의 nickname() 메소드 실행");
		// log.info("nickname: " + nickname);
		List<CommentDto> dtos = commentService.nickname(nickname);
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
//	댓글 생성
//	Talend API Tester(GET) => http://localhost:9090/api/comments/4/comments	
	@PostMapping("/api/comments/{articleId}/comments")
	public ResponseEntity<CommentDto> create(@PathVariable Long articleId, @RequestBody CommentDto dto) {
		// log.info("articleId: {}, dto: {}", articleId, dto);
		// 서비스로 위임
		CommentDto createDto = commentService.create(articleId, dto);
		// 결과 응답
		return ResponseEntity.status(HttpStatus.OK).body(createDto);
		
	}
	
	
}













