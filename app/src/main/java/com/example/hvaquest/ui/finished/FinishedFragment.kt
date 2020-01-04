package com.example.hvaquest.ui.finished


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.hvaquest.R
import com.example.hvaquest.ui.question.QuestionViewModel
import kotlinx.android.synthetic.main.fragment_quest_finished.*

/**
 * Finished the quest, time for cake!
 */
class FinishedFragment : Fragment() {

    private lateinit var viewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize the Shared Activity ViewModel
        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuestionViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quest_finished, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.incrementQuestion()

        btnFinish.setOnClickListener {
            findNavController().navigate(R.id.action_questCompletedFragment_to_homeFragment)
        }
    }
}
