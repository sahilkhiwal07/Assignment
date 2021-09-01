package com.example.assignment.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.assignment.R
import kotlinx.android.synthetic.main.fragment_detailed.*

class Detailed: Fragment(R.layout.fragment_detailed) {

    private val args: DetailedArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val roster = args.roster

        tv_names.text = roster.name
        tv_positions.text = roster.position

        Glide.with(requireActivity())
            .load(roster.image_url)
            .into(images)

    }

}