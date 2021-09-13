package com.lush.practicaltest.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lush.practicaltest.api.response.RocketDataResponse
import com.lush.practicaltest.databinding.ItemRocketListBinding

class RocketListAdapter(
    private var listAvailableRoute: List<RocketDataResponse.RocketDataResponseItem>,
    private var context: Context,
    private val onClickListener: OnItemClickListener
) : RecyclerView.Adapter<RocketListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemCLick(
            item: RocketDataResponse.RocketDataResponseItem
        )
    }

    fun setData(list: ArrayList<RocketDataResponse.RocketDataResponseItem>?) {
        if (list != null) {
            listAvailableRoute = list
        }
        notifyDataSetChanged()
    }

    class ViewHolder(var itemBinding: ItemRocketListBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemRocketListBinding =
            ItemRocketListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {

        holder.itemBinding.data = listAvailableRoute[listPosition]
        holder.itemBinding.itemClickListener = onClickListener

        Glide.with(context).load(listAvailableRoute[listPosition].flickrImages[0])
            .into(holder.itemBinding.ivRocketImage)

        if (listAvailableRoute[listPosition].successRatePct == 100) {
            holder.itemBinding.tvStatus.text = "SUCCESS"
            holder.itemBinding.tvStatus.setTextColor(Color.GREEN)
        } else {
            holder.itemBinding.tvStatus.text = "FAIL"
            holder.itemBinding.tvStatus.setTextColor(Color.RED)
        }

    }

    override fun getItemCount(): Int {
        return listAvailableRoute.size
    }

}
