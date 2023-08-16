package com.tjoeun.firstProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tjoeun.firstProject.dto.ArticleForm;
import com.tjoeun.firstProject.entity.Article;
import com.tjoeun.firstProject.repository.ArticleRepository;

@Controller
public class ArticleController {

//	JPA repository 인터페이스 객체를 선언하고 @Autowired 어노테이션으로 초기화한다.
	@Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동으로 연결한다.
	private ArticleRepository articleRepository;
	
	@GetMapping("/articles/new")
	public String newArticleForm() {
		return "articles/new";
	}
	
	@PostMapping("/articles/create")
//	form에서 넘어오는 데이터는 커맨드 객체로 받는다.
	public String createArticle(ArticleForm form) {
		System.out.println(form);
		// DTO의 데이터를 Entity로 변환한다.
		Article article = form.toEntity();
		System.out.println(article);
		// repository에게 entity를 데이터베이스에 저장하게 한다.
		// id가 자동으로 생성된다.
		Article saved = articleRepository.save(article);
		System.out.println(saved);
		return "articles/new";
	}
	
}














