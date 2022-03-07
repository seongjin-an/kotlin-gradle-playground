import javafx.util.Pair
import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.client5.http.impl.classic.HttpClients

fun httpGet(
    url: String,
    parameter: List<Pair<String, Any>>? = null,
    header: Map<String, Any>? = null,
    timeout: Int = 3000
){
    val httpClient = HttpClients.createDefault()

    val httpGet = HttpGet(url)
//    httpGet.
}