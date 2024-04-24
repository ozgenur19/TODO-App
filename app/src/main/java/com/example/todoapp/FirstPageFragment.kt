package com.example.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.databinding.FragmentFirstPageBinding
import com.example.todoapp.databinding.FragmentFirstPageBinding.*
import com.example.todoapp.databinding.ItemListBinding
import com.google.android.material.snackbar.Snackbar


class FirstPageFragment : Fragment() {
    private lateinit var binding: FragmentFirstPageBinding
    private  lateinit var  myAdapter: ToDoAdapter
    private val myList = ArrayList<ItemDataModel>()

    private fun addList(item:ItemDataModel){
        myList.add(item)
        myAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
    binding = inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            val title = binding.editTextText.text.toString()
            val description = binding.editTextText2.text.toString()
            if (title.isEmpty() || description.isEmpty()) {
                Snackbar.make(it,"Fill all the blanks",Snackbar.LENGTH_SHORT).show()
            }
            else {
                val newItem = ItemDataModel(title,description)
                addList(newItem)

                binding.editTextText.text.clear()
                binding.editTextText2.text.clear()

                binding.editTextText.requestFocus()
            }

        }
        myAdapter= ToDoAdapter(myList)
        binding.recycleview.adapter = myAdapter
    }

}