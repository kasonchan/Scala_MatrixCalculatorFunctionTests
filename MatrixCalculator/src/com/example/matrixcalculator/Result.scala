/**
 * Package: com.example.matrixCalculator
 * File: Result.scala
 * Created Date: September 11, 2013
 * Status: Completed
 * Programmer: Ka-Son Chan
 * Description: This file contains the Result class which prints the result
 * matrix.
 */
package com.example.matrixcalculator

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import Array._
import java.lang.Object._
import scala.collection.parallel._

class Result extends Activity with Functions {
  var resultMatrix = ""

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    // Set screen to main page
    setContentView(R.layout.result)

    // Get the result matrix from previous activity
    resultMatrix = this.getIntent().getStringExtra("resultMatrix")
    
    // Print result matrix 
    setTextValue(R.id.textView2, resultMatrix)

    // Let user to click on Back button to go back to previous page
    backListener()
  }
}