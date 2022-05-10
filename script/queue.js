class Queue {
    constructor() {
        this._arr = []
    }
    enqueue = (item) => {
        this._arr.push(item)
    }
    dequeue = () => {
        return this._arr.shift()
    }
    isEmpty = () => {
        return this.getSize() === 0
    }
    getSize = () => {
        return this._arr.length
    }
    getData = () => this._arr
    initialize = () => this._arr = []
}

// const queue = new Queue()
// console.log('queue.isEmpty():', queue.isEmpty())
// queue.enqueue(41)
// console.log('queue.isEmpty():', queue.isEmpty())
// queue.enqueue(276)
// queue.enqueue(38)
// console.log('queue.getSize():', queue.getSize())
// console.log('queue.dequeue():', queue.dequeue())
// console.log('queue.getSize():', queue.getSize())
// queue.dequeue()
// console.log('queue.isEmpty():', queue.isEmpty())
// queue.dequeue()
// console.log('queue.isEmpty():', queue.isEmpty())
// console.log('//////////////////////////////////////////////////')
// const qu = new Queue()
// const list = [54235,2345,3457,5736,345]
// list.forEach(i => qu.enqueue(i))
// Array(qu.getSize()).fill(0).forEach((_, index) => {
//     console.log(index,'index:', qu.dequeue())
// })
// const arr = []
// arr[0] = 1
// arr[5] = 5
// arr[3] = 3
// arr.forEach(i => console.log(i))