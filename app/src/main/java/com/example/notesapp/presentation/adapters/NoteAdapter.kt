package com.example.notesapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.data.local.dto.Note
import com.example.notesapp.databinding.ItemNoteBinding

class NoteAdapter: ListAdapter<Note, NoteAdapter.NoteViewHolder>(NoteItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        ItemNoteBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind()
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val note = getItem(adapterPosition)
            binding.apply {
                tvTitle.text = note.title
                tvBody.text = note.body
            }
        }
    }

    private object NoteItemCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

}