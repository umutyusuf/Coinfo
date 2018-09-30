package com.malik.coinfo.ui.home

import android.os.Bundle
import com.malik.coinfo.R
import com.malik.coinfo.ui.BaseActivity

class HomeActivity : BaseActivity(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
                .replace(R.id.homeViewContainer, HomeFragment())
                .commit()
    }

}