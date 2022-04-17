package grade

class BasicEvaluation: GradeEvaluation {
    override fun getGrade(point: Int): String {
        return when(point){
            in (90 .. 100) -> "A"
            in (80 .. 89) -> "B"
            in (70 .. 79) -> "C"
            in (55 .. 69) -> "D"
            else -> "F"
        }
    }
}