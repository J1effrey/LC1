type MinStack struct {
    elements []int 
    min int
}


func Constructor() MinStack {
    return MinStack{make([]int, 0), math.MaxInt64}
}


func (this *MinStack) Push(val int)  {
    if val <= this.min {
        this.elements = append(this.elements, this.min)
        this.min = val
    }
    this.elements = append(this.elements, val)
    // fmt.Println(this.elements, this.min)
}


func (this *MinStack) Pop()  {
    l := len(this.elements)
    popVal := this.elements[l - 1]
    this.elements = this.elements[:(l - 1)] // pop current val
    if popVal == this.min {
        this.min = this.elements[len(this.elements) - 1]
        this.elements = this.elements[:(len(this.elements) - 1)] 
    }
}


func (this *MinStack) Top() int {
    return this.elements[len(this.elements) - 1]
}


func (this *MinStack) GetMin() int {
    return this.min
}
