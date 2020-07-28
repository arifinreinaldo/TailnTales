package com.tailntales.customer.base

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

abstract class BaseFragment : Fragment() {
    protected lateinit var ctx: Context
    protected lateinit var act: Activity
    protected lateinit var manager: FragmentManager
    protected var saveView: View? = null
    protected lateinit var tagNetworking: String
    abstract fun setLayoutId(): Int
    abstract fun setInitialAsset()
    abstract fun setListener()
    abstract fun removeListener()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (saveView == null) {
            saveView = inflater.inflate(setLayoutId(), container, false)
        }
        return saveView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInitialAsset()
    }


    private fun setAsset() {
        context?.let {
            ctx = it
        }
        activity?.let {
            act = it
        }
        fragmentManager?.let {
            manager = it
        }
    }

    fun showMessage(message: String) {
        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
    }

    fun showMessage(@StringRes message: Int) {
        Toast.makeText(ctx, getString(message), Toast.LENGTH_SHORT).show()
    }

    fun startFragment(dest: Uri) {
        findNavController().navigate(dest)
    }

    fun startFragment(dest: NavDirections) {
        findNavController().navigate(dest)
    }

    fun startFragment(dest: Int) {
        findNavController().navigate(dest)
    }

    fun previousFragment() {
        findNavController().navigateUp()
    }
}