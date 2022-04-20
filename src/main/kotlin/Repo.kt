import com.google.gson.Gson

class Repo: UserInterface {
    override fun getUserI(): UserModel = getUser()

    override fun postUser(body: String): Boolean {
        return try {
            val student = Gson().fromJson<UserModel>(body, UserModel::class.java)
            true
        } catch (e: java.lang.Exception) {
            false
        }
    }
}