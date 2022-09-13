package com.example.notesapp.presentation.fragments

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.databinding.FragmentNotesListBinding
import com.example.notesapp.presentation.adapters.NoteAdapter
import com.example.notesapp.presentation.base.BaseFragment
import com.example.notesapp.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesListFragment : BaseFragment<FragmentNotesListBinding>(FragmentNotesListBinding::inflate) {

    private val viewModel by activityViewModels<MainViewModel>()

    private val noteAdapter = NoteAdapter()

    override fun viewCreated() {

        init()

        onClickListeners()

        observers()

    }

    private fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.notesFlow.collect {
                noteAdapter.submitList(it)
            }
        }
    }

    private fun onClickListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(NotesListFragmentDirections.toAddNoteFragment())
        }
    }

    private fun init() {
        binding.rvNotes.apply {
            adapter = noteAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllNotes()
        }
    }

}