package com.quiz.quizs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

  @Autowired
  QuizServicesImpl quizServicesImpl;

  @GetMapping
  public List<Quiz> get() {
    return quizServicesImpl.quizes();
  }

  @GetMapping("/{id}")
  public Quiz getone(@PathVariable Long id){
    return quizServicesImpl.get(id);
  }

  @PostMapping
  public Quiz create(@RequestBody Quiz quiz){
    return quizServicesImpl.add(quiz);
  }
}
