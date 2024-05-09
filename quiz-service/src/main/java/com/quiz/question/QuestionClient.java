package com.quiz.question;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(url = "http://localhost:8082", value = "Question-Client")
// @FeignClient(name = "QUESTION-SERVICE", value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{id}")
    List<Question> getQuestions(@PathVariable Long id);
}
