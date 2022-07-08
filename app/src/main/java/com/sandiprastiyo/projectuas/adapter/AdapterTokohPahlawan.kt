package com.sandiprastiyo.projectuas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandiprastiyo.projectuas.databinding.ListTokohPahlawanBinding
import com.sandiprastiyo.projectuas.model.Tokoh

class AdapterTokohPahlawan( private val context : Context,
                            private val data : List<Tokoh>,
                            private val itemclick : OnClickListener)
                : RecyclerView.Adapter<AdapterTokohPahlawan.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListTokohPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data.get(position)
        holder.foto.setImageResource(item.foto ?:0)
        holder.nama.text = item.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data.size ?:0

    inner class ViewHolder( val binding  : ListTokohPahlawanBinding): RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama


    }
    interface OnClickListener {
        fun detailData(item : Tokoh?)
    }


}