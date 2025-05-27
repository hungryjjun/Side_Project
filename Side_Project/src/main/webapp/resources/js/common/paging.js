/** 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      			수정자           수정내용
 *  -----------   	-------------    ---------------------------
 * 2025. 5. 26.     	youngjun            최초 생성
 *
 * </pre>
 */
document.addEventListener("DOMContentLoaded",function(){
	
	window.fnPaging  = function(page){
		const params = new URLSearchParams(window.location.search);
		params.set("page",page);
		location.href = window.location.pathname + "?" + params.toString();
	};
});