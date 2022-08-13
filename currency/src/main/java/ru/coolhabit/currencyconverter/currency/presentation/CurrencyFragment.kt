package ru.coolhabit.currencyconverter.currency.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.coolhabit.currencyconverter.currency.R
import ru.coolhabit.currencyconverter.currency.databinding.FragmentCurrencyBinding
import ru.coolhabit.currencyconverter.presentation.base.BaseFragment

class CurrencyFragment : BaseFragment(R.layout.fragment_currency) {

    private val viewModel by viewModels<CurrencyViewModel>()
    private lateinit var binding: FragmentCurrencyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrencyBinding.inflate(inflater, container, false)
        return binding.root
    }
}
