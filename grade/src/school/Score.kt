package school

class Score(
    var studentId: Int,
    var subject: Subject,
    var point: Int
) {
    override fun toString(): String {
        return "school.Score(studentId=$studentId, subject=$subject, point=$point)"
    }
}