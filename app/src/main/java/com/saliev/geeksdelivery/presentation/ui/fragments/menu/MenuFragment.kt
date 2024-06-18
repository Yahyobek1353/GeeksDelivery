package com.saliev.geeksdelivery.presentation.ui.fragments.menu


import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saliev.geeksdelivery.R
import com.saliev.geeksdelivery.core.base.BaseFragment
import com.saliev.geeksdelivery.databinding.FragmentMenuBinding
import com.saliev.geeksdelivery.presentation.adapters.menu_adapters.CategoryAdapter
import com.saliev.geeksdelivery.presentation.adapters.menu_adapters.CategoryItemAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment: BaseFragment<FragmentMenuBinding , MenuFragmentViewModel>(R.layout.fragment_menu) {

    private val adapterCategoryItem: CategoryItemAdapter by lazy { CategoryItemAdapter() }
    private val adapterCategory: CategoryAdapter by lazy { CategoryAdapter() }
    override val binding: FragmentMenuBinding by viewBinding(FragmentMenuBinding::bind)
    override val viewModel: MenuFragmentViewModel by viewModel()

    override fun initialize() {
        binding.rvCategory.adapter = adapterCategory
        binding.rvCategoryItem.adapter = adapterCategoryItem
    }

    override fun launchObserver() {


        viewModel.categoryItemState.spectageUIState (success = { categoryItem ->
            adapterCategoryItem.submitList(categoryItem)
        }, error = {ex ->
            Toast.makeText(requireContext(), ex, Toast.LENGTH_SHORT).show()
        })

        viewModel.categoryState.spectageUIState (success = {category ->
            adapterCategory.submitList(category)
        }, error = {ex->
            Toast.makeText(requireContext(), ex, Toast.LENGTH_SHORT).show()
        })
    }


}