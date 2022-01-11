package com.wflin.mvvmkit.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * @author: wflin
 * @data: 2022/1/11
 * @desc:
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = createViewBinding()
        return binding.root
    }

    protected abstract fun createViewBinding(): VB
}