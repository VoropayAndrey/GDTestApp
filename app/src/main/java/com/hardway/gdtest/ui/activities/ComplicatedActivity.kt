package com.hardway.gdtest.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.hardway.gdtest.R
import com.hardway.gdtest.ui.viewmodels.ComplicatedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_complicated.*

@AndroidEntryPoint
class ComplicatedActivity : AppCompatActivity() {

    val viewModel: ComplicatedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complicated)

        viewModel.complicatedAlgorithmResult.observe(this, Observer {
            resultTextValue.text = it.toString()
        })

        runButton.setOnClickListener {
            viewModel.runComplicatedAlgorithm()
        }
    }
}