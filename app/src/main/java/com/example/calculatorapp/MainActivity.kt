package com.example.calculatorapp

import android.os.Bundle
import kotlinx.parcelize.Parcelize
import android.renderscript.ScriptGroup.Binding
import android.renderscript.ScriptGroup.Input
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder


//import kotlinx.android.synthetic.main.activity_main.actualResult
//import kotlinx.android.synthetic.main.activity_main.showResult

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }


    fun allClearAction(view: View) {

        binding.showResult.text = ""
        binding.actualResult.text = ""
    }

    fun backSpace(view: View) {
        val lengthsize = binding.showResult.length()

        if (lengthsize > 0) {
            binding.showResult.text=binding.showResult.text.subSequence(0, lengthsize - 1)
        }

    }
    fun numberAction(view: View) {
        if (view is Button){
            binding.showResult.append(view.text.toString())
        }
    }

    fun divison(view: View) {
        binding.showResult.append("/")
    }
    fun multiplication(view: View) {
        binding.showResult.append("*")

    }
    fun addition(view: View) {

        binding.showResult.append("+")

    }
    fun subtraction(view: View) {
        binding.showResult.append("-")
    }

    fun resultEqual(view: View) {

        val exp = ExpressionBuilder(binding.showResult.text.toString()).build()
        val result =exp.evaluate()
        binding.actualResult.text=result.toString()

    }










}
