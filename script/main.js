let queue
let playState
window.addEventListener('load', () => {
    console.log('all resources loaded..')
    queue = new Queue()
    const list = Array(8).fill(0).map( (_, index) => index + 1)
    list.forEach(i => queue.enqueue(i))
    console.log('queue.getData():', queue.getData())
})

document.getElementById('play').addEventListener('click', () => {
    start()
})
document.getElementById('stop').addEventListener('click', () => {
    stop()
})
document.getElementById('initialize').addEventListener('click', () => {
    queue.initialize()
    console.log('queue.getSize:', queue.getSize())
    console.log('queue.isEmpty():', queue.isEmpty())
})

const start = () => {
    if(queue.isEmpty()){
        console.log('need to request some data')
    }else{
        playState = setInterval(() => {
            if(queue.isEmpty()){
                console.log('it is empty currently... end')
                clearInterval(playState)
            }else{
                console.log('dequeue:', queue.dequeue())
            }

        }, 1000)
    }
}
const stop = () => {
    clearInterval(playState)
    console.log('ramains:', queue.getData())
    console.log('size:', queue.getSize())
}
