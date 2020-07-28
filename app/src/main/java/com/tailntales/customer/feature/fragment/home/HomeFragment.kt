package com.tailntales.customer.feature.fragment.home

import android.os.Bundle
import com.tailntales.customer.R
import com.tailntales.customer.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun setInitialAsset() {
        val c = Calendar.getInstance()
        val timeOfDay = c[Calendar.HOUR_OF_DAY]
        tvGreetings.text = when (timeOfDay) {
            in 1..11 -> getString(R.string.msg_morning)
            in 12..15 -> getString(R.string.msg_afternoon)
            in 16..20 -> getString(R.string.msg_evening)
            in 21..23 -> getString(R.string.msg_evening)
            else -> getString(R.string.msg_hello)
        }
    }

    override fun setListener() {
    }

    override fun removeListener() {

    }
}