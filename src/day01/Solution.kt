package day01

import println
import readInput
import kotlin.math.abs

const val day = "01"

fun parseInputAsHistoriansLists(input: List<String>): Pair<List<Int>, List<Int>> =
    input.fold(Pair(mutableListOf<Int>(), mutableListOf<Int>())) { lists, line ->
        val first = line.substringBefore(' ').toInt()
        val second = line.substringAfterLast(' ', "").toInt()

        lists.apply {
            this.first.add(first)
            this.second.add(second)
        }
    }

fun main() {
    fun part1(input: List<String>): Int {
        val historiansLists = parseInputAsHistoriansLists(input)

        val distance = historiansLists.first.sorted()
            .zip(historiansLists.second.sorted())
            .sumOf { (f, s) -> abs(f - s) }

        return distance
    }

    fun part2(input: List<String>): Int {
        val historiansLists = parseInputAsHistoriansLists(input)

        val similarity = historiansLists.first.sumOf { s ->
            val count = historiansLists.second.count { it == s }
            s * count
        }

        return similarity
    }

    // Part 1
    val testInput1 = readInput(day, "test_input_1")
    check(part1(testInput1) == 11)

    // Part 2
    val testInput2 = readInput(day, "test_input_2")
    check(part2(testInput2) == 31)

    println("Solution:")
    val input = readInput(day, "input")
    part1(input).println()
    part2(input).println()
}
