package com.android.example.develhope_android2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.android.example.develhope_android2.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val input = binding.editText.text.toString()
            val increment = input.toIntOrNull() ?: 0

            GlobalScope.launch {
                delay(2000)
                currentValue += increment

                withContext(Dispatchers.Main) {
                    binding.textView.text = currentValue.toString()
                }
            }
        }
    }
}

