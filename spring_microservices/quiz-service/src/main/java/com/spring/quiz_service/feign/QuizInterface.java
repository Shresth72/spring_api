package com.spring.quiz_service.feign;

import com.spring.quiz_service.model.QuestionWrapper;
import com.spring.quiz_service.model.Response;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

  @GetMapping("question/generate")
  public ResponseEntity<List<Integer>> getQuestionsForQuiz(
      @RequestParam String categoryName, @RequestParam Integer numQ);

  @GetMapping("question/getQuestions")
  public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(
      @RequestBody List<Integer> questionIds);

  @GetMapping("question/getScore")
  public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
