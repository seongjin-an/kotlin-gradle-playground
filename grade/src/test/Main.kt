package test

import school.School
import school.Subject
import utils.GenerateGradeReport
import utils.GenerateSubjectStudent

fun main(args: Array<String>){
    val generator = GenerateSubjectStudent()
    generator.createSubject()
    generator.createStudent()

    val report = generator.gradeReport.getReport()
    val report2 = GenerateGradeReport().getReport()
    println("report: $report")
    println("***************************************************")
    println("report: $report2")
}