
func totalNQueens(n int) int {
    count := 0
    totalNQueensHelper(&count, n)
    return count
}


func totalNQueensHelper(countAddr *int, n int) {
    board := make([][]string, n)
    for i := 0; i < n; i++ {
        board[i] = make([]string, n)
    }
    // var count int;
    // count = 0;
    for i := 0; i < n; i++ {
        for j := 0; j < n; j++ {
            board[i][j] = "."
        }
    }
    dfs(board, 0, countAddr)
    return 
    
}

func dfs(board [][]string, colIndex int, countAddr *int)  {
    if colIndex == len(board) {
        *countAddr++
        return
    }
    // Todo
    for i := 0; i < len(board); i++ {
        if validate(board, i, colIndex) {
            board[i][colIndex] = "Q";
            dfs(board, colIndex + 1, countAddr);
            board[i][colIndex] = ".";
        }
    }
}

func validate(board [][]string, x int, y int) bool {
    for i := 0; i < len(board); i++ {
        for j := 0; j < y; j++ {
            if board[i][j] == "Q" && (x + j == y + i || x + y == i + j || x == i) {
                return false;
            }
        }
    }
    return true;
}

