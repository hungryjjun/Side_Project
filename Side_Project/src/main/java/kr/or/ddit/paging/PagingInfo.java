package kr.or.ddit.paging;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagingInfo<T> {

	//기본생성자
	public PagingInfo() {
		//한 페이지10개, 페이지블로5개 기본설정
		this(10,5);
	}

	public PagingInfo(int screenSize, int blockSize) {
		this.screenSize = screenSize; //전달받은 사이즈로 초기화
		this.blockSize = blockSize; //전달받은 사이즈로 초기화
		this.currentPage =1; //현재 페이지는 1페이지로 기본설정
	}
	//검색지원
	@Setter
	private SimpleCondition simpleCondition;
	
	//상세조건 담는객체 VO
	private T detailCondition;
	//한 페이지 보여줄 수 (게시글 수), 생성자에서 초기화
	private int screenSize;
	//한 페이지에서 제공할 페이지 링크 수 (페이지 번호), 생성자 초기화
	private int blockSize;
	//전체 레코드수, 검색 조건에 맞는 전체 데이터 개수
	@Setter
	private int totalRecord;
	//사용자 요청페이지 (현재보고있는 페이지)
	@Setter
	private  int currentPage;
	//현재 페이지에서 보여줄 시작 번호(현재3페이지일때, 21 , //30 - 9 = 21 
	public int getStartRow() {
		return getEndRow() - (screenSize-1); 
	}
	//현재 페이지에서 보여줄 끝 번호 (3페이지, 10개씩이면 3*10 =30)
	public int getEndRow() {
		return currentPage * screenSize;
	}
	//전체 페이지수 반환
	//ex) 총27행일시, 27 + 9 / 10 = 3페이지
	public int getTotalPage() {
		return (totalRecord + (screenSize -1)) / screenSize;
	} 
	//현재 페이지 네비게이션 블록에서 표시될 시작페이지 번호 반환
	//ex) 현재6페이지일시, 10 - (5-1) ==> 10-4 = 6 
	//ex) 현재7페이지일시, 10 - (5-1) ==> 10-4 = 6 
	public int getStartPage() {
		return getEndPage() - (blockSize -1);
	}
	//현재 페이지 네비게이션 블록에서 표시될 끝 페이지 번호
	//ex) 7페이지일시, 7 +(5-1) / 5 = 5  ==> 11 / 5 = 2,  2*5 = 10페이지
	public int getEndPage() {
		return ((currentPage + (blockSize-1)) / blockSize) * blockSize;
	}
}
