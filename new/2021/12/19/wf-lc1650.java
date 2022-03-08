// Intuition: Approach 2 has constant space complexity, but we can simplify the code further when we consider that the problem really is asking for detecting intersection of two linked lists
// Time complexity: O(h1 + h2) where h1 and h2 are heights of the two given nodes
// Space complexity: O(1)

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node runner1 = p, runner2 = q;
        
        while (runner1 != runner2) { // Guaranteed to complete since both nodes belong to same tree
            // We are simulating a cycle when any of the conditions below is satisfied 
            // by pointing runner to the head of the other "list"  to make sure 
            // intersection is found before either of the below conditions are satisfied again
            runner1 = (runner1 == null)?q:runner1.parent;
            runner2 = (runner2 == null)?p:runner2.parent;
        }
        
        return runner1;
    }
}

-----------
    
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null) {
            return null;    
        }
        
        Set<Integer> parentOfP = new HashSet<>();
        
        /*
            h is maxHeight(heightP, heightQ)
            time: O(h) 
            space: O(h)
        */
        
        while (p != null) {
            parentOfP.add(p.val);
            p = p.parent;
        }
        
        while (q != null) {
            if (parentOfP.contains(q.val)) {
                return q;    
            }
            q = q.parent;
        }
        
        return null;   
    }
}

---
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
	    // Calculate height of both of the nodes
        int height1 = getHeight(p);
        int height2 = getHeight(q);
        
        // Make sure "p" always points to deeper node (for less code duplication)
		if (height1 < height2) {
            Node temp = q;
            q = p;
            p = temp;
        }
        
        // Move up to ensure the we start our search from same level for both the nodes
        int heightDiff = Math.abs(height1 - height2);
        while(heightDiff > 0) {
            p = p.parent;
            heightDiff--;
        }
        
		// Search upwards till the paths intersect
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        
        return p;
    }
    
    private int getHeight(Node node) {
        int height = 0;
        while (node != null) {
            node = node.parent;
            height++;
        }
        return height;
    }
}

