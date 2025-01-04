package com.spring.quiz_service.service;

import com.spring.quiz_service.model.QuestionWrapper;
import com.spring.quiz_service.model.Response;
import com.spring.quiz_service.repository.QuizRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

  @Autowired private QuizRepository quizRepository;

  public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
    List<Integer> questionsIds = new ArrayList<Integer>();

    return new ResponseEntity<>("Success", HttpStatus.CREATED);
  }

  public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
    // Optional<Quiz> quiz = quizRepository.findById(id);
    // List<Question> questionsFromDB = quiz.get().getQuestions();
    List<QuestionWrapper> questionsForUser = new ArrayList<>();
    //
    // for (Question q : questionsFromDB) {
    //   QuestionWrapper qw =
    //       new QuestionWrapper(
    //           q.getId(),
    //           q.getQuestionTitle(),
    //           q.getOption1(),
    //           q.getOption2(),
    //           q.getOption3(),
    //           q.getOption4());
    //   questionsForUser.add(qw);
    // }

    return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
  }

  public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
    // Quiz quiz = quizRepository.findById(id).get();
    // List<Question> questions = quiz.getQuestions();

    int right = 0;
    // int i = 0;
    //
    // for (Response response : responses) {
    //   if (response.getResponse().equals(questions.get(i).getRightAnswer()))
    //   right++;
    //
    //   i++;
    // }
    return new ResponseEntity<>(right, HttpStatus.OK);
  }
}
