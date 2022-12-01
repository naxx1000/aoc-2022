package day1

import util.InputReader

object CalorieCounting {

    data class Day1Result(
        val highestCalorieCount: Int,
        val top3CalorieCountSum: Int
    )

    /**
     * From a list of elfs holding provisions of some calories, returns the
     * highest count of calories held by a single elf
     */
    fun getHighestCalorieElf() : Day1Result {
        val input = InputReader.getDay1Input()
        val elfCalorieList: MutableList<Int> = mutableListOf()

        var acc = 0
        input?.forEachIndexed { index, s ->
            if (s.isBlank() || index == input.lastIndex) {
                elfCalorieList.add(acc)
                acc = 0
            } else {
                acc += s.toInt()
            }
        }
        elfCalorieList.sort()
        return Day1Result(elfCalorieList.max(), elfCalorieList.takeLast(3).sum())
    }
}