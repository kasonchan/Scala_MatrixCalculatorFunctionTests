/**
 * Package: com.example.matrixCalculator
 * File: Main.scala
 * Created Date: September 11, 2013
 * Status: Completed
 * Programmer: Ka-Son Chan
 * Description: This file contains the Main class that allows the user to input
 * the matrix operation, matrics row and column sizes.
 */
package com.example.matrixcalculator

import android.os.Bundle
import android.app.Activity
import android.view.Menu
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import scala.actors.Actor
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Spinner
import android.content.Context
import android.content.Intent

class Main extends Activity with Functions {
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    // Set screen to main page
    setContentView(R.layout.main)

    // Let user to generate the input-sized matrix
    generateListener()
  }

  /**
   * Let the user to generate sizes of matrics and then go to the matrix
   * layout page
   */
  def generateListener() {
    val button1 = findViewById(R.id.button1)
    button1.setOnClickListener(new View.OnClickListener() {
      def onClick(v: View) {
        // Get the values of the user inputs       
        val spinner1Value = getSelectedValue(R.id.spinner1)
        val editText1Value = getTextValue(R.id.editText1)
        val editText2Value = getTextValue(R.id.editText2)
        val editText3Value = getTextValue(R.id.editText3)
        val editText4Value = getTextValue(R.id.editText4)

        // Save current intent and send to matrix layout page
        val intent = new Intent(Main.this, classOf[Matrix])
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        // Validate user input matrix row and column sizes

        // If user chose matrix multiplication
        if (spinner1Value.equals("Multiplication")) {
          if (editText1Value.equals("") || editText2Value.equals("") ||
            editText3Value.equals("") || editText4Value.equals("")) {
            toast("Empty matrix row or column size. Enter size range between 1 to 5.")
          } else {
            if ((editText2Value).equals(editText3Value)) {

              // Save user's input of matrix operation, rows and column sizes to next activity
              intent.putExtra("matrixOperation", spinner1Value)
              intent.putExtra("matrix1RowSize", editText1Value)
              intent.putExtra("matrix1ColumnSize", editText2Value)
              intent.putExtra("matrix2RowSize", editText3Value)
              intent.putExtra("matrix2ColumnSize", editText4Value)

              // Go to matrix class
              startActivity(intent)
            } else {
              toast("Matrix " + spinner1Value + ": Matrix 1 column size should be equal to Matrix 2 row size.")
            }
          }
        }
      }
    })
  }
}