/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        return traverse(root);
    }
    
    public List<Integer> traverse(Node root) {
        if(root == null) {
            return List.of();
        }
        
        List<Integer> result = new ArrayList<>();
        for(Node node: root.children) {
            result.addAll(traverse(node));
        }
        
        result.add(root.val);
        
        return result;
    }
}