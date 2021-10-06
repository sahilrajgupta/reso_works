package com.example.reso_works

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.popup_window.*
import kotlinx.android.synthetic.main.popup_window.view.*

class BottomSheet(private val list: List<GridItem>,var position:Int) : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.popup_window,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.desc.setText(list[position].desc)

        close.setOnClickListener{
            dismiss()
        }
    }
}