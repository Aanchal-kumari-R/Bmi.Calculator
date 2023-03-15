package com.example.myapplication2

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.edit_1)
        val heightText = findViewById<EditText>(R.id.edit_2)
        val calcButton = findViewById<Button>(R.id.edit_3)
        val bmivalue = findViewById<TextView>(R.id.edit_4)

        val status = findViewById<TextView>(R.id.edit_5)
        var isclear = false


        calcButton.setOnClickListener {

            if (!weightText.text.toString().equals("") && heightText.text.toString().equals("")) {
                Toast.makeText(this, "Please enter the height", Toast.LENGTH_LONG).show()
                heightText.requestFocus()
                return@setOnClickListener
            } else if (weightText.text.toString().equals("") && !heightText.text.toString()
                    .equals("")
            ) {
                Toast.makeText(this, "please enter the weigth", Toast.LENGTH_LONG).show()
                weightText.requestFocus()
                return@setOnClickListener
            } else if (!weightText.text.toString().equals("") && !heightText.text.toString()
                    .equals("")
            ) {
                if (!isclear) {
                    Toast.makeText(this, "Clear Karo", Toast.LENGTH_LONG).show()
                    isclear = true
                    calcButton.text = "Clear"


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
                } else if (isclear) {
                    weightText.text.clear()
                    heightText.text.clear()
                    bmivalue.text = ""
                    status.text = ""

                }
            } else {

                Toast.makeText(this, "please enter the value", Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_dev -> {
                val intent = Intent(this, Aboutdeveloper::class.java)
                //   Toast.makeText(this,"About BMI",Toast.LENGTH_LONG).show()
                startActivity(intent)
                return true
            }
            R.id.bmi_chart -> {
                val intent = Intent(this, bmi_chart::class.java)
                //  Toast.makeText(this,"BMI chart",Toast.LENGTH_LONG).show()
                startActivity(intent)
                return true
            }
            R.id.about_bmi -> {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://developer.android.com/reference/android/content/Intent")
                )
                startActivity(intent)
            }
            R.id.dial -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:6767676767"))
                startActivity(intent)
            }
            R.id.call -> {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:8787878787")
                    startActivity(intent)
                } else {
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1001)
                }


            }


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(resources.getString(R.string.app_name))
        alertDialog.setMessage("Do you want to exit ?")
        alertDialog.setPositiveButton("Exit", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                finish()

            }
        })
        alertDialog.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {

            }
        })
            .show()

    }

}













        







