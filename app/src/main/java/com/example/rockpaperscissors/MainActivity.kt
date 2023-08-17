package com.example.rockpaperscissors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.rockpaperscissors.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var value1: String? = null
    var value2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rockPlayerOne.setOnClickListener {
            binding.rockPlayerOne.setBackgroundResource(R.drawable.background_image)
            value1 = "0"
            display()
            result()
        }

        binding.paperPlayerOne.setOnClickListener {
            binding.paperPlayerOne.setBackgroundResource(R.drawable.background_image)
            value1 = "1"
            display()
            result()
        }

        binding.scissorPlayerOne.setOnClickListener {
            binding.scissorPlayerOne.setBackgroundResource(R.drawable.background_image)
            value1 = "2"
            display()
            result()
        }

        binding.refresh.setOnClickListener {
            reset()
            binding.rockPlayerOne.isEnabled = true
            binding.paperPlayerOne.isEnabled = true
            binding.scissorPlayerOne.isEnabled = true
            binding.refresh.rotation = 90F
            Handler().postDelayed({
                binding.refresh.rotation = 180F
            },1000)
        }

    }


    private fun display(){
        val random = Random
        val randomInt = random.nextInt(3)

        if(randomInt==0){
            value2 ="0"
            binding.rockPlayerTwo.setBackgroundResource(R.drawable.background_image)
        }else if( randomInt == 1){
            value2 = "1"
            binding.paperPlayerTwo.setBackgroundResource(R.drawable.background_image)
        }else if( randomInt ==2){
            value2 = "2"
            binding.scissorPlayerTwo.setBackgroundResource(R.drawable.background_image)
        }
    }

    fun result() {
        if (value1 == value2) {
            Handler().postDelayed({ showDraw() }, 1000)
        } else if (value1 == "0" && value2 == "2" || value1 == "1" && value2 == "0" || value1 == "2" && value2 == "1") {
            Handler().postDelayed({ showWin() }, 1000)
        } else {
            Handler().postDelayed({ showLoss() }, 1000)
        }
    }

    private fun showDraw() {
        binding.result.setImageResource(R.drawable.draw)

        binding.rockPlayerOne.isEnabled = false
        binding.paperPlayerOne.isEnabled = false
        binding.scissorPlayerOne.isEnabled = false

    }

    private fun showWin() {
        binding.result.setImageResource(R.drawable.win_player_1)
        binding.rockPlayerOne.isEnabled = false
        binding.paperPlayerOne.isEnabled = false
        binding.scissorPlayerOne.isEnabled = false
    }

    private fun showLoss() {
        binding.result.setImageResource(R.drawable.los_player_1)
        binding.rockPlayerOne.isEnabled = false
        binding.paperPlayerOne.isEnabled = false
        binding.scissorPlayerOne.isEnabled = false
    }

    private fun reset(){
        binding.rockPlayerOne.setBackgroundColor(Color.TRANSPARENT)
        binding.rockPlayerTwo.setBackgroundColor(Color.TRANSPARENT)
        binding.paperPlayerOne.setBackgroundColor(Color.TRANSPARENT)
        binding.paperPlayerTwo.setBackgroundColor(Color.TRANSPARENT)
        binding.scissorPlayerOne.setBackgroundColor(Color.TRANSPARENT)
        binding.scissorPlayerTwo.setBackgroundColor(Color.TRANSPARENT)
        binding.result.setImageResource(R.drawable.versus)

    }
}