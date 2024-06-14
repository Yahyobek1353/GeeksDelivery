package com.saliev.geeksdelivery.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding>(
    @LayoutRes layoutId : Int
) : Fragment(layoutId) {

    protected abstract val binding : Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        launchObserver()
        constructorListeners()
    }

    protected open fun initialize(){}
    protected open fun launchObserver(){}
    protected open fun constructorListeners(){}
}