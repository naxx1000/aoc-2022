data class RockPaperScissorsStrategy(
    val opponent: RPS,
    val player: RPS
)

sealed class RPS {
    object Rock : RPS() {
        override fun toString(): String {
            return "Rock"
        }
    }
    object Paper : RPS() {
        override fun toString(): String {
            return "Paper"
        }
    }
    object Scissors : RPS() {
        override fun toString(): String {
            return "Scissor"
        }
    }

    fun toLoseDrawWinStrategy() : LoseDrawWin {
        return when (this) {
            Rock -> LoseDrawWin.Lose
            Paper -> LoseDrawWin.Draw
            Scissors -> LoseDrawWin.Win
        }
    }
}

sealed class LoseDrawWin {
    object Lose : LoseDrawWin() {
        override fun toString(): String {
            return "Lose"
        }
    }
    object Draw : LoseDrawWin() {
        override fun toString(): String {
            return "Draw"
        }
    }
    object Win : LoseDrawWin() {
        override fun toString(): String {
            return "Win"
        }
    }
}