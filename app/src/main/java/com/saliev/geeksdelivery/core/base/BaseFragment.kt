package com.saliev.geeksdelivery.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.saliev.geeksdelivery.core.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<Binding : ViewBinding , ViewModel : BaseViewModel> (
    @LayoutRes layoutId : Int
) : Fragment(layoutId) {

    protected abstract val binding : Binding
    protected abstract val viewModel : ViewModel


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

    protected fun <T> StateFlow<UIState<T>>.spectageUIState(
        livecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        success: ((data: T) -> Unit)? = null,
        error: ((error: String) -> Unit)? = null,
        loading: ((data: UIState.Loading<T>) -> Unit)? = null,
        idle: ((idle : UIState.Idle<T>) -> Unit )? = null,
        gatherIfSucceed : ((state : UIState<T>) -> Unit)? = null
    ){
        saveFlowGather ( livecycleState){
            collect{
                gatherIfSucceed?.invoke(it)
                when (it){
                    is UIState.Idle -> idle?.invoke(it)
                    is UIState.Loading -> loading?.invoke(it)
                    is UIState.Success -> success?.invoke(it.data)
                    is UIState.Error ->  error?.invoke(it.toString())
                }
            }
        }
    }

    fun saveFlowGather(
        livecycleState : Lifecycle.State = Lifecycle.State.STARTED,
        gather : suspend () -> Unit,
    ){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(livecycleState){
                gather()
            }
        }
    }


}