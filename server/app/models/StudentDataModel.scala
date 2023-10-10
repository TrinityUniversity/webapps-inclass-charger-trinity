package models

import collection.mutable

object StudentDataModel {

  def readData():Unit = {
    val source = scala.io.Source.fromFile("data/StudentData.csv")
    val studentData = (for (line <- source.getLines()) yield {
      val parts = line.split(", ")
      val username = parts(2).split("@").head
    }).toList
    source.close()
  }
  
  private val students = mutable.Map[String, String]("Mark" -> "pass")

  def validateStudent(email: String, year: String): Boolean = {
    students.get(email).map(_ == year).getOrElse(false)
  }
}
 