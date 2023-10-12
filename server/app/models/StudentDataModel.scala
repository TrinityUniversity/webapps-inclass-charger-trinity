package models

import collection.mutable

object StudentDataModel {

  def readData():mutable.Map[String, String] = {
    val source = scala.io.Source.fromFile("data/StudentData.csv")
    val damap = mutable.Map[String, String]()
    val studentData = (for (line <- source.getLines()) yield {
      val parts = line.split(", ")
      val username = parts(2).split("@").head 
      val year = parts(1)
      damap += (username -> year)
    }).toList
    source.close()
    return damap
  }
  
  private val students = readData()

  def validateStudent(email: String, year: String): Boolean = {
    students.get(email).map(_ == year).getOrElse(false)
  }
}
 