package maze

import java.util.Stack

class Robot {
    companion object {
        val NUM_DIRECTIONS = 4
        val WIDTH = 8
        val HEIGHT = 8

        val NOT_VISIT = 0
        val WALL = 1
        val VISIT = 2

    }
    val stack = Stack<Move>()
    lateinit var move: Move
    val maze = Maze()
    val DIRECTION_OFFSETS = arrayOf(
        arrayOf(0, -1),// move up
        arrayOf(1, 0),// move right
        arrayOf(0, 1),// move down
        arrayOf(-1, 0)// move left
    )
    var markArray = Array(8) { IntArray(8) }

    fun findPath(startX: Int,startY: Int, endX: Int, endY: Int){
        var isEmpty = false
        var isFound = false
        var i = 0

        val start = Move(startX, startY)
        start.direction = 0
        stack.push(start)

        while(!isEmpty && !isFound){
            val curPos = stack.pop()
            var x = curPos.x
            var y = curPos.y
            var direction = curPos.direction

            while(!isFound && direction < NUM_DIRECTIONS){
                val newX = x + DIRECTION_OFFSETS[direction][0]
                val newY = y + DIRECTION_OFFSETS[direction][1]

                if(
                    newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT &&
                            maze.maz[newY][newX] == NOT_VISIT && markArray[newY][newX] == NOT_VISIT
                ){
                    val newPosition = Move(newX, newY)
                    newPosition.direction = direction + 1
                    stack.push(newPosition)
                    markArray[y][x] = VISIT

                    x = newX
                    y = newY
                    direction = 0

                    if(newX == endX && newY == endY){
                        isFound = true
                        newPosition.x = newX
                        newPosition.y = newY
                        newPosition.direction = 0
                        stack.push(newPosition)
                        markArray[newY][newX] = VISIT
                    }
                }else{
                    direction++
                }
            }//end of while
        }
        isEmpty = stack.isEmpty()
    }//end of while

    fun showPath(){
        val resultArray = Array(8) { IntArray(8) }
        var isEmpty = false

        (0 until HEIGHT).forEach { i ->
            (0 until WIDTH).forEach { j ->
                resultArray[i][j] = maze.maz[i][j]
            }
        }

        (0 until HEIGHT).forEach { i ->
            (0 until WIDTH).forEach { j ->
                if(maze.maz[i][j] == WALL) print("*")
                else if(markArray[i][j] == VISIT) print("#")
                else print(" ")
            }
            println()
        }
        var i = 0
        while(!isEmpty){
            val move = stack.pop()
            var x = move.x
            var y = move.y
            resultArray[y][x] = VISIT
            if(i > 0) print("<-")
            print("($x,$y)")
            i++
            isEmpty = stack.isEmpty()
        }
        println()
    }
}

fun main() {
    val robot = Robot()
    println("출구는 (7, 7)")
    robot.findPath(0, 0, 7, 7)
    robot.showPath()
}