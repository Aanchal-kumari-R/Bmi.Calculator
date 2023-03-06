package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.edit_1)
        val heightText = findViewById<EditText>(R.id.edit_2)
        val calcButton = findViewById<Button>(R.id.edit_3)
        val bmivalue = findViewById<TextView>(R.id.edit_4)

        val status = findViewById<TextView>(R.id.edit_5)
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
                    val total = wi / (hi / 100) * (hi / 100)
                    val bmi=(total*100).roundToInt()/100.0


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
                    calcButton.text="Calculate BMI"
                    weightText.text.clear()
                    heightText.text.clear()
                    bmivalue.text=""
                    status.text=""
                    isclear=false

                }
            } else {

                Toast.makeText(this, "please enter the value", Toast.LENGTH_LONG).show()
            }

    }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        menuInflater.inflate(R.menu.menu_item,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_bmi -> {
                Toast.makeText(this, "About BMI", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.bmi_chart -> {
                Toast.makeText(this, "BMI chart", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.exit_app -> {
                Toast.makeText(this, "Exit", Toast.LENGTH_LONG).show()
                finish()
                System.exit(0)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
        override fun onBackPressed() {
             Toast.makeText(this,"back button not work",Toast.LENGTH_LONG).show();
         }


    }
