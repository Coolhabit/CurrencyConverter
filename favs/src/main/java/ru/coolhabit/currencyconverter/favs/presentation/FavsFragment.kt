package ru.coolhabit.currencyconverter.favs.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.annotation.MenuRes
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.coolhabit.currencyconverter.entities.dto.SortType
import ru.coolhabit.currencyconverter.favs.R
import ru.coolhabit.currencyconverter.favs.databinding.FragmentFavsBinding
import ru.coolhabit.currencyconverter.favs.presentation.adapter.FavsListAdapter
import ru.coolhabit.currencyconverter.presentation.adapter.ItemDecoration
import ru.coolhabit.currencyconverter.presentation.base.BaseFragment
import ru.coolhabit.currencyconverter.presentation.extensions.RV_START
import javax.inject.Inject

class FavsFragment : BaseFragment(R.layout.fragment_favs) {

    private val viewModel by viewModels<FavsViewModel>()
    private lateinit var binding: FragmentFavsBinding

    @Inject
    lateinit var favsAdapter: FavsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadFavRatesList()
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
        binding.filterBtn.setOnClickListener {
            showMenu(it, ru.coolhabit.R.menu.popup_menu)
        }

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

        submitList()

        deleteClick()

        baseCurrencyController()
    }

    private fun baseCurrencyController() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.currencies.collect {
                val items = it
                val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
                (binding.favouritesMenu.editText as? AutoCompleteTextView)?.setAdapter(adapter)
                (binding.favouritesMenu.editText as? AutoCompleteTextView)?.setOnItemClickListener { adapterView, view, position, id ->
                    val selectedValue = adapter.getItem(position)
                    viewModel.baseCurrency = selectedValue
                    viewModel.loadFavRatesList()
                }
            }

        }
    }

    private fun deleteClick() {
        favsAdapter.onDeleteClick = {
            viewModel.removeFromFavourite(it)
            updateList()
        }
    }

    private fun submitList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadList.collect {
                favsAdapter.submitList(it)
            }
        }
    }

    private fun updateList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadList.collect {
                favsAdapter.submitList(it)
            }
        }
    }

    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(requireContext(), v)
        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
            when (item.itemId) {
                ru.coolhabit.R.id.alp_asc -> {
                    setSorting(SortType.ALP_ASC)
                }
                ru.coolhabit.R.id.alp_desc -> {
                    setSorting(SortType.ALP_DESC)
                }
                ru.coolhabit.R.id.value_asc -> {
                    setSorting(SortType.VALUE_ASC)
                }
                ru.coolhabit.R.id.value_desc -> {
                    setSorting(SortType.VALUE_DESC)
                }
            }
            true
        })

        popup.show()
    }

    private fun setSorting(sort: SortType) {
        viewModel.sortType = sort
        viewModel.loadFavRatesList()
        binding.rvFavourites.layoutManager?.smoothScrollToPosition(binding.rvFavourites, RecyclerView.State(), RV_START)
    }
}
