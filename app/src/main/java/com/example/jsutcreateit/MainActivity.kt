package com.example.jsutcreateit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        for(i in 1..5) {
            val button = Button(this)
            button.text = "Позиция $i"
            button.gravity = Gravity.CENTER
            button.setOnClickListener {
                initRoulette(i)
            }
            buttons_layout.addView(button)
        }
    }

    private fun initRoulette(index: Int) {
        buttons_layout.removeAllViews()
        val listRoulette = ArrayList<RecyclerView>()
        val max = if(index == 3 || index == 4) { 2 } else 1
        for(i in 0..max) {
            val roulette = RecyclerView(this)
            roulette.layoutManager = LinearLayoutManager(this)
            roulette.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1f
            )
            roulette.adapter = RouletteAdapter(this)
            roulette.smoothScrollToPosition(20000)
            letters_layout.addView(roulette)
            listRoulette.add(roulette)
        }
        finish_button.visibility = View.VISIBLE
        finish_button.setOnClickListener {
            var count = max
            listRoulette.forEach {
                it.smoothScrollToPosition(
                    (it.layoutManager as LinearLayoutManager).findLastVisibleItemPosition() + index * 2 - count +
                            (11 - (it.layoutManager as LinearLayoutManager).findLastVisibleItemPosition() % 12) +
                            if(index == 3) 1 else if(index == 4) 2 else if(index == 5) 2 else 0
                )
                count--
            }
            finish_button.setOnClickListener(null)
        }
    }

    /**
        ju - 4: Леша(Полоз): Команда, которую и достижения которой вы запомните надолго
        st - 2: Юля: Команда, преодолевающая трудности и препятствия, какие бы не встали на пути
        cre - 1: Я: Мы команда энергичных и талантливых, сильных и уверенных в себе
        ate - 3: Катя: Команда, покоряющая вершины успеха, созидатели и творцы
        it - 5: Леша(Брук): Команда, которая не тратит время в пустую, а всегда что-то создает

        Я: Мы команда Just...
        Все: Create It!
     */
}
