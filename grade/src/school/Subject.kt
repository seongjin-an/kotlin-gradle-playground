package school

import utils.Definition

class Subject(var subjectName: String, var subjectId: Int) {
    var gradeType: Int = 0
//        get() = field
//        set(value) { field = value }
    var studentList: MutableList<Student> = mutableListOf()
//        get() = field
//        set(value) { field = value }

    init {
        this.gradeType = Definition.AB_TYPE
    }

    fun register(student: Student){
        studentList.add(student)
    }

    override fun toString(): String {
        return "school.Subject(subjectName='$subjectName', subjectId=$subjectId, gradeType=$gradeType, studentList=$studentList)"
    }


}