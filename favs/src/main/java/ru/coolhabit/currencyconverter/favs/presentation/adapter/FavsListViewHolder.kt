package ru.coolhabit.currencyconverter.favs.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.favs.databinding.RvFavouritesItemBinding

class FavsListViewHolder(
    private val binding: RvFavouritesItemBinding,
    private val onDeleteClick: (Currency) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Currency) {
        with(binding) {
            favsName.text = item.currencyName
            favsRate.text = item.currencyRate.toString()
            deleteBtn.setOnClickListener {
                onDeleteClick.invoke(item)
            }
        }
    }
}
