package entity

class Client{
    var id: String
    var roomId: String

    constructor(id: String, roomId: String){
        this.id = id
        this.roomId = roomId
    }
    constructor(){
        this.id = ""
        this.roomId = ""
    }
}