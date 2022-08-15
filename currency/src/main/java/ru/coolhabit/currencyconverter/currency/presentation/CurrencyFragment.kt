package ru.coolhabit.currencyconverter.currency.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import ru.coolhabit.currencyconverter.currency.R
import ru.coolhabit.currencyconverter.currency.databinding.FragmentCurrencyBinding
import ru.coolhabit.currencyconverter.currency.presentation.adapter.CurrencyListAdapter
import ru.coolhabit.currencyconverter.presentation.adapter.ItemDecoration
import ru.coolhabit.currencyconverter.presentation.base.BaseFragment
import javax.inject.Inject

class CurrencyFragment : BaseFragment(R.layout.fragment_currency) {

    private val viewModel by viewModels<CurrencyViewModel>()
    private lateinit var binding: FragmentCurrencyBinding

    @Inject
    lateinit var currencyAdapter: CurrencyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCurrencyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrencyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCurrency.apply {
            adapter = currencyAdapter
            itemAnimator = null
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                ItemDecoration(
                    context,
                    R.dimen.spacing_3,
                    R.dimen.spacing_0,
                    R.dimen.spacing_0,
                    R.dimen.spacing_3
                )
            )
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.loadCurrency.collect {
                currencyAdapter.submitList(it)
            }
        }
    }
}
