package io.pangyanw.controller

import io.pangyanw.constant.QuestionConstants
import io.pangyanw.dto.Question
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@CrossOrigin(origins = [ "http://localhost:8080" ])
@RestController
class QuestionController {

    @GetMapping("question")
    fun getQuestion(): Question {
        QuestionConstants.BLANK;
        var blankPosition = Random.nextInt(0, 4);
        var questionParams = Array<Int>(5) {0};
        questionParams[0] = Random.nextInt(1, QuestionConstants.ADDEND_UPPER_BOUND);
        questionParams[1] = Random.nextInt(1, QuestionConstants.ADDEND_UPPER_BOUND);
        questionParams[2] = Random.nextInt(1, QuestionConstants.ADDEND_UPPER_BOUND);
        questionParams[3] = questionParams[0] + questionParams[1] + questionParams[2];
        questionParams[4] = questionParams[blankPosition];
        questionParams[blankPosition] = QuestionConstants.BLANK;

        var question = Question(questionParams[0], questionParams[1], questionParams[2], questionParams[3], questionParams[4]);
        return question;
    }
}