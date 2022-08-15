package ru.coolhabit.currencyconverter.currency.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.coolhabit.currencyconverter.currency.databinding.RvCurrencyItemBinding
import ru.coolhabit.currencyconverter.entities.dto.Currency
import javax.inject.Inject

class CurrencyListAdapter @Inject constructor() : ListAdapter<Currency, CurrencyListViewHolder>(CurrencyListDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvCurrencyItemBinding.inflate(inflater, parent, false)
        return CurrencyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CurrencyListDiffUtils : DiffUtil.ItemCallback<Currency>() {
        override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
            return oldItem.currencyName == newItem.currencyName
        }

        override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
            return oldItem == newItem
        }
    }
}
