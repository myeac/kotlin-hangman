import kotlin.random.Random

val words = listOf(
    "sugar",
    "tall",
    "smile",
    "boiling",
    "steer",
    "loutish",
    "fluttering",
    "humdrum",
    "territory",
    "nutty",
    "vessel",
    "unkempt",
    "shape",
    "wasteful",
    "marble",
    "cup",
    "bat",
    "pop",
    "knowing",
    "parsimonious",
)

var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main(args: Array<String>) {

    setUpGame()

}

fun setUpGame() {
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex]
    println(word)
    for (i in word.indices) {
        guesses.add('_')
    }
    var gameOver = false

    do {
        printGameStatus()
        println("please enter a letter:")

        val input = readlnOrNull() ?: ""
        if (input.isEmpty()) {
            println("that's not a valid iomput. Please try again")
        } else {
            val letter = input[0].lowercaseChar()
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter)
                        guesses[i] = letter
                }
                if (!guesses.contains('_'))
                    gameOver = true
            } else {
                println("sorry, that's not part of the word")
                remainingGuesses--
                mistakes++
                if (mistakes == 6)
                    gameOver = true
            }
        }
    } while (!gameOver)

    if (mistakes == 6) {
        printGameStatus()
        printGameOver()
    } else {
        println("\ncongratulations you win")
        println("the word was \n$word")
    }

}

fun printGameStatus() {
    when (mistakes) {
        0 -> print0Mistakes()
        1 -> print1Mistakes()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
        else -> printGameOver()
    }
    print("word: ")
    for (element in guesses)
        print(" $element ")
    println("\nyou have $remainingGuesses guess(es) left")
}

fun printGameOver() {
    println("------------------------------------")
    println("perdiste! the word was \n$word")
    println("------------------------------------")
}

fun print0Mistakes() {
    println("   |-----|-")
    println("   |     | ")
    println("   |       ")
    println("   |       ")
    println("   |       ")
    println("   |       ")
    println("  /|\\     ")
    println(" / | \\    ")
    println("/  |  \\   ")
    println()
}

fun print1Mistakes() {
    println("   |-----|-")
    println("   |     | ")
    println("   |     O ")
    println("   |       ")
    println("   |       ")
    println("   |       ")
    println("  /|\\     ")
    println(" / | \\    ")
    println("/  |  \\   ")
    println()
}

fun print2Mistakes() {
    println("   |-----|-")
    println("   |     | ")
    println("   |     O ")
    println("   |     | ")
    println("   |     | ")
    println("   |       ")
    println("  /|\\     ")
    println(" / | \\    ")
    println("/  |  \\   ")
    println()
}

fun print3Mistakes() {
    println("   |-----|-")
    println("   |     | ")
    println("   |     O ")
    println("   |    /| ")
    println("   |     | ")
    println("   |       ")
    println("  /|\\     ")
    println(" / | \\    ")
    println("/  |  \\   ")
    println()
}

fun print4Mistakes() {
    println("   |-----|-")
    println("   |     | ")
    println("   |     O ")
    println("   |    /|\\")
    println("   |     | ")
    println("   |       ")
    println("  /|\\     ")
    println(" / | \\    ")
    println("/  |  \\   ")
    println()
}

fun print5Mistakes() {
    println("   |-----|-")
    println("   |     | ")
    println("   |     O ")
    println("   |    /|\\")
    println("   |     | ")
    println("   |    /  ")
    println("  /|\\     ")
    println(" / | \\    ")
    println("/  |  \\   ")
    println()
}

fun print6Mistakes() {
    println("   |-----|-")
    println("   |     | ")
    println("   |     O ")
    println("   |    /|\\")
    println("   |     | ")
    println("   |    / \\")
    println("  /|\\     ")
    println(" / | \\    ")
    println("/  |  \\   ")
    println()
}
