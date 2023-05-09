package com.padm.ambigest.mainActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.type.DateTime
import com.padm.ambigest.databinding.ActivityMainPickupRvItemBinding
import com.padm.ambigest.mainActivity.mainModels.MyRequestModel
import java.time.LocalDate

class RVPickupItemsAdapter(var items: MutableList<MyRequestModel>): RecyclerView.Adapter<RVPickupItemsAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: ActivityMainPickupRvItemBinding): RecyclerView.ViewHolder(binding.root){
            init {
                //Not sure if we need some onClick behaviour
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityMainPickupRvItemBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int){
        holder.binding.apply {
            //Mock data



            //---------

            mainRvItemTvName.text = items[position].name
            mainRvItemTvDate.text = items[position].date.toString()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}