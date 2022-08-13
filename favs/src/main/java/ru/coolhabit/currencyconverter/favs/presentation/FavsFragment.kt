package ru.coolhabit.currencyconverter.favs.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.coolhabit.currencyconverter.favs.R
import ru.coolhabit.currencyconverter.favs.databinding.FragmentFavsBinding
import ru.coolhabit.currencyconverter.presentation.base.BaseFragment

class FavsFragment : BaseFragment(R.layout.fragment_favs) {

    private val viewModel by viewModels<FavsViewModel>()
    private lateinit var binding: FragmentFavsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
