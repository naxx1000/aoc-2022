package day2

import LoseDrawWin
import RPS
import RockPaperScissorsStrategy
import util.InputReader

object RockPaperScissors {

    data class Day2Result(
        val rockPaperScissorScoreP1 : Int,
        val rockPaperScissorScoreP2: Int
    )

    fun getRockPaperScissorsScore() : Day2Result {
        val input = InputReader.getDay2Input()
        var scoreP1 = 0
        var scorep2 = 0

        input?.forEach {
            var roundScore = 0
            when (it.player) {
                RPS.Rock -> roundScore += 1
                RPS.Paper -> roundScore += 2
                RPS.Scissors -> roundScore += 3
            }
            roundScore += calculateScore(it)
            scoreP1 += roundScore
        }

        input?.forEach {
            val newStrategy = changePlayerStrategy(it)
            var roundScore = 0
            when (newStrategy.player) {
                RPS.Rock -> roundScore += 1
                RPS.Paper -> roundScore += 2
                RPS.Scissors -> roundScore += 3
            }
            roundScore += calculateScore(newStrategy)
            scorep2 += roundScore
        }

        return Day2Result(scoreP1, scorep2)
    }

    private fun calculateScore(strategy: RockPaperScissorsStrategy) : Int {
        return when (strategy.opponent) {
            RPS.Rock ->
                when (strategy.player) {
                    RPS.Rock -> 3
                    RPS.Paper -> 6
                    RPS.Scissors -> 0
                }
            RPS.Paper ->
                when (strategy.player) {
                    RPS.Rock -> 0
                    RPS.Paper -> 3
                    RPS.Scissors -> 6
                }
            RPS.Scissors ->
                when (strategy.player) {
                    RPS.Rock -> 6
                    RPS.Paper -> 0
                    RPS.Scissors -> 3
                }
        }
    }

    private fun changePlayerStrategy(strategy: RockPaperScissorsStrategy) : RockPaperScissorsStrategy {
        return when (strategy.opponent) {
            RPS.Rock -> {
                when (strategy.player.toLoseDrawWinStrategy()) {
                    LoseDrawWin.Lose -> strategy.copy(player = RPS.Scissors)
                    LoseDrawWin.Draw -> strategy.copy(player = RPS.Rock)
                    LoseDrawWin.Win -> strategy.copy(player = RPS.Paper)
                }
            }
            RPS.Paper -> {
                when (strategy.player.toLoseDrawWinStrategy()) {
                    LoseDrawWin.Lose -> strategy.copy(player = RPS.Rock)
                    LoseDrawWin.Draw -> strategy.copy(player = RPS.Paper)
                    LoseDrawWin.Win -> strategy.copy(player = RPS.Scissors)
                }
            }
            RPS.Scissors -> {
                when (strategy.player.toLoseDrawWinStrategy()) {
                    LoseDrawWin.Lose -> strategy.copy(player = RPS.Paper)
                    LoseDrawWin.Draw -> strategy.copy(player = RPS.Scissors)
                    LoseDrawWin.Win -> strategy.copy(player = RPS.Rock)
                }
            }
        }
    }
}