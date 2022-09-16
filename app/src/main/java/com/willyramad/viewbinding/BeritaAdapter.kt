package com.willyramad.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.willyramad.viewbinding.databinding.ItemBeritaBinding

class BeritaAdapter(var listBerita : ArrayList<Berita>) : RecyclerView.Adapter<BeritaAdapter.Viewholder>() {
    var onClick : ((Berita) -> Unit)? = null
    class Viewholder(val binding : ItemBeritaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun databind(itemData : Berita) {
            binding.berita = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaAdapter.Viewholder {
        val view = ItemBeritaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: BeritaAdapter.Viewholder, position: Int) {
        holder.binding.berita = listBerita[position]
        holder.itemView.setOnClickListener {
            onClick?.invoke(listBerita[position])
        }
    }

    override fun getItemCount(): Int = listBerita.size

        fun datBerita(beritaList : ArrayList<Berita>){
            this.listBerita = beritaList
    }
}