package com.example.admincarpertstoremmec

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val userList: ArrayList<user>): RecyclerView.Adapter<OrderAdapter.OrderViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderAdapter.OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
           R.layout.list_item,
            parent,
            false)

        return OrderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrderAdapter.OrderViewHolder, position: Int) {
        val user: user = userList[position]
        holder.addressTitle.text = user.addressTitle
        holder.district.text = user.district
        holder.fullName.text = user.district
        holder.phone.text = user.district
        holder.street.text = user.district
    }

    override fun getItemCount(): Int {
        return userList.size

    }

    public class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val addressTitle: TextView = itemView.findViewById(R.id.tvAddTitle)
        val district: TextView = itemView.findViewById(R.id.tvAddDistrict)
        val fullName: TextView = itemView.findViewById(R.id.tvAddFullname)
        val phone: TextView = itemView.findViewById(R.id.tvAddPhone)
        val street: TextView = itemView.findViewById(R.id.tvAddStreet)
    }

}