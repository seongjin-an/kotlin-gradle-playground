package school

class Student(
    var studentId: Int,
    var studentName: String,
    var majorSubject: Subject
) {
    var scoreList: MutableList<Score> = mutableListOf()
//        get() = field
//        set(value) { field = value }

    fun addSubjectScore(score: Score){
        scoreList.add(score)
    }

    override fun toString(): String {
        return "school.Student(studentId=$studentId, studentName='$studentName', majorSubject=$majorSubject, scoreList=$scoreList)"
    }


}