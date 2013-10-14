package com.example.matrixcalculator.test

import android.test.ActivityInstrumentationTestCase2
import com.example.matrixcalculator._
import com.jayway.android.robotium.solo.Solo
import junit.framework.Assert._
import android.content.Intent
import android.app.Activity

class FunctionalTests extends ActivityInstrumentationTestCase2[Main]("com.example.matrixcalculator", classOf[Main]) {
  private var solo: Solo = null
  private var myActivity: Activity = null
  private var myIntent: Intent = null

  override def setUp() {
    super.setUp()
    solo = new Solo(getInstrumentation(), getActivity())
    myActivity = getActivity
    myIntent = new Intent(myActivity, myActivity.getClass());
  }

  override def tearDown() {
    solo.finishOpenedActivities();
  }

  def testEP01() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, "2")
    solo.enterText(1, "3")
    solo.enterText(2, "3")
    solo.enterText(3, "2")
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.clickOnButton(1)
  }

  def testEP02() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.sendKey(97) // Enter a
    solo.enterText(1, "3")
    solo.enterText(2, "3")
    solo.enterText(3, "2")
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP03() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.sendKey(29) // Enter a
    solo.enterText(2, String.valueOf("3"))
    solo.enterText(3, String.valueOf("2"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP04() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.enterText(1, String.valueOf("3"))
    solo.sendKey(29) // Enter a
    solo.enterText(3, String.valueOf("2"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP05() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.enterText(1, String.valueOf("3"))
    solo.enterText(2, String.valueOf("3"))
    solo.sendKey(29) // Enter a
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP06() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.sendKey(13) // Enter 6
    solo.enterText(1, String.valueOf("4"))
    solo.enterText(2, String.valueOf("4"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP07() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.sendKey(13) // Enter 6
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP08() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.enterText(1, String.valueOf("3"))
    solo.sendKey(13) // Enter 6
    solo.enterText(3, String.valueOf("2"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP09() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("3"))
    solo.enterText(2, String.valueOf("3"))
    solo.sendKey(13) // Enter 6
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP10() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.sendKey(7) // Enter 0
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("2"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP11() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(7) // Enter 0
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP12() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.enterText(1, String.valueOf("3"))
    solo.sendKey(7) // Enter 0
    solo.enterText(3, String.valueOf("4"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP13() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("2"))
    solo.enterText(2, String.valueOf("2"))
    solo.sendKey(7) // Enter 0
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP14() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(1, String.valueOf("3"))
    solo.enterText(2, String.valueOf("3"))
    solo.enterText(3, String.valueOf("2"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP15() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.enterText(2, String.valueOf("3"))
    solo.enterText(3, String.valueOf("2"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP16() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.enterText(1, String.valueOf("3"))
    solo.enterText(2, String.valueOf("3"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP17() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.enterText(1, String.valueOf("3"))
    solo.enterText(3, String.valueOf("2"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP18() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.sendKey(8) // Enter 1
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP19() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP20() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP21() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEP22() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("2"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Matrix Multiplication: Matrix 1 column size should be equal to Matrix 2 row size.")
    assertEquals("Toast message appeared- Matrix Multiplication: Matrix 1 column size should be equal to Matrix 2 row size.", toast1, true)
  }

  def testEP23() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("-1"))
    solo.enterText(1, String.valueOf("-1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

  def testEP24() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(29) // Enter a
    solo.sendKey(30) // Enter b
    solo.sendKey(31) // Enter c
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix.")
    assertEquals("Toast message appeared- Empty matrix", toast1, true)
    solo.clickOnButton(1)
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
  }

  def testEP25() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("-"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Invalid matrix data \"-\".")
    assertEquals("Toast message appeared- Invalid matrix data \"-\".", toast1, true)
    solo.clickOnButton(1)
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
  }

  def testEP26() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1-"))
    fail()
  }

  def testEP27() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.sendKey(8) // Enter 1
    solo.sendKey(56) // Enter .
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Invalid matrix data.")
    assertEquals("Toast message appeared- Invalid matrix data.", toast1, true)
    solo.clickOnButton(1)
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
  }

  def testEP28() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("2"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("2"))
  }

  def testEP29() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("100000"))
    solo.enterText(1, String.valueOf("100000"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("10000000000"))
  }

  def testBVA01() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, "1")
    solo.enterText(1, "1")
    solo.enterText(2, "1")
    solo.enterText(3, "1")
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.clickOnButton(1)
  }

  def testBVA02() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA03() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA04() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA05() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("3"))
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("3"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("3"))
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("3"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.clickOnButton(1)
  }

  def testBVA06() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.clickOnButton(1)
  }

  def testBVA07() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.sendKey(13) // Enter 6
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA08() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(13) // Enter 6
    solo.sendKey(66) // Enter enter
    solo.sendKey(13) // Enter 6
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA09() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("5"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(13) // Enter 6
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA10() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.sendKey(8) // Enter 1
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA11() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA12() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA13() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("2"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA14() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA15() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA16() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testBVA17() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }
  def testEVA01() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    for (j <- 1 to 4) {
      solo.sendKey(8) // Enter 1
      for (i <- 1 to 5)
        solo.sendKey(7) // Enter 0
      solo.sendKey(66) // Enter enter
    }
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEVA02() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    for (j <- 1 to 4) {
      solo.sendKey(69) // Enter -
      solo.sendKey(8) // Enter 1
      for (i <- 1 to 5)
        solo.sendKey(7) // Enter 0
      solo.sendKey(66) // Enter enter
    }
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
  }

  def testEVA03() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("100000"))
    solo.enterText(1, String.valueOf("100000"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("10000000000"))
  }

  def testEVA04() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("-100000"))
    solo.enterText(1, String.valueOf("-100000"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("10000000000"))
  }

  def testEVA05() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("1000"))
    solo.enterText(1, String.valueOf("1000"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("1000000"))
  }

  def testEVA06() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("-1000"))
    solo.enterText(1, String.valueOf("-1000"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("1000000"))
  }

  def testEVA07() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("5"))
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    for (i <- 0 to 49) {
      solo.enterText(i, String.valueOf("1"))
    }
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

  def testEVA08() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("5"))
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    for (i <- 0 to 49) {
      solo.enterText(i, String.valueOf("-1"))
    }
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

  def testEVA09() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("5"))
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    for (i <- 0 to 49) {
      solo.enterText(i, String.valueOf("100"))
    }
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

  def testEVA10() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("5"))
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    for (i <- 0 to 49) {
      solo.enterText(i, String.valueOf("-100"))
    }
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

  def testEVA11() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("5"))
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    for (i <- 0 to 49) {
      solo.enterText(i, String.valueOf("1000"))
    }
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

  def testEVA12() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("5"))
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    for (i <- 0 to 49) {
      solo.enterText(i, String.valueOf("-1000"))
    }
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

  def testEVA13() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("5"))
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    for (i <- 0 to 49) {
      solo.enterText(i, String.valueOf("10000"))
    }
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

  def testEVA14() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("5"))
    solo.enterText(1, String.valueOf("5"))
    solo.enterText(2, String.valueOf("5"))
    solo.enterText(3, String.valueOf("5"))
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    for (i <- 0 to 49) {
      solo.enterText(i, String.valueOf("-10000"))
    }
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    solo.clickOnButton(0)
  }

    def testEG01() {
      solo.sendKey(68) // Enter `
      solo.sendKey(66) // Enter enter
      solo.sendKey(77) // Enter @
      solo.sendKey(66) // Enter enter
      solo.sendKey(18) // Enter #
      solo.sendKey(66) // Enter enter
      solo.sendKey(155) // Enter *
      solo.sendKey(66) // Enter enter
      solo.clickOnButton(0)
      val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
      assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
    }
  
    def testEG02() {
      for (i <- 1 to 2)
        solo.sendKey(68) // Enter `
      solo.sendKey(66) // Enter enter
      for (i <- 1 to 2)
        solo.sendKey(77) // Enter @
      solo.sendKey(66) // Enter enter
      for (i <- 1 to 2)
        solo.sendKey(18) // Enter #
      solo.sendKey(66) // Enter enter
      for (i <- 1 to 2)
        solo.sendKey(155) // Enter *
      solo.sendKey(66) // Enter enter
      solo.clickOnButton(0)
      val toast1 = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
      assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast1, true)
    }
  
    def testEG03() {
      solo.assertCurrentActivity("Main activity is launched", classOf[Main])
      solo.enterText(0, String.valueOf("1"))
      solo.enterText(1, String.valueOf("1"))
      solo.enterText(2, String.valueOf("1"))
      solo.enterText(3, String.valueOf("1"))
      solo.clickOnButton(0)
      solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
      solo.sendKey(71) // Enter [
      solo.sendKey(66) // Enter enter
      solo.sendKey(41) // Enter M
      solo.sendKey(66) // Enter enter
      solo.clickOnButton(0)
      val toast1 = solo.searchText("Empty matrix.")
      assertEquals("Toast message appeared- Empty matrix", toast1, true)
    }
}