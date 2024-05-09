package com.questions.question;

import java.util.List;

public interface QuestionServices {
    Question create(Question question);
    List<Question> questions();
    Question get(Long id);
    List<Question> getQuestionsOfQuiz(Long quizId);
}
