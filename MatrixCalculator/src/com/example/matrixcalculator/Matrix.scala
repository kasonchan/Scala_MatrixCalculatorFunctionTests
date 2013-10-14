/**
 * Package: com.example.matrixCalculator
 * File: Matrix.scala
 * Created Date: September 11, 2013
 * Status: Completed
 * Programmer: Ka-Son Chan
 * Description: This file contains the Matrix class which allows the user to
 * input the matrics for calculation.
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
import android.app.Dialog
import android.content._

class Matrix extends Activity with Functions {
  private var seat = 2
  private var matrixOperation = "Multiplication"
  private var matrix1RowSize = 6
  private var matrix1ColumnSize = 6
  private var matrix2RowSize = 6
  private var matrix2ColumnSize = 6

  private var matrix1 = ofDim[Int](5, 5)
  private var matrix2 = ofDim[Int](5, 5)

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    // Set screen to matrix page
    setContentView(R.layout.matrix)

    // Get the user inputs of matrix operation, row and column sizes from
    // previous activity
    try {
      matrixOperation = this.getIntent().getStringExtra("matrixOperation")
      matrix1RowSize = this.getIntent().getStringExtra("matrix1RowSize").toInt
      matrix1ColumnSize = this.getIntent().getStringExtra("matrix1ColumnSize").toInt
      matrix2RowSize = this.getIntent().getStringExtra("matrix2RowSize").toInt
      matrix2ColumnSize = this.getIntent().getStringExtra("matrix2ColumnSize").toInt
    } catch {
      case nfe: NumberFormatException => toast("Invalid row or column size")
      case npe: NullPointerException => toast("Invalid row or column size")
    }

    // Display the user input of matrix operation
    setTextValue(R.id.textView1, matrixOperation)

    // Display the correct user input sizes of matrix 1
    setMatrixInvisible(matrix1RowSize, matrix1ColumnSize, 1)

    // Display the correct user input sizes of matrix 2
    setMatrixInvisible(matrix2RowSize, matrix2ColumnSize, 2)

    // Let user to click on Back button to go back to previous page
    backListener()

    // Let user to click on the Computer button to Compute the result
    computeListener(matrix1RowSize, matrix1ColumnSize, matrix2RowSize, matrix2ColumnSize)
  }

  /**
   * @param r1 matrix 1 row size
   * @param c1 matrix 1 column size
   * @param r2 matrix 2 row size
   * @param c2 matrix 2 column size
   * Let the user to click on the compute button and return the result
   */
  def computeListener(r1: Int, c1: Int, r2: Int, c2: Int) {
    val computeButton = findViewById(R.id.computeButton)
    var et = "editText"
    var resId = 1

    computeButton.setOnClickListener(new View.OnClickListener() {
      def onClick(v: View) {
        // Get the user input matrics and save to 2-dimensional arrays
        if ((getMatrix(matrix1RowSize, matrix1ColumnSize, 1) == true) && (getMatrix(matrix2RowSize, matrix2ColumnSize, 2) == true)) {
          // TODO: Finish up the computation of the matrics
          // Compute the multiplication of matrix 1 and matrix 2
          val resultMatrixArray = matrixMultiplication(matrix1, matrix2)
          // Cover the result matrix array to string
          val resultMatrix = arrayToString(resultMatrixArray)

          // Save current intent and send to matrix layout page
          val intent = new Intent(Matrix.this, classOf[Result])
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

          // Save result matrix to next activity
          intent.putExtra("resultMatrix", resultMatrix)

          // Print seat value
          println(seat)
          seat = 0

          // Go to result class
          startActivity(intent)
        }
      }
    })
  }

  /**
   * @param r row size
   * @param c column size
   * @param m matrix1 or matrix2
   * Display the user input row and column size matrix
   */
  def setMatrixInvisible(r: Int, c: Int, m: Int) {
    var et = "editText"
    var resId = 1

    for (i <- 0 to 4) {
      for (j <- 1 to 5) {
        if ((i > r - 1) || (j > c)) {
          // Set the matrix to invisible
          if (m == 2) {
            et = "editText" + (j + (i * 5) + 25)
            setTextInvisible(getTextResource(et))
          } else {
            et = "editText" + (j + (i * 5))
            setTextInvisible(getTextResource(et))
          }
        }
      }
    }
  }

  /**
   * @param r row size
   * @param c column size
   * @param m matrix1 or matrix2
   * Save the user input matrix to 2-dimensional array
   */
  def getMatrix(r: Int, c: Int, m: Int): Boolean = {
    var et = "editText"
    var resId = 1

    for (i <- 0 to 4) {
      for (j <- 1 to 5) {
        if ((i > r - 1) || (j > c)) {
          if (m == 2)
            matrix2(i)(j - 1) = 0
          else
            matrix1(i)(j - 1) = 0
        } else {
          if (m == 2) {
            et = "editText" + (j + (i * 5) + 25)
            if ((getTextValue(getTextResource(et)) == "")) {
              toast("Empty matrix.")
              return false
            }
            else if ((getTextValue(getTextResource(et)) == "-")) {
              toast("Invalid matrix data \"-\".")
              return false
            } else
              matrix2(i)(j - 1) = (getTextValue(getTextResource(et))).toInt
          } else {
            et = "editText" + (j + (i * 5))
            if ((getTextValue(getTextResource(et)) == "")) {
              toast("Empty matrix.")
              return false
            }
            else if ((getTextValue(getTextResource(et)) == "-")) {
              toast("Invalid matrix data \"-\".")
              return false
            } else
              matrix1(i)(j - 1) = (getTextValue(getTextResource(et))).toInt
          }
        }
      }
    }
    true
  }

  /**
   * @param m1 matrix 1
   * @param m2 matrix 2
   * @return the result matrix
   * Perform matrix multiplication to matrix 1 and matrix 2 and return the
   * result matrix
   */
  def matrixMultiplication(m1: Array[Array[Int]], m2: Array[Array[Int]]): Array[Array[Int]] = {
    val resultMatrix = Array.fill(this.matrix1RowSize, this.matrix2ColumnSize)(0)

    for {
      row <- (0 until this.matrix1RowSize).par
      column <- (0 until this.matrix2ColumnSize).par
      i <- (0 until this.matrix1ColumnSize)
    } {
      resultMatrix(row)(column) += m1(row)(i) * m2(i)(column);
      this.seat = this.seat + 1
    }

    resultMatrix
  }
}