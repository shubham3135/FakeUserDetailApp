package com.shubhamkumarwinner.retrofitmvvm

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shubhamkumarwinner.retrofitmvvm.information.InformationAdapter
import com.shubhamkumarwinner.retrofitmvvm.network.User

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<User>?) {
    val adapter = recyclerView.adapter as InformationAdapter
    adapter.submitList(data)
}

@BindingAdapter("name")
fun bindName(textView:TextView, user: User){
    textView.text = user.name
}

@BindingAdapter("phone")
fun bindPhone(textView:TextView, user: User){
    textView.text = user.phone
}

@BindingAdapter("email")
fun bindEmail(textView:TextView, user: User){
    textView.text = user.email
}