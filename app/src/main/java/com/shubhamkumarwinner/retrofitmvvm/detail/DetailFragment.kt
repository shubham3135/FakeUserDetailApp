package com.shubhamkumarwinner.retrofitmvvm.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.shubhamkumarwinner.retrofitmvvm.R
import com.shubhamkumarwinner.retrofitmvvm.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailFragmentBinding.inflate(inflater)
        val user = DetailFragmentArgs.fromBundle(arguments!!).selectedUser
        val application = requireNotNull(activity).application
        val factory = DetailViewModelFactory(user, application)
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
//        Toast.makeText(context, user.address.geo.lat, Toast.LENGTH_LONG).show()
        return binding.root
    }

}