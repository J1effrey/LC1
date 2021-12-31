class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a == null? q : a.parent;
            b = b == null? p : b.parent;    
        }
        return a;
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

