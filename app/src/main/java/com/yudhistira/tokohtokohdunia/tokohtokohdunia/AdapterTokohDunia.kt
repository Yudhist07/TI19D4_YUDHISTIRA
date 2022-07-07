package com.yudhistira.tokohtokohdunia.tokohtokohdunia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yudhistira.tokohtokohdunia.databinding.ListTokohDuniaBinding
import com.yudhistira.tokohtokohdunia.model.Tokoh

class AdapterTokohDunia(private val context : Context,
                        private var data : List<Tokoh>?,
                        private val itemclik : OnClickListener)
                : RecyclerView.Adapter<AdapterTokohDunia.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListTokohDuniaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.name.text = item?.name

        holder.itemView.setOnClickListener {
            itemclik.detailData(item)
        }
    }

    override fun getItemCount(): Int =data?.size ?:0

    inner class ViewHolder(val binding : ListTokohDuniaBinding): RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var name = binding.txtname

    }
    interface OnClickListener {
        fun detailData(item : Tokoh?)
    }


}