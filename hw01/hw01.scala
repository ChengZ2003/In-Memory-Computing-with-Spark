import scala.io.StdIn
import scala.io.Source
import scala.collection.mutable.Map
import java._

object scalareadfile {
    def main(args: Array[String]){
        val source = Source.fromFile("./student.txt", "UTF-8")
        val lines = source.getLines()
        val student_Info = Map[String, (String, String)]()

        lines.foreach(
            line => {
                val split_line = line.split(",")
                student_Info += (split_line(0) -> (split_line(1), split_line(4)))
            }
        )

        val str = StdIn.readLine("Enter student number: ")
        if (student_Info.contains(str)) {
            println("Student number: " + str + " Student name: " + student_Info(str)._1)
        } else {
            println("Student not found")
        }

        val topScore = student_Info.values.map(_._2.toInt).max // get the highest score
        val topStudents = student_Info.filter(_._2._2.toInt == topScore) // get the students' Info with the highest score

        println("Top Scores:")
        topStudents.foreach {
            case (studentNumber, (studentName, studentScore)) =>
            println(s"Student number: $studentNumber,Student name: $studentName,Score: $studentScore")
        }

        source.close()
    }
}