import javafx.util.Pair
import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.client5.http.config.RequestConfig
import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.core5.http.HttpEntity
import org.apache.hc.core5.http.io.entity.EntityUtils
import org.apache.hc.core5.net.URIBuilder
import org.apache.hc.core5.util.Timeout
import java.io.IOException
import java.net.URISyntaxException

fun httpGet(
    reqUrl: String,
    parameter: List<Pair<String, Any>>? = null,
    header: Map<String, Any>? = null,
    timeout: Long = 3000
): String?{
    var result: String? = null
    val httpClient = HttpClients.createDefault()
    val url = URIBuilder(reqUrl)
    parameter?.forEach{ url.addParameter(it.key, it.value.toString()) }
    try {
        val httpGet = HttpGet(url.build())
        httpGet.apply{ config = RequestConfig.custom().setConnectTimeout(Timeout.ofMilliseconds(timeout)).build() }
        httpGet.setHeader("Content-Type", "application/json")
        header?.entries?.forEach { httpGet.setHeader(it.key, it.value) }
        val response = httpClient.execute(httpGet)
        val entity: HttpEntity = response.entity
        result = EntityUtils.toString(entity)
        EntityUtils.consume(entity)
    }catch(error: URISyntaxException){
        error.printStackTrace()
    }catch(error: IOException){
        error.printStackTrace()
    }
    return result
}