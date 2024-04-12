class MinStack {
	public:
		stack<int>s,minn;
		void push(int val) {
			s.push(val); 
			if(minn.size()==0 || val<=minn.top()){
				minn.push(val);
			}
		}

		void pop() {

			if(minn.top() == s.top()) 
				minn.pop();
			s.pop();
		}

		int top() {
			return s.top();
		}

		int getMin() {
			return minn.top();
		}
};
