package utils

import grade.BasicEvaluation
import grade.GradeEvaluation
import grade.MajorEvaluation
import grade.PassFailEvaluation
import school.School
import school.Score
import school.Student
import school.Subject

class GenerateGradeReport {

    companion object{
        val TITLE = " 수강생 학점 \t\t\n"
        val HEADER = " 이름  |  학번  |중점과목| 점수   \n"
        val LINE = "-------------------------------------\n"
    }
    val school = School.getInstance()
    private val buffer = StringBuffer()

    fun getReport(): String {
        val subjectList = school.subjectList
        subjectList.forEach { subject ->
            makeHeader(subject)
            makeBody(subject)
            makeFooter()
        }
        return buffer.toString()
    }

    fun makeHeader(subject: Subject){
        buffer.append(LINE)
        buffer.append("\t${subject.subjectName}")
        buffer.append(TITLE)
        buffer.append(HEADER)
        buffer.append(LINE)
    }
    fun makeBody(subject: Subject){
        val studentList = subject.studentList
        studentList.forEach { student ->
            buffer.append(student.studentName)
            buffer.append(" | ")
            buffer.append(student.studentId)
            buffer.append(" | ")
            buffer.append(student.majorSubject.subjectName.plus("\t"))
            buffer.append(" | ")

            getScoreGrade(student, subject.subjectId)
            buffer.append("\n")
            buffer.append(LINE)
        }
    }

    fun getScoreGrade(student: Student, subjectId: Int){
        val scoreList = student.scoreList
        val majorId = student.majorSubject.subjectId
        val gradeEvaluation: Array<GradeEvaluation> = arrayOf(BasicEvaluation(), MajorEvaluation(), PassFailEvaluation())
        val score: Score? = scoreList.find { score -> score.subject.subjectId == subjectId}
        val grade = if (score?.subject?.subjectId == majorId) {
            gradeEvaluation[Definition.SAB_TYPE].getGrade(score.point)
        } else {
            gradeEvaluation[Definition.AB_TYPE].getGrade(score!!.point)
        }
        buffer.append(score.point)
        buffer.append(":")
        buffer.append(grade)
        buffer.append(" | ")
    }

    fun makeFooter(){
        buffer.append("\n")
    }

}