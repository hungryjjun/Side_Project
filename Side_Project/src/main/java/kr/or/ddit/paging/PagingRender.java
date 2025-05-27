package kr.or.ddit.paging;

public interface PagingRender {

	public default String renderPaging(PagingInfo paging) {
		return renderPaging(paging, "fnPaging");
	}
	
	public String renderPaging(PagingInfo paging, String fnName);
}
