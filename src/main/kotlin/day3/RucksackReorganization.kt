package day3

import util.InputReader

object RucksackReorganization {

    fun getSumOfDuplicateItemTypes(): Int {

        val input = InputReader.getDay3Input()
        var sum = 0

        input?.forEach { item ->
            val itemLength = item.length
            val firstHalf = item.take(itemLength / 2).groupBy { it.getValueByChar() }
            val secondHalf = item.takeLast(itemLength / 2).groupBy { it.getValueByChar() }
            val valueOfDuplicateItemType = firstHalf.keys.first { firstHalfType ->
                secondHalf.containsKey(firstHalfType)
            }
            sum += valueOfDuplicateItemType
        }

        return sum
    }

    fun getSumOfDuplicateItemTypesOfGroupsOfThrees(): Int {

        val input = InputReader.getDay3Input()
        var sum = 0

        input?.forEveryThree { s1, s2, s3, _ ->
            val elf1 = s1.groupBy { it.getValueByChar() }
            val elf2 = s2.groupBy { it.getValueByChar() }
            val elf3 = s3.groupBy { it.getValueByChar() }
            val valueOfDuplicateItemType = elf1.keys.first { key1 ->
                elf2.containsKey(key1) && elf3.containsKey(key1)
            }
            sum += valueOfDuplicateItemType
        }
        return sum
    }

    private inline fun <T> Iterable<T>.forEveryThree(action: (s1: T, s2: T, s3: T, index: Int) -> Unit) {
        for ((index, i) in (0 until count() step 3).withIndex()) {
            action(elementAt(i), elementAt(i+1), elementAt(i+2), index)
        }
    }
}

/**
* Assumption is that char byte values are:
* 'a'=97
* 'b'=98
* 'A'=65
* 'B'=66
*/
fun Char.getValueByChar(): Int {
    return if (isLowerCase()) {
        code - 96
    } else {
        code - 38
    }
}