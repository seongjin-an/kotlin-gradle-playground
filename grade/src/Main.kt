import school.Student
import school.Subject

fun main(args: Array<String>){
    val subject = Subject("math", 1)
    subject.gradeType = 1
    subject.studentList.add(Student(1, "ansj", Subject("math", 1)))
    println("subject: $subject")
    println("subject.gradeType: ${subject.gradeType}")
    println("subject.studentList: ${subject.studentList}")
}