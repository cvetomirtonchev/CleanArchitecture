package com.tsvetomir.tonchev.breakingbad.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.tsvetomir.tonchev.breakingbad.R
import com.tsvetomir.tonchev.breakingbad.data.models.local.CharacterView
import com.tsvetomir.tonchev.breakingbad.ui.util.ImageHelper

class CharactersAdapter(private val onCharacterSelected: (item: CharacterView) -> Unit) :
    RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private val characterList = mutableListOf<CharacterView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = characterList[position]
        handleAvatarImage(holder.mImage, item.img)
        holder.mTitle.text = item.name
        holder.itemView.setOnClickListener {
            onCharacterSelected.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun loadData(dataList: List<CharacterView>) {
        characterList.addAll(dataList)
        notifyDataSetChanged()
    }

    private fun handleAvatarImage(imageView: ImageView, avatarUrl: String) {
        ImageHelper.loadCircleImage(
            imageView,
            avatarUrl.toUri()
        )
    }

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mImage: ImageView = view.findViewById(R.id.character_iv)
        val mTitle: TextView = view.findViewById(R.id.character_tv)
    }
}