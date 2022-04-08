package com.example.navegation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.navegation.databinding.FragmentLastBinding


class LastFragment : Fragment() {
     // private val args: LastFragmentArgs by navArgs()
    private lateinit var binding:FragmentLastBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
            .inflate(inflater,R.layout.fragment_last,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // binding.lastNameText.text = args.name
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.actionNext2.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_lastFragment_to_resultFragment)
        }
    }
}