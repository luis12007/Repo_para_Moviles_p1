package com.example.basketapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.basketapp.databinding.FragmentPrincipalBinding


class principalFragment : Fragment() {

    // data
    private var scoreaPlus =0
    private var scorebPlus =0
    private lateinit var binding : FragmentPrincipalBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_principal, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.actionEndGame.setOnClickListener {
            if (scoreaPlus <scorebPlus){
                viewModel.Ganador = MutableLiveData("Gana Team B, Felicidades")
            }else{
                viewModel.Ganador = MutableLiveData("Gana Team A, Felicidades")
            }

            val navController = findNavController()
            navController.navigate(R.id.action_principalFragment_to_pointsFragment)

        }
        binding.actionScoreTeamA.setOnClickListener{
            scoreaPlus++
            binding.scoreTeamA.text = scoreaPlus.toString()
        }
        binding.actionScoreTeamB.setOnClickListener{
            scorebPlus++
            binding.scoreTeamB.text = scorebPlus.toString()

        }
    }

}