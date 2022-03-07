import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.core5.net.URIBuilder

fun main(){
    val httpGet = HttpGet("https://example.com/imsi")
    val uri = URIBuilder(httpGet.uri).addParameter("ansj", "111").build()
    println("uri: $uri")
}