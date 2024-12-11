package fr.averin.deezertest.repository

interface UserRepository {

    fun getProfilePictureUrl(): String

    fun getUsername(): String

    fun getFollowers(): Int

    fun getFollowings(): Int

}

class DemoUserRepository: UserRepository {

    override fun getProfilePictureUrl(): String {
        return "https://www.zooplus.fr/magazine/wp-content/uploads/2024/04/capybara1-768x511.jpeg"
    }

    override fun getUsername(): String {
        return "Jean Claude"
    }

    override fun getFollowers(): Int {
        return 300
    }

    override fun getFollowings(): Int {
        return 20000
    }

}
