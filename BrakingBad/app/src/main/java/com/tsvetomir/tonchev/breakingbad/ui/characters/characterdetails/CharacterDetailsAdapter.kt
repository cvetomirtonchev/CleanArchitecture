package com.tsvetomir.tonchev.breakingbad.ui.characters.characterdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.tsvetomir.tonchev.breakingbad.R
import com.tsvetomir.tonchev.breakingbad.data.models.local.CharDetailsView
import com.tsvetomir.tonchev.breakingbad.ui.util.ImageHelper

class CharacterDetailsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

    private val mCharDetailsViewList = mutableListOf<CharDetailsView>()
    private var mCount = 0
    private var mImage = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_HEADER -> {
                val view =
                    inflater.inflate(R.layout.item_char_details_header, parent, false)
                HeaderCharViewHolder(view)
            }
            else -> {
                val view = inflater.inflate(R.layout.item_char_details_info, parent, false)
                ItemCharViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderCharViewHolder -> {
                handleHeaderView(holder)
            }
            is ItemCharViewHolder -> {
                handleItemView(holder, position - 1)
            }
        }
    }

    private fun handleHeaderView(holder: HeaderCharViewHolder) {
        ImageHelper.loadImage(holder.mCharacterImage, mImage.toUri())

    }

    private fun handleItemView(holder: ItemCharViewHolder, position: Int) {
        val item = mCharDetailsViewList[position]
        holder.mTitle.text = item.title
        holder.mData.text = item.info
    }

    override fun getItemCount(): Int {
        return mCount
    }

    fun loadData(data: List<CharDetailsView>, image: String) {
        mCharDetailsViewList.addAll(data)
        mImage = image
        mCount = mCharDetailsViewList.size + 1
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                TYPE_HEADER
            }
            else -> {
                TYPE_ITEM
            }
        }
    }

    class HeaderCharViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mCharacterImage: ImageView = itemView.findViewById(R.id.char_details_iv)
    }

    class ItemCharViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTitle: TextView = itemView.findViewById(R.id.char_details_title_tv)
        val mData: TextView = itemView.findViewById(R.id.char_details_value_tv)
    }
}