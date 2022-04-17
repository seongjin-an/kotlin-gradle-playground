package school

class School {
    companion object {
        @Volatile
        private var instance: School? = null

        @JvmStatic
        fun getInstance(): School =
            instance ?: synchronized(this) {
                instance ?: School().also {
                    instance = it
                }
            }
    }

    var studentList = mutableListOf<Student>()
    var subjectList = mutableListOf<Subject>()

    fun addStudent(student: Student){
        studentList.add(student)
    }
    fun addSubject(subject: Subject){
        subjectList.add(subject)
    }
}