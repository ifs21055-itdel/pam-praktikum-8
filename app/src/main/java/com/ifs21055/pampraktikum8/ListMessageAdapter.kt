package com.ifs21055.pampraktikum8

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21055.pampraktikum8.databinding.ItemRowMessageBinding
class ListMessageAdapter(private val listMessage: ArrayList<Message>) :
    RecyclerView.Adapter<ListMessageAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback:
                               OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    fun setListMessage(newListMessage: ArrayList<Message>) {
        listMessage.clear()
        listMessage.addAll(newListMessage)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType:
    Int): ListViewHolder {
        val binding =
            ItemRowMessageBinding.inflate(LayoutInflater.from(viewGroup.context),
                viewGroup, false)
        return ListViewHolder(binding)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position:
    Int) {
        val message = listMessage[position]
        holder.binding.ivPersonPicture.setImageResource(message.icon)
        holder.binding.tvPersonName.text = message.name
        holder.binding.tvIsiPesan.text = message.pesan
    }
    override fun getItemCount(): Int = listMessage.size
    class ListViewHolder(var binding: ItemRowMessageBinding) :
        RecyclerView.ViewHolder(binding.root)
    interface OnItemClickCallback {
        fun onItemClicked(data: Message)
    }
}