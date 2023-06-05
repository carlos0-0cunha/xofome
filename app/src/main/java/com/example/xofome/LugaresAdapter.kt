package com.example.xo

import com.example.xfome.R
import com.example.xofome.LugarModelo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class LugaresAdapter(private val lugarList: ArrayList<LugarModelo>) :
        RecyclerView.Adapter<LugaresAdapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lugares_list_item, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentEmp = lugarList[position]
            holder.tvLugarName.text = currentEmp.empNomeLocal
        }

        override fun getItemCount(): Int {
            return lugarList.size
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val tvLugarName : TextView = itemView.findViewById(R.id.tvLugarName)


        }
//    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
//
//        val tvEmpName : TextView = itemView.findViewById(R.id.tvEmpName)
//
//        init {
//            itemView.setOnClickListener {
//                clickListener.onItemClick(adapterPosition)
//            }
//        }
//
//    }

    }