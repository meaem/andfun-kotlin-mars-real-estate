/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

// TODOo (06) Create the Binding Adapter, converting the imgUrl to a URI with the https scheme
@BindingAdapter("imagUrl")
fun bindImge(imageView: ImageView, imgUrl: String?) {
    val options = RequestOptions()
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_broken_image)
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        // TODOo (07) Use Glide to load the imgUri into the imgView

        Glide.with(imageView.context)
            .load(imgUri)
            .apply(options)
            .into(imageView)
    }
}
// TODO (11) Add the requestOptions for the placeholder and error into the Glide call
