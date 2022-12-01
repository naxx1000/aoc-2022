package util

object InputReader {

    fun getDay1Input(): List<String>? {
        val text = javaClass.getResource("/day1.txt")?.readText()
        return text?.split("\n")?.map { it.trim() }
    }
}