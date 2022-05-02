package fibo

class Fibonacci(var number: Int) {
    private var value: IntArray = IntArray(number)

    fun fibonacciRecur(n: Int): Int {
        if(n == 0) return 0
        if(n == 1) return 1
        return fibonacciRecur(n - 1) +fibonacciRecur(n - 2)
    }

    fun fibonacciIter(n: Int): Int {
        var ppre = 0
        var pre = 1

        var current = 0

        if(n == 0) return 0
        if(n == 1) return 1

        (2 .. n).forEach { _ ->
            current = ppre + pre
            ppre = pre
            pre = current
        }

        return current
    }

    fun fibonacciMem(n: Int): Int {
        var result = 0
        value[0] = 0
        value[1] = 1

        if(n == 0) return value[0]
        if(n == 1) return value[1]

        (2..n).forEach { i ->
            value[i] = value[i - 1] + value[i - 2]
            result = value[i]
        }
        return result
    }
}

fun main() {
    val fib = Fibonacci(100)

    var result = fib.fibonacciRecur(10)
    println("result: $result")

    result = fib.fibonacciIter(10)
    println("result: $result")

    result = fib.fibonacciMem(10)
    println("result: $result")
}