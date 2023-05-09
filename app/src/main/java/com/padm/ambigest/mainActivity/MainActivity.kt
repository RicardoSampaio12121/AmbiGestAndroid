package com.padm.ambigest.mainActivity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padm.ambigest.R
import com.padm.ambigest.mainActivity.mainModels.MyRequestModel
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RVPickupItemsAdapter

    private var requests: MutableList<MyRequestModel> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO FOR MAIN ACTIVITY
        //1- make stars bigger
        //2- have to get an image with half a star filled and a full star filled
        //3- make the circle to always be completely round
        //4- Add that square thing between the circle and the congratulations box
        //5- Make those 3 buttons look good
        //6- Implement the recyclerView items with mocked data to see how it looks like | DONE
        //7- Change the color of the circle border
        //8- Probably have to make the whole thing scrollable instead of just the recyclerView

        //Mocked data

        for (n in 1..10){
            requests.add(MyRequestModel("none", "item $n", LocalDate.now()))
        }

        //------------------------------

        startRecyclerView()

    }

    private fun startRecyclerView(){
        val recyclerViewItems = findViewById<RecyclerView>(R.id.main_rv_rv)

        recyclerViewItems.layoutManager = LinearLayoutManager(this)
        recyclerViewItems.adapter = RVPickupItemsAdapter(requests)
    }
}