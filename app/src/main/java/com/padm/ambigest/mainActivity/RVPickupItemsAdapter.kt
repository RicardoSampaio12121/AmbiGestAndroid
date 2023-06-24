package com.padm.ambigest.mainActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.type.DateTime
import com.padm.ambigest.databinding.ActivityMainPickupRvItemBinding
import com.padm.ambigest.mainActivity.mainModels.MyRequestModel
import com.padm.ambigest.services.firebase.httpClient.Models.PickupModel
import com.padm.ambigest.services.firebase.httpClient.Models.WaterReadingModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class RVPickupItemsAdapter(var items: MutableList<PickupModel>): RecyclerView.Adapter<RVPickupItemsAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: ActivityMainPickupRvItemBinding): RecyclerView.ViewHolder(binding.root){
            init {
                //Not sure if we need some onClick behaviour
            }
        }

    fun updateData(newData: MutableList<PickupModel>) {
        items = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityMainPickupRvItemBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int){
        holder.binding.apply {
            val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH)

            mainRvItemTvName.text = "${items[position].type}"
            mainRvItemTvDate.text = dateFormat.format(items[position].pickupAt).toString()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}