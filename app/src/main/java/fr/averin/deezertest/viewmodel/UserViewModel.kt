package fr.averin.deezertest.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.averin.deezertest.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    fun getProfilePictureUrl(): String {
        return userRepository.getProfilePictureUrl()
    }

    fun getUsername(): String {
        return userRepository.getUsername()
    }

    fun getFollowers(): Int {
        return userRepository.getFollowers()
    }

    fun getFollowings(): Int {
        return userRepository.getFollowings()
    }

}