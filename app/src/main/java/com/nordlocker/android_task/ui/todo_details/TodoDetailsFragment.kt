package com.nordlocker.android_task.ui.todo_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.nordlocker.android_task.databinding.TodoDetailsFragmentBinding
import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.text.SimpleDateFormat
import java.util.*

class TodoDetailsFragment : Fragment() {

	private val args: TodoDetailsFragmentArgs by navArgs()
	private val viewModel: TodoDetailsViewModel by viewModel {
		parametersOf(args.todoId)
	}

	private var _binding: TodoDetailsFragmentBinding? = null
	private val binding: TodoDetailsFragmentBinding
		get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View = TodoDetailsFragmentBinding.inflate(
		LayoutInflater.from(requireContext()),
		container,
		false
	).apply { _binding = this }.root

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		observe()
	}

	private fun observe() {
		viewLifecycleOwner.lifecycleScope.launch {
			viewModel.todoDetailsFlow.collect {
				when (it) {
					TodoDetailsState.Loading -> Log.d("TodoDetailsFragment", "Loading todo $id")
					is TodoDetailsState.Success -> bindTodo(it.todo)
					is TodoDetailsState.Error -> Log.w("TodoDetailsFragment", it.throwable)
				}
			}
		}
	}

	private fun bindTodo(todo: Todo) {
		binding.idText.text = todo.id.toString()
		binding.completedCheckbox.isChecked = todo.completed
		binding.titleEditText.setText(todo.title, TextView.BufferType.EDITABLE)
		binding.dueDateText.text =
			SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(todo.dueDate)
	}
}