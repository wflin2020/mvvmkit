package com.wflin.mvvmkit.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * @author: wflin
 * @data: 2022/1/10
 * @desc:
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setupViewBinding()
        setContentView(binding.root)
        observeViewModel()
        init()
    }

    protected abstract fun setupViewBinding(): VB
    protected abstract fun init()
    protected abstract fun observeViewModel()

}