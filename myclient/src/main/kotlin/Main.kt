import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.core5.http.NameValuePair
import org.apache.hc.core5.http.message.BasicNameValuePair
import org.apache.hc.core5.net.URIBuilder

fun main(){
    val httpGet = HttpGet("https://example.com")
    println(httpGet.uri.host)
    println(httpGet.requestUri)
    println(httpGet.path)
    val uri = URIBuilder("https://example.com").addParameter("ansj", "111").build()
    val uri2 = URIBuilder("https://example.com")
        .addParameters(listOf<NameValuePair>(BasicNameValuePair("ansj", "123"), BasicNameValuePair("ansj", "33"))).build()
    println("uri: $uri")
    println("uri2: $uri2")

    println()
    println()
    val list = listOf("ansj" to "123", "ansj2" to "456")
    val uri3 = URIBuilder("https://ansj.com")
    list.forEach{
        uri3.addParameter(it.first, it.second)
    }
    uri3.build()
    println("uri3: $uri3")
    val parameter = listOf<Pair<String, Any>>("ansj" to 1111, "ansj2" to "2222")
    val url = URIBuilder("https://ansj.com")
    parameter.forEach{
        url.addParameter(it.first, it.second.toString())
    }
    url.build()
    println("url: $url")

    val map = mapOf("ansj" to "123", "ansj2" to 222)

    map.entries.forEach{
        println("key: ${it.key} / value: ${it.value}")
    }

    val result = httpGet("https://jsonplaceholder.typicode.com/posts")
    println("result: $result")
}