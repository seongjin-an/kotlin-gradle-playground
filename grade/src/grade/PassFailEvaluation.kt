package grade

class PassFailEvaluation: GradeEvaluation {
    override fun getGrade(point: Int): String {
        return when{
            point >= 70 -> "P"
            else -> "F"
        }
    }
}