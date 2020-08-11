package com.tosmart.packageinstaller.base

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kunminx.architecture.ui.page.DataBindingFragment

/**
 * @author      lbc94
 * @date        2020/8/10
 * @time        12:30
 */
abstract class BaseFragment : DataBindingFragment() {

    protected override fun <T : ViewModel?> getFragmentViewModel(modelClass: Class<T>): T {
        return super.getFragmentViewModel(modelClass)
    }

    protected override fun <T : ViewModel?> getActivityViewModel(modelClass: Class<T>): T {
        return super.getActivityViewModel(modelClass)
    }

    protected override fun getAppViewModelProvider(): ViewModelProvider? {
        return super.getAppViewModelProvider()
    }
}