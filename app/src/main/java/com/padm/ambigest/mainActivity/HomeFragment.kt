package com.padm.ambigest.mainActivity

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.padm.ambigest.R
import com.padm.ambigest.databinding.FragmentHomeBinding
import com.padm.ambigest.databinding.FragmentLoginBinding
import com.padm.ambigest.mainActivity.mainModels.MyRequestModel
import com.padm.ambigest.services.firebase.httpClient.Endpoints
import com.padm.ambigest.services.firebase.httpClient.HttpClientService
import com.padm.ambigest.services.firebase.httpClient.Models.PickupModel
import com.padm.ambigest.services.firebase.httpClient.Models.WaterReadingModel
import kotlinx.coroutines.*
import java.time.LocalDate

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var pickupsAdapter: RVPickupItemsAdapter
    private lateinit var readingsAdapter: RVWaterReadingsAdapter

    private val httpClientService = HttpClientService()

    private var pickups: MutableList<PickupModel> = ArrayList()
    private var waterReadings: MutableList<WaterReadingModel> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewItems = requireActivity().findViewById<RecyclerView>(R.id.main_rv_rv)

        readingsAdapter = RVWaterReadingsAdapter(waterReadings)

        startRecyclerView()

        lifecycleScope.launch{
            //val pickupsAsJson = getPickupOrders()
            val readingsAsJson = getWaterReadings()

            //val data = Gson().fromJson<MutableList<PickupModel>>(dataAsJson, object : TypeToken<MutableList<PickupModel>>() {}.type)
            val readingsData = Gson().fromJson<MutableList<WaterReadingModel>>(readingsAsJson, object : TypeToken<MutableList<WaterReadingModel>>() {}.type)
            readingsAdapter.updateData(readingsData)
            //pickupsAdapter.updateData(data)
        }

        val readingsButton = requireActivity().findViewById<TextView>(R.id.main_tv_readings)
        val pickupsButton = requireActivity().findViewById<TextView>(R.id.main_tv_pickups)

        readingsButton.setOnClickListener{
            ChangeButtonsAppearance(readingsButton, pickupsButton)
            recyclerViewItems.adapter = readingsAdapter
        }

        pickupsButton.setOnClickListener{
            ChangeButtonsAppearance(pickupsButton, readingsButton)
            recyclerViewItems.adapter = pickupsAdapter
        }

    }

    private fun ChangeButtonsAppearance(toSelect: TextView, toUnselect: TextView){
        toSelect.setBackgroundResource(R.drawable.main_button_selected)
        toSelect.setTextColor(ContextCompat.getColor(requireContext(), R.color.home_selected_button))

        toUnselect.background = null
        toUnselect.setTextColor(ContextCompat.getColor(requireContext(), R.color.home_unselected_button))
    }

    private suspend fun getPickupOrders(){
        val a: String

        withContext(Dispatchers.Default){
            a = httpClientService.Get(Endpoints.GET_PICKUP_ORDERS.label)
        }
    }

    private suspend fun getWaterReadings(): String{
        val a: String
        withContext(Dispatchers.Default){
            a = httpClientService.Get(Endpoints.GET_WATER_READINGS.label)
        }
        return a
    }

    private fun startRecyclerView(){
        val recyclerViewItems = requireActivity().findViewById<RecyclerView>(R.id.main_rv_rv)
        pickupsAdapter = RVPickupItemsAdapter(pickups)

        recyclerViewItems.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewItems.adapter = pickupsAdapter
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}