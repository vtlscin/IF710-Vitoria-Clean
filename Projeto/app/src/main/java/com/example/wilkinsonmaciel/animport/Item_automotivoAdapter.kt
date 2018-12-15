package com.example.wilkinsonmaciel.animport


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.item_automotivo.view.*

internal class item_automotivoAdapter(private val context: Context, private var item_automotivoList: MutableList<item_automotivo>):
        RecyclerView.Adapter<item_automotivoAdapter.item_automotivoViewHolder>() {

        var checkeditem = ArrayList<item_automotivo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): item_automotivoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_automotivo, parent, false)
        return item_automotivoViewHolder(view)
    }

    override fun getItemCount() = item_automotivoList.size

    override fun onBindViewHolder(holder: item_automotivoViewHolder, position: Int) {
        val item = item_automotivoList[position]
        holder.Nome.text = item.nome
        holder.Preço.text = item.preço
        holder.Checkbox.isChecked = item.isSelected

        holder.setItemClickListener(object  : item_automotivoViewHolder.ItemClickListener{
            override fun onItemClick(v: View, pos: Int) {
                val CheckBox = v as CheckBox
                val atualitem = item_automotivoList[pos]

                if (CheckBox.isChecked){
                    atualitem.isSelected = true
                    checkeditem.add(atualitem)
                } else if (!CheckBox.isChecked){
                    atualitem.isSelected = false
                    checkeditem.remove(atualitem)
                }

            }
        })
    }

    internal class item_automotivoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var Nome: TextView
        var Preço: TextView
        var Checkbox: CheckBox

        lateinit var myItemClickListener: ItemClickListener

        init {
            Nome = itemView.findViewById(R.id.textViewNome)
            Preço = itemView.findViewById(R.id.textViewpreço)
            Checkbox = itemView.findViewById(R.id.checkBox)

            Checkbox.setOnClickListener(this)
        }

        fun setItemClickListener(ic: ItemClickListener){
            this.myItemClickListener = ic
        }

        override fun onClick(v: View){
            this.myItemClickListener.onItemClick(v, layoutPosition)
        }

       internal interface ItemClickListener{

            fun onItemClick(v: View, pos: Int)
        }


        fun bindView(item_automotivo: item_automotivo) {
            Nome.text = item_automotivo.nome
            Preço.text = item_automotivo.preço
            Checkbox.text = item_automotivo.Checkbox
        }
    }
}