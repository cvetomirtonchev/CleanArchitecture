package com.tsvetomir.tonchev.breakingbad.ui.characters.characterdetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tsvetomir.tonchev.breakingbad.R
import kotlinx.android.synthetic.main.fragment_character_details.*

class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {
    private lateinit var mAdapter: CharacterDetailsAdapter
    private val args: CharacterDetailsFragmentArgs by navArgs()

    private val mViewModel: CharacterDetailsViewModel by lazy {
        ViewModelProvider(this).get(CharacterDetailsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.observeCharacterDetailsListLiveData().observe(this, {
            mAdapter.loadData(it, args.characterView.img)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initRecyclerView()
        mViewModel.mapCharacterDetails(args.characterView)
    }

    private fun initAdapter() {
        mAdapter = CharacterDetailsAdapter()
    }

    private fun initRecyclerView() {
        with(char_details_rv) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }
    }
}