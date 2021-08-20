package br.com.lss.taskManager.util

interface Mapper<T, U> {

    fun map(t: T):U
}
