package ru.coolhabit.currencyconverter.currency.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.currencyconverter.currency.R
import ru.coolhabit.currencyconverter.currency.databinding.RvCurrencyItemBinding
import ru.coolhabit.currencyconverter.entities.dto.Currency

class CurrencyListViewHolder(
    private val binding: RvCurrencyItemBinding,
    private val onFavClick: (Currency) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Currency) {
        with(binding) {
            currencyName.text = item.currencyName
            currencyRate.text = item.currencyRate.toString()
            if (item.isFav) {
                favBtn.setImageResource(R.drawable.ic_fav_money_checked)
            } else {
                favBtn.setImageResource(R.drawable.ic_fav_money)
            }
            favBtn.setOnClickListener {
                onFavClick.invoke(item)
            }
        }
    }
}
