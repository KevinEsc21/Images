package com.escobar.threefragmentsactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.escobar.threefragmentsactivity.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.actionContinue.setOnClickListener {
            val complement = viewModel.complement.value!!

            if(! complement.isEmpty()){
                val navController = findNavController()
                navController.navigate(R.id.action_secondFragment_to_thirdFragment)
            }else{
                Toast.makeText(activity, getString(R.string.error_complement), Toast.LENGTH_SHORT).show();
            }
        }

        binding.actionSelectFruits.setOnClickListener {
            viewModel.complement.value = getString(R.string.action_frutas_text)
        }

        binding.actionSelectSalad.setOnClickListener {
            viewModel.complement.value = getString(R.string.action_salad_text)
        }

        binding.actionSelectPure.setOnClickListener {
            viewModel.complement.value = getString(R.string.action_pure_text)
        }
    }

}