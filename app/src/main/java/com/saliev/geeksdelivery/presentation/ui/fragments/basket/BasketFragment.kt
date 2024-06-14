package com.saliev.geeksdelivery.presentation.ui.fragments.basket

import by.kirich1409.viewbindingdelegate.viewBinding
import com.saliev.geeksdelivery.R
import com.saliev.geeksdelivery.databinding.FragmentBasketBinding
import com.saliev.geeksdelivery.core.base.BaseFragment

class BasketFragment : BaseFragment<FragmentBasketBinding>(R.layout.fragment_basket) {
    override val binding: FragmentBasketBinding by viewBinding(FragmentBasketBinding::bind)


}