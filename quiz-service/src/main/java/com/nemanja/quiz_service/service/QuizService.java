package com.nemanja.quiz_service.service;

import com.nemanja.quiz_service.dao.QuizDao;
import com.nemanja.quiz_service.model.QuestionWrapper;
import com.nemanja.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
//    @Autowired
//    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
//
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//
//        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

//        for(Question q : questionsFromDB) {
//            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),
//                    q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//            questionsForUser.add(qw);
//        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> caculateResult(Integer id, List<Response> responses) {
//        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Question> questions = quiz.get().getQuestions();
        int score = 0;
//        int i = 0;
//
//        for (Response r : responses) {
//            if(r.getResponse().equals(questions.get(i).getRightAnswer()))
//                score++;
//            i++;
//        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
