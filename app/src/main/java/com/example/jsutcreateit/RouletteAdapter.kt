package com.example.jsutcreateit

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RouletteAdapter(private val context: Context) : RecyclerView.Adapter<RouletteAdapter.RouletteViewHolder>() {

    private val letters = listOf(
        R.drawable.j_1,
        R.drawable.u_2,
        R.drawable.s_3,
        R.drawable.t_4,
        R.drawable.c_5,
        R.drawable.r_6,
        R.drawable.e_7,
        R.drawable.a_8,
        R.drawable.t_9,
        R.drawable.e_10,
        R.drawable.i_11,
        R.drawable.t_12
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouletteViewHolder {
        val letter = ImageView(context)
        letter.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        letter.scaleType = ImageView.ScaleType.FIT_XY
        return RouletteViewHolder(letter)
    }

    override fun getItemCount() = Int.MAX_VALUE

    override fun onBindViewHolder(holder: RouletteViewHolder, position: Int) {
        holder.bind(position)
    }


    inner class RouletteViewHolder(private val view: ImageView) : RecyclerView.ViewHolder(view) {

        fun bind(position: Int) {
            val letter = letters[position % 12]
            view.setImageResource(letter)
        }
    }
}