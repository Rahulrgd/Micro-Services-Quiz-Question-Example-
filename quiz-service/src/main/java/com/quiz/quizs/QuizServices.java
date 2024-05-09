package com.quiz.quizs;

import java.util.List;

public interface QuizServices {
    Quiz add(Quiz quiz);
    List<Quiz> quizes ();
    Quiz get(Long id);
}
