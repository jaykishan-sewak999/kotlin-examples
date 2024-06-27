package com.example.kotlinexamples.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.kotlinexamples.R
import com.example.kotlinexamples.databinding.ActivityFlowExampleBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlowExampleBinding
    private lateinit var flowViewModel: FlowViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        flowViewModel = ViewModelProvider(this).get(FlowViewModel::class.java)

        // Listen for the button click event to search
        binding.button.setOnClickListener {

            // check to prevent api call with no parameters
            if (binding.searchEditText.text.isNullOrEmpty()) {
                Toast.makeText(this, "Query Can't be empty", Toast.LENGTH_SHORT).show()
            } else {
                // if Query isn't empty, make the api call
                flowViewModel.getComments(binding.searchEditText.text.toString().toInt())
            }
        }

        lifecycleScope.launch {
            flowViewModel.apiResults.collect {
                when (it.status) {
                    Status.LOADING -> {
                        binding.progressBar.isVisible = true
                        Log.i("asdasd","adasd");
                    }
                    Status.SUCCESS -> {
                        it.data?.let { comment ->
                            binding.commentIdTextview.text = comment.id.toString()
                            binding.nameTextview.text = comment.name
                            binding.emailTextview.text = comment.email
                            binding.commentTextview.text = comment.comment
                        }
                        binding.progressBar.isVisible = false
                    }
                    Status.ERROR -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(this@FlowExampleActivity, "${it.message}", Toast.LENGTH_SHORT).show()
                    }
                    Status.NONE -> {

                    }
                }
            }
        }

    }
}