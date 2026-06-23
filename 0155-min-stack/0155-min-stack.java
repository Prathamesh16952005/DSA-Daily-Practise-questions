class MinStack {
    Stack<Long> s;
    long minv;

    public MinStack() {
        
         
        s = new Stack<>();
    }
    
    public void push(int value) {
        if(s.isEmpty()){
            s.push((long) value);
            minv= value;
        }else{
            if(value < minv){
                s.push(2L*value - minv);
                minv = value;
            }else{
                s.push((long) value);
            }
        }

    }
    
    public void pop() {
        long top = s.pop();

         if(top < minv){
            minv=2*minv -top;
      }
    }
    
    public int top() {
     long top = s.peek();
     if(top<minv){
        return(int) minv;
        
     } 
     return(int) top;  
    }
    
    public int getMin() {
        return (int) minv;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */