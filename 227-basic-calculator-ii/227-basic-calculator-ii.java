class Solution {
  public int calculate(String s) {
   //   s = refine(s);
    Stack<Integer> num = new Stack<>();
    Stack<Character> oper = new Stack<>();
    int i = 0;
    char ch;
    while (i < s.length()) {
      ch = s.charAt(i);

      int val = 0;
      while (i < s.length() && ch >= '0' && ch <= '9') {
        ch = s.charAt(i);
        val = val * 10 + (ch - '0');
        if (i + 1 < s.length() && s.charAt(i + 1) >= '0' &&  s.charAt(i + 1) <= '9' ) i++;
        else break;
      }
      if (val != 0 || ch == '0')
        num.push(val);
      else if (ch == '(')
        oper.push('(');
      else if (ch == ')') {
        while (oper.peek() != '(') {
          int b = num.pop();
          int a = num.pop();
          char op = oper.pop();
          num.push(performOp(a, op, b));
        }
        oper.pop(); //pop (
      }
      else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        while (oper.size() > 0 && oper.peek() != '(' && precedence(oper.peek()) >= precedence(ch)) {
          int b = num.pop();
          int a =num.pop();
          char op = oper.pop();
          num.push(performOp(a, op, b));
        }
        oper.push(ch); //add yourself
      }
      i++;
    }

    while (oper.size() > 0) {
      int b = num.pop();
      int a = num.pop() ;
      char op = oper.pop();
      num.push(performOp(a, op, b));
    }
    return num.peek();
  }
  int performOp(int a, char op, int b) {

    if(op == '/')
        return a / b;
      else if(op == '*')
          return a * b;
    else if (op == '+')
      return a + b;
    else
      return a - b;
  }

  int precedence(char op) {
    if (op == '/'|| op == '*') return 2;
     if (op == '-' || op == '+') return 1;
    return 0;
  }
    
   String refine(String s){
       StringBuilder res= new StringBuilder("");
       for(int i = 0;i<s.length();i++){
           if((i == 0 && s.charAt(i) == '-') || (res.length() > 0 && res.charAt(res.length() - 1) == '('))
               res.append("0");
           
           res.append(s.charAt(i));
       }
       return res.toString();
   }
}