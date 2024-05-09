package com.questions.question;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServicesImpl implements QuestionServices {

  @Autowired
  private QuestionRepository questionRepository;

  @Override
  public Question create(Question question) {
    return questionRepository.save(question);
  }

  @Override
  public List<Question> questions() {
    return questionRepository.findAll();
  }

  @Override
  public Question get(Long id) {
    return questionRepository
      .findById(id)
      .orElseThrow(() ->
        new RuntimeException("No Question found with id: " + id)
      );
  }

  @Override
  public List<Question> getQuestionsOfQuiz(Long quizId) {
    return questionRepository.findByQuizId(quizId);
  }
}
