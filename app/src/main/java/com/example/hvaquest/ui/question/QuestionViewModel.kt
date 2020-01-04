package com.example.hvaquest.ui.question

import androidx.lifecycle.ViewModel
import com.example.hvaquest.model.QuestRepository
import com.example.hvaquest.model.Question

class QuestionViewModel : ViewModel() {

    private val questRepository = QuestRepository()
    var questionIndex: Int = 0

    fun isAnswerCorrect(answer: String): Boolean = answer == getQuestion().correctAnswer

    fun getClue(): Int = getQuestion().clue

    fun incrementQuestion() = questionIndex++

    fun decrementQuestion() = questionIndex--

    fun getQuestions() = questRepository.getHvaQuest()

    fun getQuestion(): Question = getQuestions()[questionIndex]

    fun resetQuestionIndex() {
        questionIndex = 0
    }
}