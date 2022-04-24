package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    private var canAddOperation = false
    private var canAddDecimal = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberAction(view: View)
    {
        if(view is Button)
        {
            if(view.text == "."){
                if(canAddDecimal)
                    meterText.append(view.text)

                canAddDecimal = false
            }
            else
            meterText.append(view.text)
            canAddOperation = true
        }
    }

    fun operationAction(view: View)
    {
        if(view is Button && canAddOperation)
        {
            meterText.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    fun allClearAction(view: View)
    {
        meterText.text=""
        footText.text=""
    }

    fun backSpaceAction(view: View) {
        val length = meterText.length()
        if(length > 0)
            meterText.text = meterText.text.subSequence(0, length - 1)
    }

    fun convertAction(view: View)
    {
        footText.text = convertUnit().toString()
    }

    fun convertUnit()
    {
        val meter = meterText.text
        val foot = meter * 3.281

        println(foot)
    }


//    private fun digitsOperators() : MutableList<Any>
//    {
//        val list = mutableListOf<Any>()
//        var currentDigit = ""
//        for(character in meterText.text)
//        {
//            if(character.isDigit() || character == '.')
//                currentDigit += character
//            else
//            {
//                list.add(currentDigit.toFloat())
//                currentDigit = ""
//                list.add(character)
//            }
//        }
//
//        if(currentDigit != "")
//            list.add(currentDigit.toFloat())
//
//        return list
//    }
}

private operator fun CharSequence.times(d: Double) {

}
