package com.spring.question_service.controller;

import com.spring.question_service.model.Question;
import com.spring.question_service.model.QuestionWrapper;
import com.spring.question_service.model.Response;
import com.spring.question_service.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {

  @Autowired QuestionService questionService;

  @GetMapping("allQuestions")
  public ResponseEntity<List<Question>> getAllQuestions() {
    return questionService.getAllQuestions();
  }

  @GetMapping("category/{category}")
  public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
    return questionService.getQuestionsByCategory(category);
  }

  @PostMapping("add")
  public ResponseEntity<String> addQuestion(@RequestBody Question question) {
    return questionService.addQuestion(question);
  }

  @GetMapping("generate")
  public ResponseEntity<List<Integer>> getQuestionsForQuiz(
      @RequestPart String categoryName, @RequestParam Integer numQ) {
    return questionService.getQuestionsForQuiz(categoryName, numQ);
  }

  @GetMapping("getQuestions")
  public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(
      @RequestBody List<Integer> questionIds) {
    return questionService.getQuestionsFromId(questionIds);
  }

  @GetMapping("getScore")
  public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
    return questionService.getScore(responses);
  }
}
