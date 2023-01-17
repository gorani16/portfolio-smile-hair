package com.gorani.smilehair.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gorani.smilehair.common.URL_MY_GITHUB
import com.gorani.smilehair.databinding.FragmentContactBinding

class ContactFragment: Fragment() {

    private lateinit var binding: FragmentContactBinding

    private val webView by lazy {
        binding.webView
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWebView()

    }

    private fun initWebView() {
        webView.apply {
            settings.javaScriptEnabled = true
            loadUrl(URL_MY_GITHUB)
        }
    }
}