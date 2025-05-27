package kr.or.ddit.paging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultPagingRender implements PagingRender  {

	@Override
	public String renderPaging(PagingInfo paging, String fnName) {
		int startPage = paging.getStartPage();
		int endPage = paging.getEndPage();
		int totalPage = paging.getTotalPage();
		int blockSize = paging.getBlockSize();
		int currentPage = paging.getCurrentPage();
		
		//32페이지 (오류) > 31(total) --> 31로 담음
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		StringBuffer html = new StringBuffer();
		String pattern = "<a href='javascript:void(0);' onclick='"+fnName+"(%d);'>%s</a>\n";
		
		log.info("페이징9++++fnname : {}  ",fnName);
		log.info("페이징9++++startPage : {}  ",startPage);
		log.info("페이징9++++endPage : {}",endPage);
		log.info("페이징9++++totalPage : {}",totalPage);
		log.info("페이징9++++blockSize : {}",blockSize);
		log.info("페이징9++++currentPage : {} ",currentPage);
		log.info("페이징9++++pattern : {}",pattern);
		log.info("페이징9++++html : {}",html);
		log.info("페이징9++++paging : {} ",paging);
		
		//시작페이지 6 > 5 (이전포함), 1>5 (이전미포함)
		if(startPage > blockSize) {
			//patten문자열의 %d (start-block값), %s("이전문자열")
			html.append(String.format(pattern, startPage - blockSize, "이전"));
		}
		//3페이지 일시 시작페이지로 초기화, 마지막페이지11일때 
		for(int page = startPage; page <= endPage; page++) {
			//지금보고있는 페이지(3) = 3페이지시 클릭X, 페이지번호 보여줌 
			if(currentPage==page) {
				html.append(String.format("[%d]", page));
			}else {
			//3페이지 일떄 1,4,5페이지를 누를수 있게 해줌 onclick
				html.append(String.format(pattern, page, page));
			}
			//end:9페이지, total은 11페이지 , 아직페이지 남았음 "다음"
		}
		
		if(endPage < totalPage) {
			html.append(String.format(pattern, endPage+1, "다음"));
		}
		return html.toString();
	}
	
	

}
