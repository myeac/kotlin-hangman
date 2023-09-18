[
var board = arrayListOf<ArrayList<String>>()

fun main(args: Array<String>) {

    for (i in 0..2) {
        val row = arrayListOf<String>()
        for (j in 0..2) {
            row.add("")
        }
        board.add(row)
    }

    printBoard()

    //game deevelopment

    var continueGame = true

    do {
        println("ingresar una posicion (eg 1, 1)")

        val input = readlnOrNull() ?: ""
        var x = 0
        var y = 0
        try {
            val positions = input.split(",")
            x = positions[0].trim().toInt()
            y = positions[1].trim().toInt()
            if (board[x - 1][y - 1] != "") {
                println("thata position is alreade taken, try again")
            } else {
                board[x - 1][y - 1] = "X"
                printBoard()
            }

        } catch (e: Exception) {
            println("invalid input, please try again")
        }

    } while (continueGame)

}

fun printBoard() {
    println("----------------")
    for (i in 0..2) {
        for (j in 0..2) {
            when (board[i][j]) {
                "X" -> print("| X ")
                "O" -> print("| O ")
                else -> print("|    ")
            }
        }
        println("|")
        println("----------------")
    }
}

