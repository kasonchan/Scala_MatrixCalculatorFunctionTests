/**
 * Package: com.example.matrixCalculator
 * File: Functions.scala
 * Created Date: September 11, 2013
 * Status: Completed
 * Programmer: Ka-Son Chan
 * Description: This trait Functions file contains all the matrix-related 
 * functions which are used in multiple classes.
 */
package com.example.matrixcalculator

import android.app.Activity
import android.widget.Toast
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.view.View


trait Functions extends Activity {
  /**
   * @param x any type value
   * Display the x in String with long length time
   */
  def toast(x: Any) = {
    Toast.makeText(this, x.toString(), Toast.LENGTH_LONG).show()
  }

  /**
   * @param x the view id value
   * @return the string value of the EditText x
   */
  def getTextValue(x: Int): String = {
    findViewById(x).asInstanceOf[EditText].getText().toString()
  }

  /**
   * @param x the view id value
   * @return the string value of selected item from the Spinner x
   */
  def getSelectedValue(x: Int): String = {
    String.valueOf(findViewById(x).asInstanceOf[Spinner].getSelectedItem())
  }

  /**
   * @param x the view id value
   * @param value
   * Set the value to the TextView x
   */
  def setTextValue(x: Int, value: String) = {
    findViewById(x).asInstanceOf[TextView].setText(value)
  }

  /**
   * @param x the view id value
   * Set the view id x to invisible
   */
  def setTextInvisible(x: Int) = {
    findViewById(x).setVisibility(View.GONE)
  }

  /**
   * @param et the view id value of the editText
   * @return the id value of the editText et
   */
  def getTextResource(et: String): Int = {
    getResources().getIdentifier(et, "id", "com.example.matrixcalculator")
  }

  /**
   * Let the user to click on the back button to go back to the previous
   * layout page
   */
  def backListener() {
    val backButton = findViewById(R.id.backButton)
    backButton.setOnClickListener(new View.OnClickListener() {
      def onClick(v: View) {
        // Go back to main layout page
        finish()
      }
    })
  }

  /**
   * @param a array to be converted to string
   * @return the string of the array
   * Convert the array a to string
   */
  def arrayToString(a: Array[Array[Int]]): String = {
    val str = for (l <- a) yield l.mkString(" ")
    str.mkString("\n")
  }
}