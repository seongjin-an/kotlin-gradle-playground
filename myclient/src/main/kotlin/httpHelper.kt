import javafx.util.Pair
import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.client5.http.classic.methods.HttpPost
import org.apache.hc.client5.http.config.RequestConfig
import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.core5.http.HttpEntity
import org.apache.hc.core5.http.io.entity.ByteArrayEntity
import org.apache.hc.core5.http.io.entity.EntityUtils
import org.apache.hc.core5.http.message.BasicHeader
import org.apache.hc.core5.http.message.BasicNameValuePair
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
    parameter?.map{ _param -> BasicNameValuePair(_param.key, _param.value.toString()) }?.let{ _params -> url.addParameters(_params) }
    try {
        val httpGet = HttpGet(url.build())
        httpGet.apply{ config = RequestConfig.custom().setConnectTimeout(Timeout.ofMilliseconds(timeout)).build() }
        httpGet.setHeader("Content-Type", "application/json")
        header?.entries?.map{ _header -> BasicHeader(_header.key, _header.value) }?.forEach{ _header -> httpGet.setHeader(_header) }
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

fun httpPost(
    reqUrl: String,
    parameter: List<Pair<String, Any>>? = null,
    header: Map<String, Any>? = null,
    body: Any? = null,
    timeout: Long = 3000
): String?{
    var result: String? = null
    val httpClient = HttpClients.createDefault()
    val url = URIBuilder(reqUrl)
    parameter?.map{ _param -> BasicNameValuePair(_param.key, _param.value.toString()) }?.let{ _params -> url.setParameters(_params) }
    try{
        val httpPost = HttpPost(url.build())

        // 1. bytearray body 요청해야 하는 상황이 아니고 gson, jackson 의존성 둘 다 없는 상황이라면 이거 사용!
        // bytearray body 요청을 해야하는 상황이라면 2번 또는 3번을 사용
//        httpPost.entity = StringEntity(body.toString())

        // 2. bytearray body 요청해야 하는 상황이라면, gson 은 없고 jackson 이 있다면 jackson 사용(부트는 디폴트라서 있음)
//        httpPost.entity = ByteArrayEntity(ObjectMapper().writeValueAsBytes(body), ContentType.APPLICATION_JSON)

        // 3. bytearray body 요청해야 하는 상황이라면, jackson 은 없고 gson 이 있다면 이거 사용
//        httpPost.entity = ByteArrayEntity(Gson().toJson(body).toByteArray(Charsets.UTF_8), ContentType.APPLICATION_JSON)

        httpPost.apply{ config = RequestConfig.custom().setConnectTimeout(Timeout.ofMilliseconds(timeout)).build() }
        httpPost.setHeader("Content-Type", "application/json")
        header?.entries?.map{ _header -> BasicHeader(_header.key, _header.value) }?.forEach{ _header -> httpPost.setHeader(_header) }
        val response = httpClient.execute(httpPost)
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
