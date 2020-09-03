package com.mfv.dev.proyectofase1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mfv.dev.proyectofase1.R
import com.mfv.dev.proyectofase1.model.Pet
import kotlinx.android.synthetic.main.pet_row.view.*
import java.lang.IllegalArgumentException

class PetAdapter(val context : Context, val petList: List<Pet>, val itemClickListener: OnPetClickListener) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnPetClickListener{
        fun OnItemClick(item: Pet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PetViewHolder(LayoutInflater.from(context).inflate(R.layout.pet_row, parent, false))
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PetViewHolder -> holder.bind(petList[position], position)
            else -> throw  IllegalArgumentException("No se reconoce el holder")
        }
    }

    inner class PetViewHolder(itemView: View) : BaseViewHolder<Pet>(itemView){
        override fun bind(item: Pet, position: Int) {
            itemView.setOnClickListener{itemClickListener.OnItemClick(item)}

            Glide.with(context).load(item.img).into(itemView.pet_img)
            itemView.pet_name.text = item.name
        }

    }
}