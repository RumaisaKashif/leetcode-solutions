class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # naiive solution: iterate over every row and every column and every box - n^3
        # hashmap duplicate detection? go row by row, col by col, box by box
        # key: [x, y, number]- wrong, fixing position doesnt help duplicate detection
        # key: [row number, box number, col number, value] - wrong, everything dependent, we need indep checks
        # trick: 3 different constraints = 3 different unique checks
        # index blocks - use hashmap to map position to index - wasted space
        # use formula based approach to get block number
        hs = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                val = board[i][j]
                if val == ".":
                    continue
                    
                if ("R", i, val) not in hs:
                    hs.add(("R", i, val))
                else:
                    return False

                if ("C", j, val) not in hs:
                    hs.add(("C", j, val))
                else:
                    return False
                
                box_number = (i // 3) * 3 + (j // 3)
                if ("B", box_number, val) not in hs:
                    hs.add(("B", box_number, val))
                else:
                    return False
            
        return True