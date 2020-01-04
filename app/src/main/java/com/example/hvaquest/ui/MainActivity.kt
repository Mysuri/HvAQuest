package com.example.hvaquest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.hvaquest.ui.question.QuestionViewModel
import com.example.hvaquest.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        initNavigation()
    }

    private fun initNavigation() {
        val navController = findNavController(R.id.navHostFragment)

        //navHostFragment connected to action bar
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return when (item?.itemId) {
            android.R.id.home -> {
                if(viewModel.questionIndex > 0) viewModel.decrementQuestion()
                navController.navigateUp()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
