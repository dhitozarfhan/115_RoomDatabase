package com.example.roomdatabase.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdatabase.repositori.AplikasiSiswa
import com.example.roomdatabase.repositori.RepositoriSiswa
import com.example.roomdatabase.viewmodel.EntryViewModel
import com.example.roomdatabase.viewmodel.HomeViewModel

object PenyediaViewModel {

    val Factory = viewModelFactory{
        initializer {
            HomeViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }

        initializer {
            EntryViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }

        initializer {
            DetailViewModel(savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().containerApp.repositoriSiswa)

        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory
        .APPLICATION_KEY] as AplikasiSiswa)