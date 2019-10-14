fun main(): Unit {
    val rock: String = "rock"
    val scissors: String = "scissors"
    val paper: String = "paper"
    val player: String = "player"
    val computer: String = "Computer"
    val none: String = "Nobody"
    var playerWins: Int = 0
    var compWins: Int = 0
    println("Welcome to Rock Paper Scissors!")
    println("Input number of rounds won for a set win: ")
    var winCondition: Int = 0
    var isDigit: Boolean = false
    while (!isDigit) {
        val strInput: String? = readLine()
        if (!strInput.isNullOrEmpty()) {
            isDigit = true
            for (c in strInput) {
                if (!c.isDigit()) {
                    isDigit = false
                    break
                }
            }
            if (isDigit) {
                winCondition = strInput.toInt()
            }
        }
    }

    while (playerWins != winCondition && compWins != winCondition) {
        println("Choose rock, paper, or scissors")
        var input = readLine()
        while (input != rock && input != paper && input != scissors) {
            input = readLine()
            println("Choose rock, paper, or scissors")
        }
        val randInt = (0..2).random()
        var computerInput: String = ""
        if (randInt == 0) {
            computerInput = rock
            println("Computer chose rock")
        } else if (randInt == 1) {
            computerInput = paper
            println("Computer chose paper")
        } else if (randInt == 2) {
            computerInput = scissors
            println("Computer chose scissors")
        }

        var roundWinner: String = none
        if (input != computerInput) {
            if (input == rock) {
                if (computerInput == paper) {
                    roundWinner = computer
                    compWins++
                } else if (computerInput == scissors) {
                    roundWinner = player
                    playerWins++
                }
            } else if (input == scissors) {
                if (computerInput == rock) {
                    roundWinner = computer
                    compWins++
                } else if (computerInput == paper) {
                    roundWinner = player
                    playerWins++
                }
            } else if (input == paper) {
                if (computerInput == scissors) {
                    roundWinner = computer
                    compWins++
                } else if (computerInput == rock) {
                    roundWinner = player
                    playerWins++
                }
            }
        }
        println("$roundWinner wins the round\n$playerWins - $compWins")

    }


    if (playerWins > compWins) {
        println("Player wins the set!")
    } else if (compWins > playerWins) {
        println("Computer wins the set... :(")
    } else {
        println("It's a draw")
    }
}