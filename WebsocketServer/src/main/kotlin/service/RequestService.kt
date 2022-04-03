package service

import entity.Client
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.util.*

class RequestService {
    companion object {
        //        fun registerClient(request: String): Client {
////            val decoder = Base64.getDecoder()
////            val res = String(decoder.decode(request))
//            val res = String(Base64.decodeBase64(request))
//            val parser = JSONParser()
//            val json = parser.parse(res) as JSONObject
//
//            val client = Client()
//
//            if(json["rid"] == null){
//                return client
//            }
//
//            client.roomId = json["rid"] as Int
//
//            if(json["id"] == null || json["token"] == null){
//                return client
//            }
//
//            val id = json["id"] as Long
//            val token = json["token"] as String
//
//            if(!checkToken(id, token)){
//                return client
//            }
//
//            client.id = id
//            return client
//        }
        fun registerClient(request: String): Client {
            val encoder = Base64.getEncoder()
            val encoded = encoder.encode(request.toByteArray())

            val client = Client(request, request)
            return client
        }
        private fun checkToken(id: Long, token: String): Boolean {
            return true
        }
    }
}