package com.trdz.task11as.x_presenter

import com.trdz.task11as.w_view.MainView
import com.trdz.task11as.y_model.CountersModel
import com.trdz.task11as.y_model.Repository

class MainPresenter(
	private val view: MainView,
	private val repository: Repository = CountersModel(),
) {

	fun counterClick(id: Int): Int {
		return repository.next(id)
	}

	fun refresh(array: IntArray = intArrayOf(0, 0, 0)) {
		repository.set(array)
		view.setup(array)
	}

}