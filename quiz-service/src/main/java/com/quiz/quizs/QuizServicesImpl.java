package com.quiz.quizs;

import com.quiz.question.QuestionClient;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServicesImpl implements QuizServices {

  @Autowired
  private QuizRepository quizRepository;

  @Autowired
  private QuestionClient questionClient;

  @Override
  public Quiz add(Quiz quiz) {
    return quizRepository.save(quiz);
  }

  @Override
  public List<Quiz> quizes() {
    List<Quiz> quizzes = quizRepository.findAll();

    List<Quiz> newQuizeList = quizzes
      .stream()
      .map(quiz -> {
        quiz.setQuestion(questionClient.getQuestions(quiz.getId()));
        return quiz;
      })
      .collect(Collectors.toList());

    return newQuizeList;
  }

  @Override
  public Quiz get(Long id) {
    // return
    Quiz quiz = quizRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
    quiz.setQuestion(questionClient.getQuestions(quiz.getId()));
    return quiz;
  }
}
