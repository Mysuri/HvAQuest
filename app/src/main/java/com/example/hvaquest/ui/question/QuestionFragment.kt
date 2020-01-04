package com.example.hvaquest.ui.question


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.hvaquest.R
import kotlinx.android.synthetic.main.fragment_question.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Init QuestionViewModel
        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuestionViewModel::class.java)

        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set the question
        tvQuestion.text = viewModel.getQuestion().question

        //Set the question counter
        tvQuestionNumber.text = ((viewModel.questionIndex + 1).toString() + "/" + viewModel.getQuestions().size)

        //Set text of answers in questions
        answer1.text = viewModel.getQuestion().choices[0]
        answer2.text = viewModel.getQuestion().choices[1]
        answer3.text = viewModel.getQuestion().choices[2]

        btnConfirm.setOnClickListener {
            val radioButton = view.findViewById<RadioButton>(rgAnswers.checkedRadioButtonId)

            if (viewModel.isAnswerCorrect(radioButton.text.toString())) {
                Toast.makeText(context, "Correct answer!", Toast.LENGTH_LONG).show()
                if ((viewModel.getQuestions().size - 1) == viewModel.questionIndex) findNavController().navigate(
                    R.id.action_questionFragment_to_questCompletedFragment
                ) else {
                    findNavController().navigate(R.id.action_questionFragment_to_clueFragment)
                }
            } else {
                Toast.makeText(context, "Incorrect answer! The correct answer was: ${viewModel.getQuestion().correctAnswer}", Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
