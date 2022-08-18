package ru.coolhabit.currencyconverter.favs.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.favs.databinding.RvFavouritesItemBinding
import javax.inject.Inject

class FavsListAdapter @Inject constructor() : ListAdapter<Currency, FavsListViewHolder>(FavsListDiffUtils()) {

   var onDeleteClick: (Currency) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvFavouritesItemBinding.inflate(inflater, parent, false)
        return FavsListViewHolder(binding, onDeleteClick)
    }

    override fun onBindViewHolder(holder: FavsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FavsListDiffUtils : DiffUtil.ItemCallback<Currency>() {
        override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
            return oldItem.currencyName == newItem.currencyName
        }

        override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
            return oldItem == newItem
        }
    }
}
