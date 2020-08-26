package com.tsvetomir.tonchev.breakingbad.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tsvetomir.tonchev.breakingbad.R
import com.tsvetomir.tonchev.breakingbad.ui.util.addItemDivider
import kotlinx.android.synthetic.main.fragment_characters.*

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private lateinit var mAdapter: CharactersAdapter

    private val mViewModel: CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.observeCharacterListLiveData().observe(this, {
            mAdapter.loadData(it)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initRecyclerView()
        mViewModel.getAllCharacters("")
    }


    private fun initAdapter() {
        mAdapter = CharactersAdapter {
            findNavController().navigate(
                CharactersFragmentDirections.actionCharactersToCharacterDetails(
                    it
                )
            )
        }
    }

    private fun initRecyclerView() {
        with(characters_rv) {
            addItemDivider(requireContext(), R.drawable.charecter_divider)
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }
    }
}