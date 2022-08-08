package com.trdz.task11as.y_model

interface Repository {
	fun next(index: Int): Int
	fun set(array: IntArray)
}