package com.trdz.task11as.w_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trdz.task11as.databinding.ActivityMainBinding
import com.trdz.task11as.x_presenter.MainPresenter
import com.trdz.task11as.z_utility.CONT

class MainActivity: AppCompatActivity(), MainView {

	private var binding: ActivityMainBinding? = null
	private val presenter = MainPresenter(this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding?.root)
		buttonBinds()
	}

	private fun buttonBinds() {
		binding?.run {
			btnCounter1.setOnClickListener { btnCounter1.text = presenter.counterClick(0).toString() }
			btnCounter2.setOnClickListener { btnCounter2.text = presenter.counterClick(1).toString() }
			btnCounter3.setOnClickListener { btnCounter3.text = presenter.counterClick(2).toString() }
		}
		presenter.refresh()
	}

	override fun setup(array: IntArray) {
		binding?.run {
			btnCounter1.text = array[0].toString()
			btnCounter2.text = array[1].toString()
			btnCounter3.text = array[2].toString()
		}
	}


	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		binding?.run {
			outState.putIntArray(CONT, intArrayOf(
				btnCounter1.text.toString().toInt(),
				btnCounter2.text.toString().toInt(),
				btnCounter3.text.toString().toInt(),
			))
		}
	}

	override fun onRestoreInstanceState(savedInstanceState: Bundle) {
		super.onRestoreInstanceState(savedInstanceState)
		savedInstanceState.getIntArray(CONT)?.let { presenter.refresh(it) }
	}

}