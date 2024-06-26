package com.majustory.biz.psdBoard;

import java.util.List;

public interface PsdService {
   void  insert(PsdBoardVO  vo);
   List<PsdBoardVO>  select(PsdBoardVO  vo);
   PsdBoardVO edit(PsdBoardVO vo);
   void delete(PsdBoardVO vo);
}
