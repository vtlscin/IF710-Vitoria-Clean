package com.example.wilkinsonmaciel.animport

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_residencial.view.*


class item_residencialAdapter(private val context: Context, private var item_residencialList: MutableList<item_residencial>):
        RecyclerView.Adapter<item_residencialAdapter.item_residencialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): item_residencialViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_residencial, parent, false)
        return item_residencialViewHolder(view)
    }

    override fun getItemCount() = item_residencialList.size

    override fun onBindViewHolder(holder: item_residencialViewHolder, position: Int) {
        holder.bindView(item_residencialList[position])
    }

    class item_residencialViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewNome = itemView.textViewNome
        val textViewPreço = itemView.textViewpreço
        val textViewCheckbox =  itemView.checkBox

        fun bindView(item_residencial: item_residencial) {
            textViewNome.text = item_residencial.nome
            textViewPreço.text = item_residencial.preço
            textViewCheckbox.text = item_residencial.Checkbox
        }
    }
}