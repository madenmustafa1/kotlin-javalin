import io.javalin.Javalin

fun main() {
    val app = Javalin.create().start(7070)
    val repo = Repo()

    with(app) {
        get("/") { it.json("Welcome") }
        get("/get-user") { it.json(repo.getUserI()) }

        post("/get-user") {
            val res = repo.postUser(it.body())
            it.json(res)
            if (res) it.status(200)
            else it.status(404)
        }
    }
}


