package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.edit_1)
        val heightText = findViewById<EditText>(R.id.edit_2)
        val calcButton = findViewById<Button>(R.id.button_1)
        val bmivalue = findViewById<TextView>(R.id.textveiw_1)

        val status = findViewById<TextView>(R.id.textview2)
        var isclear=false


        calcButton.setOnClickListener {

            if (!weightText.text.toString().equals("") && heightText.text.toString().equals("")) {
                Toast.makeText(this, "Please enter the height", Toast.LENGTH_LONG).show()
                heightText.requestFocus()
                return@setOnClickListener
            } else if (weightText.text.toString().equals("") && !heightText.text.toString().equals("")) {
                Toast.makeText(this, "please enter the weigth", Toast.LENGTH_LONG).show()
                weightText.requestFocus()
                return@setOnClickListener
            } else if (!weightText.text.toString().equals("") && !heightText.text.toString()
                    .equals("")) {
                if(!isclear) {
                    Toast.makeText(this, "Clear Karo", Toast.LENGTH_LONG).show()
                    isclear=true
                    calcButton.text="Clear"


                    var wi = weightText.text.toString().toDouble()
                    var hi = heightText.text.toString().toDouble()
                    val bmi = wi / (hi / 100) * (hi / 100)
                    bmivalue.text = "Your BMI value=" + bmi.toString()
                    if (bmi > 25) {
                        Toast.makeText(this, "you are overweigth", Toast.LENGTH_LONG).show()
                        status.text = "You are overweigth"
                    } else if (bmi < 18) {
                        Toast.makeText(this, "you are underweigth", Toast.LENGTH_LONG).show()
                        status.text = "you are underweigth"
                    } else {
                        Toast.makeText(this, "you are fit", Toast.LENGTH_LONG).show()
                        status.text = "you are fit"
                    }
                }
                else if(isclear){
                    weightText.text.clear()
                    heightText.text.clear()
                    bmivalue.text=""
                    status.text=""

                }
            } else {

                Toast.makeText(this, "please enter the value", Toast.LENGTH_LONG).show()
            }

        }
    }

}












