package com.padm.ambigest.mainActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padm.ambigest.databinding.ActivityMainWaterReadingsRvItemBinding
import com.padm.ambigest.services.firebase.httpClient.Models.WaterReadingModel
import java.text.SimpleDateFormat
import java.util.*

class RVWaterReadingsAdapter(var items: MutableList<WaterReadingModel>): RecyclerView.Adapter<RVWaterReadingsAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: ActivityMainWaterReadingsRvItemBinding): RecyclerView.ViewHolder(binding.root){
        init {
            //Not sure if we need some onClick behaviour
        }
    }

    fun updateData(newData: MutableList<WaterReadingModel>) {
        items = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityMainWaterReadingsRvItemBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int){
        holder.binding.apply {
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)

            mainRvItemTvPrice.text = "${items[position].amount.toString()} l/m3"
            mainRvItemTvDate.text = dateFormat.format(items[position].updatedAt).toString()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}