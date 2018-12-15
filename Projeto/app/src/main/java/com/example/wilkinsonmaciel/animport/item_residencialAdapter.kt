package com.example.wilkinsonmaciel.animport

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import kotlinx.android.synthetic.main.item_residencial.view.*


internal class item_residencialAdapter(private val context: Context, private var item_residencialList: MutableList<item_residencial>):
        RecyclerView.Adapter<item_residencialAdapter.item_residencialViewHolder>() {

    var checkeditem = ArrayList<item_residencial>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): item_residencialViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_residencial, parent, false)
        return item_residencialViewHolder(view)
    }

    override fun getItemCount() = item_residencialList.size

    override fun onBindViewHolder(holder: item_residencialViewHolder, position: Int) {
        val item = item_residencialList[position]
        holder.Nome.text = item.nome
        holder.Preço.text = item.preço
        holder.Checkbox.isChecked = item.isSelected


        holder.setItemClickListener(object  : item_residencialViewHolder.ItemClickListener{
            override fun onItemClick(v: View, pos: Int) {
                val CheckBox = v as CheckBox
                val atualitem = item_residencialList[pos]

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

    internal class item_residencialViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
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


        fun bindView(item_residencial: item_residencial) {
            Nome.text = item_residencial.nome
            Preço.text = item_residencial.preço
            Checkbox.text = item_residencial.Checkbox
        }
    }

}


