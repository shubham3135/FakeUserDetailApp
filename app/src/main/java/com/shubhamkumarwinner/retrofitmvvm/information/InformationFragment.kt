package com.shubhamkumarwinner.retrofitmvvm.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shubhamkumarwinner.retrofitmvvm.databinding.InformationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationFragment : Fragment() {
    private val viewModel: InformationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = InformationFragmentBinding.inflate(inflater)
//        viewModel = ViewModelProvider(this).get(InformationViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.infoItem.adapter = InformationAdapter(InformationAdapter.OnClickListener{
            viewModel.displayUserDetails(it)
        })

        viewModel.navigateToSelectedUser.observe(viewLifecycleOwner, {
            if ( it!=null ) {
                this.findNavController()
                    .navigate(InformationFragmentDirections
                        .actionInformationFragmentToDetailFragment(it))
                viewModel.displayUserDetailsCompleted()
            }
        })
        return binding.root
    }

}