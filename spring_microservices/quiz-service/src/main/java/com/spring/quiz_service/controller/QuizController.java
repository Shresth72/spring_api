package com.spring.quiz_service.controller;

import com.spring.quiz_service.dto.QuizDto;
import com.spring.quiz_service.model.QuestionWrapper;
import com.spring.quiz_service.model.Response;
import com.spring.quiz_service.service.QuizService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {

  @Autowired private QuizService quizService;

  @GetMapping("create")
  public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
    return quizService.createQuiz(
        quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
  }

  @PostMapping("get/{id}")
  public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
    return quizService.getQuizQuestions(id);
  }

  @PostMapping("submit/{id}")
  public ResponseEntity<Integer> submitQuiz(
      @PathVariable Integer id, @RequestBody List<Response> responses) {
    return quizService.calculateResult(id, responses);
  }
}
