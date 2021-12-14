package com.finite.day03practise

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    fun clickButton(view: android.view.View) {

        val tipValue: TextInputEditText = findViewById(R.id.tipValue)
        val radioG: RadioGroup = findViewById(R.id.radioGroup)
        val newTip: TextView = findViewById(R.id.newTip)
        val tipSwitch: SwitchMaterial = findViewById(R.id.roundSwitch)

        val amount = (tipValue.text.toString()).toDoubleOrNull()

        if(amount == null || amount == 0.0) {
            newTip.text = "Tip Amount : Rs. 0.0"
            return
        }

        val tipPercent = when(radioG.checkedRadioButtonId) {
            R.id.amazing -> 0.2
            R.id.good -> 0.15
            else -> 0.1
        }

        var tip = amount * tipPercent


        if(tipSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
            val tipInt = tip.toInt()
            newTip.text = "Tip Amount : Rs. $tipInt"
        }  else {
            newTip.text = "Tip Amount : Rs. ${tip.toString()}"
        }
    }


}