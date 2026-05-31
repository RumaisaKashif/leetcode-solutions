class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> parenthesesStack = new Stack<>();
        for (char c : array) { 
            if (c == '[' || c == '{' || c == '(') { 
                parenthesesStack.push(c);
            } else if (!parenthesesStack.isEmpty()) { 
                char p = parenthesesStack.peek();
                if (p == '{' && c == '}') { 
                   parenthesesStack.pop();
                } else if (p == '[' && c == ']') {
                    parenthesesStack.pop();
                } else if (p == '(' && c == ')') {
                    parenthesesStack.pop();
                } else { 
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return parenthesesStack.isEmpty();
    }
}