package com.nordlocker.android_task.ui.todo_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nordlocker.android_task.R
import com.nordlocker.android_task.databinding.TodoDetailsFragmentBinding
import com.nordlocker.android_task.databinding.TodoListFragmentBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodoListFragment : Fragment() {

	private val viewModel: TodoListViewModel by viewModel()
	private var _binding: TodoListFragmentBinding? = null
	private val binding: TodoListFragmentBinding
		get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View = TodoListFragmentBinding.inflate(
		LayoutInflater.from(requireContext()),
		container,
		false
	).apply { _binding = this }.root

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.todosRecyclerView.apply {
			layoutManager =  LinearLayoutManager(activity).apply {
				orientation = LinearLayoutManager.VERTICAL
			}
			adapter = TodoListAdapter {
				it.id?.let { todoId ->
					findNavController().navigate(TodoListFragmentDirections.openDetails(todoId))
				}
			}
		}

		observeViewState()
	}

	private fun observeViewState() {
		viewLifecycleOwner.lifecycleScope.launch {
			viewModel.todoListStateFlow.collect {
				(binding.todosRecyclerView.adapter as TodoListAdapter).submitList(it)
			}
		}
	}
}