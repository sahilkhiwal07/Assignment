package com.example.assignment.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignment.ui.viewmodel.RosterViewModel
import com.example.assignment.MainActivity
import com.example.assignment.R
import com.example.assignment.data.Roster
import com.example.assignment.ui.adapter.RosterAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home),RosterAdapter.MyCLick {

    private lateinit var viewModel: RosterViewModel
    private lateinit var roasterAdapter: RosterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        setRecyclerView()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getAllData().observe(viewLifecycleOwner, {
            roasterAdapter.submitList(it)
        })

        viewModel.makeApiCall()
    }

    private fun setRecyclerView() {
        roasterAdapter = RosterAdapter(requireContext(), this)
        roster_recyclerView.apply {
            adapter = roasterAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onRowClick(roster: Roster) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailed(roster)
        findNavController().navigate(action)
    }

}