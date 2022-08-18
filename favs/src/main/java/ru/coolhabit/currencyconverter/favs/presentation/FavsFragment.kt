package ru.coolhabit.currencyconverter.favs.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.coolhabit.currencyconverter.favs.R
import ru.coolhabit.currencyconverter.favs.databinding.FragmentFavsBinding
import ru.coolhabit.currencyconverter.favs.presentation.adapter.FavsListAdapter
import ru.coolhabit.currencyconverter.presentation.adapter.ItemDecoration
import ru.coolhabit.currencyconverter.presentation.base.BaseFragment
import javax.inject.Inject

class FavsFragment : BaseFragment(R.layout.fragment_favs) {

    private val viewModel by viewModels<FavsViewModel>()
    private lateinit var binding: FragmentFavsBinding

    @Inject
    lateinit var favsAdapter: FavsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadFavList(null)
        viewModel.loadCurrencies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFavourites.apply {
            adapter = favsAdapter
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

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadList.collect {
                favsAdapter.submitList(it)
            }
        }

        favsAdapter.onDeleteClick = {
            viewModel.removeFromFavourite(null, it)
            updateList()
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.loadSymbols.collect {
                val items = it
                val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
                (binding.favouritesMenu.editText as? AutoCompleteTextView)?.setAdapter(adapter)
                (binding.favouritesMenu.editText as? AutoCompleteTextView)?.setOnItemClickListener { adapterView, view, position, id ->
                    val selectedValue = adapter.getItem(position)
                    viewModel.loadFavList(selectedValue)
                }
            }

        }
    }

    fun updateList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadList.collect {
                favsAdapter.submitList(it)
            }
        }
    }
}
