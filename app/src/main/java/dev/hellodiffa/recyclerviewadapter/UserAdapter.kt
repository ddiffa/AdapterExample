package dev.hellodiffa.recyclerviewadapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter( private val onItemClick: OnItemClick) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    var dataSource = mutableListOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.item_user, parent, false))

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataSource[position])
    }

    inner class ViewHolder(private val view : View) : RecyclerView.ViewHolder(view){

        fun onBind(user : User) = view.apply{
            tvUsername.text = user.username
            tvAddressUser.text = user.address
            setOnClickListener {
                onItemClick(user)
            }
        }
    }


}

typealias OnItemClick = (User)->Unit