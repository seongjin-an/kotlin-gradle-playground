package grade

class MajorEvaluation: GradeEvaluation {
    override fun getGrade(point: Int): String {
        return when(point){
            in (95 .. 100) -> "S"
            in (90 .. 94) -> "A"
            in (80 .. 89) -> "B"
            in (70 .. 79) -> "C"
            in (60 .. 69) -> "D"
            else -> "F"
        }
    }
}