fun main() {
    var currentPlayer = 1
    var result: Int
    val table = mutableListOf(
        mutableListOf(' ', ' ', ' '),
        mutableListOf(' ', ' ', ' '),
        mutableListOf(' ', ' ', ' ')
    )

    do {

        drawTable(table)

        print("Enter the coordinates: ")
        var coordinates = readLine()!!.split(" ").toMutableList()

        var x = coordinates[0].toInt()
        var y = coordinates[1].toInt()


        while (x > 3 || x < 1 || y > 3 || y < 1) {
            println("Coordinates should be from 1 to 3!")
            print("Enter the coordinates: ")
            coordinates = readLine()!!.split(" ").toMutableList()
            x = coordinates[0].toInt()
            y = coordinates[1].toInt()
        }

        while (table[x-1][y-1] == 'X' || table[x-1][y-1] == 'O') {
            println("This cell is occupied! Choose another one!")
            print("Enter the coordinates: ")
            coordinates = readLine()!!.split(" ").toMutableList()
            x = coordinates[0].toInt()
            y = coordinates[1].toInt()
            while (x > 3 || x < 1 || y > 3 || y < 1) {
                println("Coordinates should be from 1 to 3!")
                print("Enter the coordinates: ")
                coordinates = readLine()!!.split(" ").toMutableList()
                x = coordinates[0].toInt()
                y = coordinates[1].toInt()
            }
        }


        if (currentPlayer == 1) {
            table[x-1][y-1] = 'X'
        } else if (currentPlayer == 2)
            table[x-1][y-1] = 'O'

        result = checkWinner(table)
        currentPlayer = nextPlayer(currentPlayer)
    } while (result == 0)
    drawTable(table)
    displayWinner(result)
}

fun drawTable(table: MutableList<MutableList<Char>>) {
    println("---------")
    println("| " + table[0][0] + " " + table[0][1] + " " + table[0][2] + " |")
    println("| " + table[1][0] + " " + table[1][1] + " " + table[1][2] + " |")
    println("| " + table[2][0] + " " + table[2][1] + " " + table[2][2] + " |")
    println("---------")
}

fun checkWinner(table: MutableList<MutableList<Char>>): Int {
    if (table[0][0] == 'X' && table[0][1] == 'X' && table[0][2] == 'X' ||
        table[1][0] == 'X' && table[1][1] == 'X' && table[1][2] == 'X' ||
        table[2][0] == 'X' && table[2][1] == 'X' && table[2][2] == 'X' ||
        table[0][0] == 'X' && table[1][0] == 'X' && table[2][0] == 'X' ||
        table[0][1] == 'X' && table[1][1] == 'X' && table[2][1] == 'X' ||
        table[0][2] == 'X' && table[1][2] == 'X' && table[2][2] == 'X' ||
        table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X' ||
        table[2][0] == 'X' && table[1][1] == 'X' && table[0][2] == 'X'
    ) {
        return 1
    }
    if (table[0][0] == 'O' && table[0][1] == 'O' && table[0][2] == 'O' ||
        table[1][0] == 'O' && table[1][1] == 'O' && table[1][2] == 'O' ||
        table[2][0] == 'O' && table[2][1] == 'O' && table[2][2] == 'O' ||
        table[0][0] == 'O' && table[1][0] == 'O' && table[2][0] == 'O' ||
        table[0][1] == 'O' && table[1][1] == 'O' && table[2][1] == 'O' ||
        table[0][2] == 'O' && table[1][2] == 'O' && table[2][2] == 'O' ||
        table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == 'O' ||
        table[2][0] == 'O' && table[1][1] == 'O' && table[0][2] == 'O'
    ) {
        return 2
    }

    return if (table[0][0] != ' ' && table[0][1] != ' ' && table[0][2] != ' ' &&
        table[1][0] != ' ' && table[1][1] != ' ' && table[1][2] != ' ' &&
        table[2][0] != ' ' && table[2][1] != ' ' && table[2][2] != ' ' &&
        table[0][0] != ' ' && table[1][0] != ' ' && table[2][0] != ' ' &&
        table[0][1] != ' ' && table[1][1] != ' ' && table[2][1] != ' ' &&
        table[0][2] != ' ' && table[1][2] != ' ' && table[2][2] != ' ' &&
        table[0][0] != ' ' && table[1][1] != ' ' && table[2][2] != ' ' &&
        table[2][0] != ' ' && table[1][1] != ' ' && table[0][2] != ' '
    ) {
        3
    }
    else 0
}


fun nextPlayer(currentPlayer: Int): Int {
    return if (currentPlayer == 1) {
        2
    } else 1
}

fun displayWinner(result: Int) {
    if (result == 1) {
        println("X wins")
    }
    if (result == 2) {
        println("O wins")
    }

    if (result == 3) {
        println("Draw")
    }
}