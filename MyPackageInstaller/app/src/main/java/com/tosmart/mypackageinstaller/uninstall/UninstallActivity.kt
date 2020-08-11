package com.tosmart.mypackageinstaller.uninstall

import android.os.Bundle
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.tosmart.mypackageinstaller.BR
import com.tosmart.mypackageinstaller.R
import com.tosmart.mypackageinstaller.UninstallModel
import com.tosmart.packageinstaller.base.BaseActivity

class UninstallActivity : BaseActivity() {

    var mViewModel = UninstallModel()

    override fun getDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(
            R.layout.activity_uninstall,
            BR.model,
            mViewModel
        ).addBindingParam()

    override fun initViewModel() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uninstall)


    }
}