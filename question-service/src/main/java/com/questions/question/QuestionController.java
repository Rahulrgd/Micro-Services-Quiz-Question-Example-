package com.questions.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionServicesImpl questionServicesImpl;

    @GetMapping
    public List<Question> questions(){
        return questionServicesImpl.questions();
    }

    @GetMapping("/{id}")
    public Question getOne(@PathVariable Long id){
        return questionServicesImpl.get(id);
    }

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionServicesImpl.create(question);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOFQuiz(@PathVariable Long quizId){
        return questionServicesImpl.getQuestionsOfQuiz(quizId);
    }
}
