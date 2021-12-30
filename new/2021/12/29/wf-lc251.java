class Vector2D {
    private int[][] vector;
    private int inner = 0;
    private int outer = 0;
    public Vector2D(int[][] vec) {
        vector = vec;
    }
    
    public int next() {
        if (!hasNext()) {
            return -1;
        }
        return vector[outer][inner++];
    }
    
    public boolean hasNext() {
        advanceToNext();
        return outer < vector.length;
    }
    
    private void advanceToNext() {
        /*
        ["Vector2D","hasNext","next","hasNext"]
        [[[[1],[]]],[],[],[]]
        用while不用if：内层数组可能为空
        */
        while (outer < vector.length && inner == vector[outer].length) {
            inner = 0;
            outer++;
        }
    }
}

// class Vector2D {
//     ArrayList<Integer> vec1D;

//     public Vector2D(int[][] vec) {
//         vec1D = new ArrayList<Integer>();
//         for(int i = 0; i < vec.length; i++){
//             for(int y = 0; y < vec[i].length; y++){
//                 vec1D.add(vec[i][y]);
//             }
//         }
//     }
    
//     public int next() {
//         if(!hasNext()) {
//             return -1;
//         }
//         return vec1D.remove(0);
//     }
    
//     public boolean hasNext() {
//         if(vec1D.size() > 0) return true;
//         return false;
//     }
// }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
