package com.example.colormaker

import android.annotation.SuppressLint
import android.graphics.Color.rgb
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {


    var color1 = 0
    var color2 = 0
    var color3 = 0

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.teal_700)))




        val button: Button? = findViewById(R.id.button)
        val number1: TextView = findViewById(R.id.number1)
        val number2: TextView = findViewById(R.id.number2)
        val number3: TextView = findViewById(R.id.number3)

        val colorView: View = findViewById(R.id.colorView)
        val firstSwitch: SwitchCompat = findViewById(R.id.firstSwitch)
        val switch2: SwitchCompat = findViewById(R.id.switch2)
        val switch3: SwitchCompat = findViewById(R.id.switch3)



        val seek = findViewById<SeekBar>(R.id.seekBar)
        seek.isEnabled = false
        seek?.setOnSeekBarChangeListener(object :
            OnSeekBarChangeListener {
            @SuppressLint("ResourceAsColor")
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                color1 = progress
                number1.text = (progress * 0.00392157).toString()
                colorView.setBackgroundColor(rgb(color1, color2, color3))
            }

            override fun onStartTrackingTouch(seek: SeekBar) {

            }

            override fun onStopTrackingTouch(seek: SeekBar) {

                Toast.makeText(
                    this@MainActivity,
                    "Progress is: " + seek.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        val seek2 = findViewById<SeekBar>(R.id.seekBar2)
        seek2.isEnabled = false
        seek2?.setOnSeekBarChangeListener(object :
            OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                color2 = progress
                number2.text = (progress * 0.00392157).toString()
                colorView.setBackgroundColor(rgb(color1, color2, color3))
            }

            override fun onStartTrackingTouch(seek: SeekBar) {

            }

            override fun onStopTrackingTouch(seek: SeekBar) {

                Toast.makeText(
                    this@MainActivity,
                    "Progress is: " + seek.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        val seek3 = findViewById<SeekBar>(R.id.seekBar3)
        seek3.isEnabled = false
        seek3?.setOnSeekBarChangeListener(object :
            OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                color3 = progress
                number3.text = (progress * 0.00392157).toString()
                colorView.setBackgroundColor(rgb(color1, color2, color3))
            }

            override fun onStartTrackingTouch(seek: SeekBar) {


            }

            override fun onStopTrackingTouch(seek: SeekBar) {

                Toast.makeText(
                    this@MainActivity,
                    "Progress is: " + seek.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        button?.setOnClickListener {
            colorView.setBackgroundColor(rgb(0, 0, 0))
            seek.progress = 0
            seek2.progress = 0
            seek3.progress = 0


        }
        firstSwitch.setOnCheckedChangeListener { _, onSwitch ->
            seek.isEnabled = onSwitch
            seek.max = 255
        }
        switch2.setOnCheckedChangeListener { _, onSwitch ->
            seek2.isEnabled = onSwitch
            seek2.max = 255
        }
        switch3.setOnCheckedChangeListener { _, onSwitch ->
            seek3.isEnabled = onSwitch
            seek3.max = 255
        }
        button?.setOnClickListener{
            firstSwitch.isChecked = false
            switch2.isChecked = false
            switch3.isChecked = false
        }




    }
}
