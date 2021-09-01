package com.example.assignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment.R
import com.example.assignment.data.Roster

class RosterAdapter(
    private val context: Context,
    private val myCLick: MyCLick
) : ListAdapter<Roster, RosterAdapter.RosterHolder>(DIFF_ITEM_CALLBACK) {

    companion object {

        val DIFF_ITEM_CALLBACK = object : DiffUtil.ItemCallback<Roster>() {
            override fun areItemsTheSame(oldItem: Roster, newItem: Roster): Boolean {
                return oldItem.image_url == newItem.image_url
            }

            override fun areContentsTheSame(oldItem: Roster, newItem: Roster): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RosterHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.items, parent, false)
        return RosterHolder(view)
    }

    override fun onBindViewHolder(holder: RosterHolder, position: Int) {

        getItem(position)?.let { roster ->
            holder.bind(roster)
            holder.singleItem.setOnClickListener {
                myCLick.onRowClick(roster)
            }
        }
    }

    class RosterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: AppCompatTextView = itemView.findViewById(R.id.tv_name)
        private val position: AppCompatTextView = itemView.findViewById(R.id.tv_position)
        private val image: AppCompatImageView = itemView.findViewById(R.id.image)
        val singleItem: CardView = itemView.findViewById(R.id.singleItem)

        fun bind(roster: Roster) {
            name.text = roster.name
            position.text = roster.position
            Glide.with(itemView.context)
                .load(roster.image_url)
                .into(image)

        }
    }

    interface MyCLick {
        fun onRowClick(roster: Roster)
    }

}