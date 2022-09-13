package com.example.notesapp.presentation.fragments

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.notesapp.data.local.dto.Note
import com.example.notesapp.databinding.FragmentAddNoteBinding
import com.example.notesapp.presentation.base.BaseFragment
import com.example.notesapp.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun viewCreated() {

        onClickListeners()

    }

    private fun onClickListeners() {
        binding.btnSave.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.addNote(
                    Note(
                        0,
                        binding.etTitle.text.toString(),
                        binding.etBody.text.toString()
                    )
                )
            }.invokeOnCompletion {
                findNavController().popBackStack()
            }
        }
    }

}