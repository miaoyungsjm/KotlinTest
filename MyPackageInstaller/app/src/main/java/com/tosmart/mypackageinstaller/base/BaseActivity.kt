package com.tosmart.packageinstaller.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kunminx.architecture.ui.page.DataBindingActivity

/**
 * @author      lbc94
 * @date        2020/8/10
 * @time        12:24
 */
 abstract class BaseActivity : DataBindingActivity() {

    override fun <T : ViewModel?> getActivityViewModel(modelClass: Class<T>): T {
        return super.getActivityViewModel(modelClass)
    }

    override fun getAppViewModelProvider(): ViewModelProvider? {
        return super.getAppViewModelProvider()
    }
}
