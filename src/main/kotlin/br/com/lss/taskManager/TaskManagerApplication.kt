package br.com.lss.taskManager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class TaskManagerApplication

fun main(args: Array<String>) {
    runApplication<TaskManagerApplication>(*args)
}


//
//fun diagonalDifference(ranked: Array<Int>, player: Array<Int>): Array<Int> {
//    //val playersMutableList = player.toMutableList()
//    var rankedMutableList = ranked.toMutableList()
//    var resultMutableList = mutableListOf<Int>()
//    var positionsMutableList = mutableListOf<Int>()
//
//
//    for (v in player) {
//        positionsMutableList.add(1)
//        rankedMutableList.add(v)
//        rankedMutableList.sortByDescending { it }
//
//
//        for ((index, number) in rankedMutableList.withIndex()) {
//            if (index > 0) {
//                if (number == rankedMutableList[index - 1])
//                    positionsMutableList.add(positionsMutableList[positionsMutableList.lastIndex])
//                else positionsMutableList.add(positionsMutableList[positionsMutableList.lastIndex] + 1)
//            }
//        }
//
//        resultMutableList.add(positionsMutableList[rankedMutableList.indexOf(v)])
//
//        println("esse é o ranking ${rankedMutableList.toString()}")
//        println("essas sao as posicoes ${positionsMutableList.toString()}")
//        println("a do usuarios inseridos: ${resultMutableList.toString()}")
//        positionsMutableList = mutableListOf()
//
//    }
//    return resultMutableList.toTypedArray()
//}
//
//fun diagonalDifferenceTesting(ranked: Array<Int>, player: Array<Int>): Array<Int> {
//    //val playersMutableList = player.toMutableList()
//    var rankedMutableList = LinkedList<Int>()
//    rankedMutableList.addAll(ranked)
//    val result = Array<Int>(player.size) { 0 }
//    //rankedMutableList.add(4,player[0])
//    println(rankedMutableList)
//    for ((i, v) in player.withIndex()) {
//        val positions = mutableListOf<Int>()
//        positions.add(1)
//        var vPosition = 0
//        for ((index, value) in rankedMutableList.withIndex()) {
//            if (v > rankedMutableList[index]) {
//                println("ACHEI O LUGAR! posicação $index para o v $v")
//                vPosition = index
//                if (index == 0) result[i] = positions[positions.lastIndex]
//                else result[i] = positions[positions.lastIndex] + 1
//                break
//            } else if (index == rankedMutableList.size - 1) {
//                println("AQUI FOI ATÉ O FINAL HEIN ")
//                vPosition = rankedMutableList.size
//                positions.add(positions[positions.lastIndex] + 1)
//                result[i] = positions[positions.lastIndex] + 1
//
//                break
//            } else if (v == rankedMutableList[index]) {
//                println("É IGUAL HEIN $v")
//                result[i] = positions[positions.lastIndex] + 1
//                positions.add(positions[positions.lastIndex])
//                vPosition = index
//
//                break
//            }
//            if (index > 0) {
//                if (rankedMutableList[index] == rankedMutableList[index - 1]) {
//                    positions.add(positions[positions.lastIndex])
//                } else positions.add(positions[positions.lastIndex] + 1)
//            }
//        }
//        rankedMutableList.add(vPosition, v)
//
//        println("ranking agora hein ${rankedMutableList.toMutableList()}")
//        println("posicoes hein $positions")
//        println("resultado até entao  hein ${result.toMutableList()}")
//        println("------------------------------------------------------------------------------------------------------------------------")
//    }
//    println("novo array hein $rankedMutableList")
//    println("resultadap hein ${result.toMutableList()}")
//    return result
//}

