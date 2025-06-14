package com.nemanja.question_service.service;

import com.nemanja.question_service.dao.QuestionDao;
import com.nemanja.question_service.model.Question;
import com.nemanja.question_service.model.QuestionWrapper;
import com.nemanja.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<Optional<Question>> updateQuestion(Question question) {
        try {
            if (questionDao.existsById(question.getId())) {
                Question updated = questionDao.save(question);
                return new ResponseEntity<>(Optional.of(updated), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try {
            if (questionDao.existsById(id)) {
                questionDao.deleteById(id);
                return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while deleting question", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(Integer id : questionsIds) {
            questions.add(questionDao.findById(id).get());
        }

        for(Question q : questions) {
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(q.getId());
            wrapper.setQuestionTitle(q.getQuestionTitle());
            wrapper.setOption1(q.getOption1());
            wrapper.setOption2(q.getOption2());
            wrapper.setOption3(q.getOption3());
            wrapper.setOption4(q.getOption4());

            wrappers.add(wrapper);
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int score = 0;

        for (Response r : responses) {
            Question question = questionDao.findById(r.getId()).get();
            if(r.getResponse().equals(question.getRightAnswer()))
                score++;
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
