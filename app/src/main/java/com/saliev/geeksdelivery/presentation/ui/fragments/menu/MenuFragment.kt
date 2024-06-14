package com.saliev.geeksdelivery.presentation.ui.fragments.menu


import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saliev.geeksdelivery.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.saliev.geeksdelivery.databinding.FragmentMenuBinding
import com.saliev.geeksdelivery.core.base.BaseFragment
import com.saliev.geeksdelivery.presentation.model.Resourse
import com.saliev.geeksdelivery.presentation.adapters.menu_adapters.CategoryAdapter
import kotlinx.coroutines.launch

class MenuFragment: BaseFragment<FragmentMenuBinding>(R.layout.fragment_menu) {
    private val viewModel:MenuFragmentViewModel by viewModel()
    private val adapter: CategoryAdapter by lazy { CategoryAdapter() }
    override val binding: FragmentMenuBinding by viewBinding(FragmentMenuBinding::bind)


    override fun initialize() {

        binding.rvCategory.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllCategory()
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.categoryState.collect {
                when(it) {
                    is Resourse.Loading -> Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    is Resourse.Success -> adapter.submitList(it.data?.categories)
                    is Resourse.Error -> it.message.let { it1->
                        if (it1 != null) {
                            Log.e("category" , it1)
                        }
                    }
                }
            }
        }
    }


}