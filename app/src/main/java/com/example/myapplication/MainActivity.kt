package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var selectedoprator = ""

    var oldnumber = ""

    var isnewopration: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickbuttonevent(view: View?) {

        if (isnewopration) {
            clearshownumber()
        }

        isnewopration = false
        val selectedbutton = view as Button
//        Toast.makeText(this,view.text,Toast.LENGTH_SHORT).show()

        val currentnumber: String = shownumber.text.toString()

        var newnumber = setnextcharactor(currentnumber, selectedbutton)
        shownumber.setText(newnumber)
    }

    fun setnextcharactor(oldnumber: String, selectedbutton: Button): String {
        var number = oldnumber

        when (selectedbutton.id) {
            btn_0.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    number += "0"
                }
            }
            btn_1.id -> {
                if (number == "0" || number == "") {
                    number = "1"
                } else {
                    number += "1"
                }
            }
            btn_2.id -> {
                if (number == "0" || number == "") {
                    number = "2"
                } else {
                    number += "2"
                }
            }
            btn_3.id -> {
                if (number == "0" || number == "") {
                    number = "3"
                } else {
                    number += "3"
                }
            }
            btn_4.id -> {
                if (number == "0" || number == "") {
                    number = "4"
                } else {
                    number += "4"
                }
            }
            btn_5.id -> {
                if (number == "0" || number == "") {
                    number = "5"
                } else {
                    number += "5"
                }
            }
            btn_6.id -> {
                if (number == "0" || number == "") {
                    number = "6"
                } else {
                    number += "6"
                }
            }
            btn_7.id -> {
                if (number == "0" || number == "") {
                    number = "7"
                } else {
                    number += "7"
                }
            }
            btn_8.id -> {
                if (number == "0" || number == "") {
                    number = "8"
                } else {
                    number += "8"
                }
            }
            btn_9.id -> {
                if (number == "0" || number == "") {
                    number = "9"
                } else {
                    number += "9"
                }
            }
            btn_dot.id -> {

                if (number == "") {
                    number = "0."
                } else {
                    if (number.indexOf('.') == -1){
                        number += "."
                    }
                }
            }
            btn_pn.id -> {
                if (number == "0" || number == "") {
                    number = "0"

                } else {
                    if (number.first() == '-') {
                        number = number.substring(1, number.lastIndex + 1)
                    } else {
                        number = "-$number"
                    }
                }
            }

        }

        return number
    }

    fun oprationevent(view: View) {
        val selectedbutton = view as Button

        when (selectedbutton.id) {
            btn_ta.id -> {
                selectedoprator = "/"
            }
            btn_add.id -> {
                selectedoprator = "*"
            }
            btn_ne.id -> {
                selectedoprator = "-"
            }
            btn_pl.id -> {
                selectedoprator = "+"
            }
        }
        isnewopration = true
        oldnumber = shownumber.text.toString()
    }

    fun equalevent(view: View) {
        view as Button
        val newnumber = shownumber.text.toString().toDouble()
        var answer: Double? = null
        if (selectedoprator != "" && oldnumber != ""){
            when (selectedoprator) {
                "/" -> {
                    answer = oldnumber.toDouble() / newnumber
                }
                "*" -> {
                    answer = oldnumber.toDouble() * newnumber
                }
                "+" -> {
                    answer = oldnumber.toDouble() + newnumber
                }
                "-" -> {
                    answer = oldnumber.toDouble() - newnumber
                }
            }
            shownumber.text = answer.toString()
            isnewopration = true
            oldnumber = ""
            selectedoprator = ""
        }
    }

    fun percentagevent(view: View){
        view as Button
        val number = shownumber.text.toString().toDouble()
        val percentage = number / 100
        shownumber.setText(percentage.toString())
        isnewopration = true
    }

    fun clearinput(view: View){
        view as Button
        clearshownumber()
        isnewopration = true
        selectedoprator = ""
    }

    fun clearshownumber() {
        shownumber.setText("0")
    }
}