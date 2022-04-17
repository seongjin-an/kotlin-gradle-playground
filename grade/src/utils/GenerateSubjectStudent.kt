package utils

import school.School
import school.Score
import school.Student
import school.Subject


class GenerateSubjectStudent {
    val school = School.getInstance()
    val gradeReport = GenerateGradeReport()
    lateinit var korean: Subject
    lateinit var math: Subject
    lateinit var dance: Subject

    fun createSubject(){
        korean = Subject("KOREAN", Definition.KOREAN)
        math = Subject("MATH", Definition.MATH)
        dance = Subject("DANCE", Definition.DANCE)
        dance.gradeType = Definition.PF_TYPE

        school.addSubject(korean)
        school.addSubject(math)
        school.addSubject(dance)
    }

    fun createStudent(){
        val student1 = Student(211213, "강감찬", korean)
        val student2 = Student(212330, "김유신", math)
        val student3 = Student(201518, "신사임당", korean)
        val student4 = Student(202360, "이순신", korean)
        val student5 = Student(201290, "홍길동", math)

        school.addStudent(student1)
        school.addStudent(student2)
        school.addStudent(student3)
        school.addStudent(student4)
        school.addStudent(student5)

        korean.register(student1)
        korean.register(student2)
        korean.register(student3)
        korean.register(student4)
        korean.register(student5)

        math.register(student1)
        math.register(student2)
        math.register(student3)
        math.register(student4)
        math.register(student5)

        dance.register(student1)
        dance.register(student2)
        dance.register(student3)

        addScoreForStudent(student1, korean, 95)
        addScoreForStudent(student1, math, 56)
        addScoreForStudent(student1, dance, 95)

        addScoreForStudent(student2, korean, 95)
        addScoreForStudent(student2, math, 95)
        addScoreForStudent(student2, dance, 85)

        addScoreForStudent(student3, korean, 100)
        addScoreForStudent(student3, math, 88)
        addScoreForStudent(student3, dance, 55)

        addScoreForStudent(student4, korean, 89)
        addScoreForStudent(student4, math, 95)

        addScoreForStudent(student5, korean, 85)
        addScoreForStudent(student5, math, 56)
    }

    fun addScoreForStudent(student: Student, subject: Subject, point: Int){
        val score = Score(student.studentId, subject, point)
        student.addSubjectScore(score)
    }
}