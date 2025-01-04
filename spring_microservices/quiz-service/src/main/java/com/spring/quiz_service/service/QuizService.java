package com.spring.quiz_service.service;

import com.spring.quiz_service.feign.QuizInterface;
import com.spring.quiz_service.model.QuestionWrapper;
import com.spring.quiz_service.model.Quiz;
import com.spring.quiz_service.model.Response;
import com.spring.quiz_service.repository.QuizRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

  @Autowired private QuizRepository quizRepository;
  @Autowired private QuizInterface quizInterface;

  public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
    List<Integer> questionsIds = quizInterface.getQuestionsForQuiz(category, numQ).getBody();

    Quiz quiz = new Quiz();
    quiz.setTitle(title);
    quiz.setQuestionsIds(questionsIds);
    quizRepository.save(quiz);

    return new ResponseEntity<>("Success", HttpStatus.CREATED);
  }

  public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
    Quiz quiz = quizRepository.findById(quizId).get();
    List<Integer> questionsIds = quiz.getQuestionsIds();

    List<QuestionWrapper> questionsForUser =
        quizInterface.getQuestionsFromId(questionsIds).getBody();

    return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
  }

  public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
    Integer right = quizInterface.getScore(responses).getBody();

    return new ResponseEntity<>(right, HttpStatus.OK);
  }
}
