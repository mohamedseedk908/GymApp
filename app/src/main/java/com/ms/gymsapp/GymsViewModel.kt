package com.ms.gymsapp
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class GymsViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private fun getGyms() = listOfGyms
    var state = mutableStateOf(restoreGym())
    fun toggleFavoriteState(gymId:Int) {
        val gyms = state.value.toMutableList()
        val itemGym = gyms.indexOfFirst { it.id == gymId }
        gyms[itemGym] = gyms[itemGym].copy(isFavorite = !gyms[itemGym].isFavorite)
        toggleFavorite(gyms[itemGym])
        state.value=gyms
    }


    fun toggleFavorite(gym: Gym) {
        val savedHandleList = savedStateHandle.get<List<Int>?>(FAV_IDS).orEmpty().toMutableList()
        if (gym.isFavorite)
        {
            savedHandleList.add(gym.id)
        }
        else
        {
            savedHandleList.remove(gym.id)
        }

        savedStateHandle[FAV_IDS] = savedHandleList
    }


    companion object {
        const val FAV_IDS = "Favorite Gyms Ide"
    }

    private fun restoreGym(): List<Gym>{
        val gyms = getGyms()
        savedStateHandle.get<List<Int>?>(FAV_IDS)?.let { ides->
            ides.forEach { gymId->
                gyms.find { it.id == gymId }?.isFavorite = true
            }
        }
        return gyms
    }

}