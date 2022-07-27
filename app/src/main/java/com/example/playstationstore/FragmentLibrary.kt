package com.example.playstationstore

import androidx.fragment.app.Fragment

class FragmentLibrary : Fragment(R.layout.fragment_library) {

    companion object {
        @JvmStatic
        fun newInstance() = FragmentLibrary()
    }
}