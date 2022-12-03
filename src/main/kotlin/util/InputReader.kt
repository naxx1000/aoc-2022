package util

import RockPaperScissorsStrategy

object InputReader {

    fun getDay1Input(): List<String>? {
        val text = javaClass.getResource("/day1.txt")?.readText()
        return text?.split("\n")?.map { it.trim() }
    }

    fun getDay2Input(): List<RockPaperScissorsStrategy>? {
        val text = javaClass.getResource("/day2.txt")?.readText()
        val list = text?.split("\n")
        val day2Input = list?.map {
            val strategyPair = it.split(" ")
            val opponent = when (strategyPair[0]) {
                "A" -> RPS.Rock
                "B" -> RPS.Paper
                "C" -> RPS.Scissors
                else -> throw IllegalStateException()
            }
            val player = when (strategyPair[1]) {
                "X" -> RPS.Rock
                "Y" -> RPS.Paper
                "Z" -> RPS.Scissors
                else -> throw IllegalStateException()
            }
            RockPaperScissorsStrategy(opponent, player)
        }
        return day2Input
    }

    fun getDay3Input(): List<String>? {
        val text = javaClass.getResource("/day3.txt")?.readText()
        val input = text?.split("\n")?.map { it.trim() }
        return input
    }
}