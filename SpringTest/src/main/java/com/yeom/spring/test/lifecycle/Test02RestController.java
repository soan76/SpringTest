package com.yeom.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lifecycle/test02")
public class Test02RestController {
	
	@RequestMapping("/1")
	@ResponseBody
	public List<Map<String, Object>> movieData() {
		// rate: num, director: "", time: num, title: ""
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movie = new HashMap<String, Object>();
		movie.put("rate", 15);
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("title", "기생충");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 0);
		movie.put("director", "로베르트 베니니");
		movie.put("time", 116);
		movie.put("title", "인생은 아름다워");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 12);
		movie.put("director", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("title", "인셉션");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 19);
		movie.put("director", "윤종빈");
		movie.put("time", 133);
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("title", "헝거게임");
		movieList.add(movie);
		
		return movieList;
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<Board> boardList() {
		
		List<Board> boardList = new ArrayList<>();
		
		Board board = new Board("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요 가입했어요. 잘 부탁드립니다.");
		boardList.add(board);
		boardList.add(new Board("헐 대박", "bada", "오늘 목요일이었어, 금요일인줄"));
		boardList.add(new Board("오늘 데이트한 이야기 해드릴게요", "dulumary", "....."));
		
		return boardList;
	}
	
	@RequestMapping("/3")
	@ResponseBody
	public ResponseEntity<Board> boardError() {
		Board board = new Board("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요 가입했어요. 잘 부탁드립니다.");
		
		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
}
