package com.ms.gymsapp
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GymsViewModel : ViewModel() {
    private fun getGyms() = listOfGyms
    var state = mutableStateOf(getGyms())
    fun toggleFavoriteState(gymId:Int){
        val gyms = state.value.toMutableList()
        val itemGym = gyms.indexOfFirst { it.id == gymId }
        gyms[itemGym] = gyms[itemGym].copy(isFavorite = !gyms[itemGym].isFavorite)
        state.value=gyms
    }

}