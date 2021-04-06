/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mvvm.base

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.drake.statusbar.immersive
import com.example.mvvm.R
import com.example.mvvm.component.databinding.bind

abstract class EngineToolbarActivity<B : ViewDataBinding>(@LayoutRes contentLayoutId: Int = 0) :
    EngineActivity<B>(contentLayoutId) {

    override fun setTitle(title: CharSequence?) {
        findViewById<TextView>(R.id.tv_title).text = title ?: return
    }

    @SuppressLint("InflateParams")
    override fun setContentView(layoutResId: Int) {
        val root = layoutInflater.inflate(R.layout.engine_toolbar, null) as ViewGroup
        setContentView(root)
        rootView = layoutInflater.inflate(layoutResId, null)
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        findViewById<ViewGroup>(R.id.ll_root).addView(rootView, layoutParams)
        binding = rootView.bind()
        immersive(findViewById(R.id.toolbar))
        findViewById<View>(R.id.iv_action_back).setOnClickListener { onBack() }
        init()
    }

    open fun onBack() {
        finishTransition()
    }
}
