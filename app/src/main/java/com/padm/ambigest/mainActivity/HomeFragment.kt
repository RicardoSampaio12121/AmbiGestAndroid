package com.padm.ambigest.mainActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padm.ambigest.R
import com.padm.ambigest.mainActivity.mainModels.MyRequestModel
import java.time.LocalDate

class HomeFragment : Fragment() {
    private lateinit var adapter: RVPickupItemsAdapter

    private var requests: MutableList<MyRequestModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        for (n in 1..10){
            requests.add(MyRequestModel("none", "item $n", LocalDate.now()))
        }

        //------------------------------


        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startRecyclerView()
    }

    private fun startRecyclerView(){
        val recyclerViewItems = requireActivity().findViewById<RecyclerView>(R.id.main_rv_rv)

        recyclerViewItems.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewItems.adapter = RVPickupItemsAdapter(requests)
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