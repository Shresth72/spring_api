package com.spring.quiz_service.service;

import com.spring.quiz_service.model.Question;
import com.spring.quiz_service.model.QuestionWrapper;
import com.spring.quiz_service.model.Quiz;
import com.spring.quiz_service.model.Response;
import com.spring.quiz_service.repository.QuestionRepository;
import com.spring.quiz_service.repository.QuizRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

  @Autowired private QuizRepository quizRepository;
  @Autowired private QuestionRepository questionRepository;

  public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
    List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);

    Quiz quiz = new Quiz();
    quiz.setTitle(title);
    quiz.setQuestions(questions);
    quizRepository.save(quiz);

    return new ResponseEntity<>("Success", HttpStatus.CREATED);
  }

  public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
    Optional<Quiz> quiz = quizRepository.findById(id);
    List<Question> questionsFromDB = quiz.get().getQuestions();
    List<QuestionWrapper> questionsForUser = new ArrayList<>();

    for (Question q : questionsFromDB) {
      QuestionWrapper qw =
          new QuestionWrapper(
              q.getId(),
              q.getQuestionTitle(),
              q.getOption1(),
              q.getOption2(),
              q.getOption3(),
              q.getOption4());
      questionsForUser.add(qw);
    }

    return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
  }

  public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
    Quiz quiz = quizRepository.findById(id).get();
    List<Question> questions = quiz.getQuestions();

    int right = 0;
    int i = 0;

    for (Response response : responses) {
      if (response.getResponse().equals(questions.get(i).getRightAnswer())) right++;

      i++;
    }
    return new ResponseEntity<>(right, HttpStatus.OK);
  }
}
