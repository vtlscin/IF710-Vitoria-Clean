package com.example.wilkinsonmaciel.animport


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.item_automotivo.view.*

class item_automotivoAdapter(private val context: Context, private var item_automotivoList: MutableList<item_automotivo>):
        RecyclerView.Adapter<item_automotivoAdapter.item_automotivoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): item_automotivoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_automotivo, parent, false)
        return item_automotivoViewHolder(view)
    }

    override fun getItemCount() = item_automotivoList.size

    override fun onBindViewHolder(holder: item_automotivoViewHolder, position: Int) {
        holder.bindView(item_automotivoList[position])
    }

    class item_automotivoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewNome = itemView.textViewNome
        val textViewPreço = itemView.textViewpreço
        val textViewCheckbox =  itemView.checkBox

        fun bindView(item_automotivo: item_automotivo) {
            textViewNome.text = item_automotivo.nome
            textViewPreço.text = item_automotivo.preço
            textViewCheckbox.text = item_automotivo.Checkbox
        }
    }
}