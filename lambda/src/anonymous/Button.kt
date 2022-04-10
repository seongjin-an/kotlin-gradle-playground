package anonymous

class Button {
    private var name: String
    private var buttonListener: IButton
    constructor(name: String, buttonListener: IButton){
        this.name = name
        this.buttonListener = buttonListener
    }

    fun click(message: String){
        buttonListener.clickEvent("$name, $message")
    }

}