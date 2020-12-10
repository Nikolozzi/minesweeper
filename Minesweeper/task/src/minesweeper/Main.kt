package minesweeper

import java.util.*

class Board(val size: Int, private val mines: Int) {
    private val board: Array<Array<Char>> = Array(size) {
        Array(size) { '.' }
    }

    private val mineCells = mutableSetOf<Pair<Int, Int>>()
    private val discoveredMines = mutableListOf<Pair<Int, Int>>()
    private val nonMineCells = mutableListOf<Pair<Int, Int>>()
    private var isFreeMovePlayed = false
    private var visitedCells = 0

    init {
        val indexes = (0 until size * size).toMutableList()
        indexes.shuffle()
        val randomMineIndexes = indexes.take(mines)
        for (mineInd in randomMineIndexes) {
            val row = mineInd / size
            val col = mineInd % size
            mineCells.add(Pair(row, col))
        }
    }

    /**
     * Main game loop, terminates when the player wins
     */
    fun playGame() {
        val scanner = Scanner(System.`in`)
        while (true) {
            //win by marking all mine cells correctly, or by revealing all safe cells except mines
            if ((discoveredMines.size == mines && nonMineCells.isEmpty()) || size * size - visitedCells == mines) {
                println("Congratulations! You found all the mines!")
                break
            }

            println("Set/unset mine marks or claim a cell as free: > ")
            val x = scanner.nextInt() //[1,size] - column
            val y = scanner.nextInt() //[1,size] - row
            val command = scanner.next()
            if (board[y - 1][x - 1].isDigit()) {
                println("There is a number here!")
                continue
            }

            when (command) {
                "free" -> {
                    if (!freeAllSurroundingCells(x, y)) { //failed, stepped on a mine
                        println("You stepped on a mine and failed!")
                        break
                    }
                }
                "mine" -> {
                    markOrUnmarkCell(Pair(y - 1, x - 1))
                }
            }
        }
    }

    /**
     * marks a free cell with '*' char, or, clears it back to '.'
     * this is done to discover mine cells
     */
    private fun markOrUnmarkCell(cell: Pair<Int, Int>) {
        val i = cell.first
        val j = cell.second
        if (board[i][j] == '.') {
            board[i][j] = '*'
            if (mineCells.contains(cell)) {
                discoveredMines.add(cell)
            } else {
                nonMineCells.add(cell)
            }
        } else if (board[i][j] == '*') {
            board[i][j] = '.'
            if (mineCells.contains(cell)) {
                discoveredMines.remove(cell)
            } else {
                nonMineCells.remove(cell)
            }
        }

        printBoard()
    }

    /**
     * traverses all reachable cells from the given cell and marks them either '/'(if it doesn't have a neighbouring mine)
     * or with a number in [1..size] describing number of mines around this cell
     */
    private fun freeAllSurroundingCells(x: Int, y: Int): Boolean {
        //check if this cell is free, if not, move the mine to a free cell, this happens only for the first 'free' action
        val cell = Pair(y - 1, x - 1) // x - column ind, y - row ind
        if (!isFreeMovePlayed && mineCells.contains(cell)) {
            mineCells.remove(cell)
            mineCells.add(getNewCellFor(cell))
        } else if (isFreeMovePlayed && mineCells.contains(cell)) {
            printBoard(showMines = true)
            return false
        }
        isFreeMovePlayed = true

        exploreSurroundingCells(cell)
        printBoard()

        return true
    }

    private fun exploreSurroundingCells(cell: Pair<Int, Int>) {
        val i = cell.first
        val j = cell.second
        val validNeighboringCells = mutableSetOf<Pair<Int, Int>>()
        var surroundingMines = 0
        visitedCells += 1
        //left cell exists and it's not visited
        if (j - 1 >= 0 && board[i][j - 1] != '/' && !board[i][j - 1].isDigit()) {
            val leftCell = Pair(i, j - 1)
            if (!mineCells.contains(leftCell)) {
                validNeighboringCells.add(leftCell)
            } else {
                surroundingMines += 1
            }
        }
        //right cell exists and it's not visited
        if (j + 1 < size && board[i][j + 1] != '/' && !board[i][j + 1].isDigit()) {
            val rightCell = Pair(i, j + 1)
            if (!mineCells.contains(rightCell)) {
                validNeighboringCells.add(rightCell)
            } else {
                surroundingMines += 1
            }
        }
        //up cell exists and it's not visited
        if (i - 1 >= 0 && board[i - 1][j] != '/' && !board[i - 1][j].isDigit()) {
            val upCell = Pair(i - 1, j)
            if (!mineCells.contains(upCell)) {
                validNeighboringCells.add(upCell)
            } else {
                surroundingMines += 1
            }
        }
        //down cell exists and it's not visited
        if (i + 1 < size && board[i + 1][j] != '/' && !board[i + 1][j].isDigit()) {
            val downCell = Pair(i + 1, j)
            if (!mineCells.contains(downCell)) {
                validNeighboringCells.add(downCell)
            } else {
                surroundingMines += 1
            }
        }
        //top-left diagonal cell exists and it's not visited
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] != '/' && !board[i - 1][j - 1].isDigit()) {
            val topLeftCell = Pair(i - 1, j - 1)
            if (!mineCells.contains(topLeftCell)) {
                validNeighboringCells.add(topLeftCell)
            } else {
                surroundingMines += 1
            }
        }
        //top-right diagonal cell exists and it's not visited
        if (i - 1 >= 0 && j + 1 < size && board[i - 1][j + 1] != '/' && !board[i - 1][j + 1].isDigit()) {
            val topRightCell = Pair(i - 1, j + 1)
            if (!mineCells.contains(topRightCell)) {
                validNeighboringCells.add(topRightCell)
            } else {
                surroundingMines += 1
            }
        }
        //bottom-left diagonal cell exists and it's not visited
        if (i + 1 < size && j - 1 >= 0 && board[i + 1][j - 1] != '/' && !board[i + 1][j - 1].isDigit()) {
            val bottomLeftCell = Pair(i + 1, j - 1)
            if (!mineCells.contains(bottomLeftCell)) {
                validNeighboringCells.add(bottomLeftCell)
            } else {
                surroundingMines += 1
            }
        }
        //bottom-right diagonal cell exists and it's not visited
        if (i + 1 < size && j + 1 < size && board[i + 1][j + 1] != '/' && !board[i + 1][j + 1].isDigit()) {
            val bottomRightCell = Pair(i + 1, j + 1)
            if (!mineCells.contains(bottomRightCell)) {
                validNeighboringCells.add(bottomRightCell)
            } else {
                surroundingMines += 1
            }
        }

        if (surroundingMines > 0) {
            board[i][j] = Character.forDigit(surroundingMines, 10)
        } else {
            board[i][j] = '/'
            //recursive call for all neighbouring cells
            for (c in validNeighboringCells) {
                exploreSurroundingCells(c)
            }
        }
    }

    private fun getNewCellFor(minePair: Pair<Int, Int>): Pair<Int, Int> {
        for (i in board.indices) {
            for (j in board.indices) {
                if (minePair.first != i && minePair.second != j && !mineCells.contains(Pair(i, j))) {
                    return Pair(i, j)
                }
            }
        }

        return Pair(-1, -1)
    }

    fun printBoard(showMines: Boolean = false) {
        print(" |")
        for (i in 1..size) {
            print(i)
        }
        println("|")
        print("-|")
        repeat(size) {
            print("-")
        }
        println("|")

        if (showMines) {
            for (mine in mineCells) {
                board[mine.first][mine.second] = 'X'
            }
        }

        for (i in board.indices) {
            print("${i + 1}|")
            for (j in board[i].indices) {
                print(board[i][j])
            }
            print("|")
            println()
        }

        print("-|")
        repeat(size) {
            print("-")
        }
        println("|")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    println("How many mines do you want on the field? > ")
    val mines = scanner.nextInt()
    val board = Board(size = 9, mines)
    board.printBoard()
    board.playGame()
}
