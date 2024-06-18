class MinStack {

    ArrayList<Integer> values = new ArrayList<>();
    ArrayList<Integer> minValues = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        if(values.size()==0){
            values.add(val);
            minValues.add(val);
        }else{
            int lastValue = minValues.get(minValues.size()-1);
            int min = Math.min(lastValue, val);
            values.add(val);
            minValues.add(min);
        }

    }

    public void pop() {
        values.remove(values.size()-1);
        minValues.remove(minValues.size()-1);
    }

    public int top() {
        return values.get(values.size()-1);
    }

    public int getMin() {
        return minValues.get(minValues.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */