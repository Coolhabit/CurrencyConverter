package ru.coolhabit.currencyconverter.currency.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.currencyconverter.currency.databinding.RvCurrencyItemBinding
import ru.coolhabit.currencyconverter.entities.dto.Currency

class CurrencyListViewHolder(private val binding: RvCurrencyItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Currency) {
        with(binding) {
            currencyName.text = item.currencyName
            currencyRate.text = item.currencyRate.toString()
        }
    }
}
