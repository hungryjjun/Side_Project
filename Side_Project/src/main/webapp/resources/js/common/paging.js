/** 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      			수정자           수정내용
 *  -----------   	-------------    ---------------------------
 * 2025. 5. 26.     	youngjun            최초 생성
 *
 * </pre>
 * 
 * pagin.js
 */
document.addEventListener("DOMContentLoaded",function(){
	console.log("페이징js");
	const $searchForm = $("#search-form");
	const $searchUi = $("#search-ui");
	const $searchBtn = $("#search-btn");
	
	$searchForm.find(":input[data-init-value]").each(function(idx, input){
		let initValue = input.dataset.initValue;
		$(input).val(initValue);
	});

		$searchUi.find(":input[data-init-value]").each(function(idx,input){
		let initValue = input.dataset.initValue;
		$(input).val(initValue);
	});
	
	
	fnPaging = function(page) {
	//location.href="?page"+page;
	$searchForm.find("[name='page']").val(page);
	$searchForm.submit();
}


	$searchBtn.on("click",function(){
		//let searchUi = $(this).parents("search-ui");
		console.log("페이징js클릭함");
		let searchUi = $searchUi;
		//select, input 입력용태그 찾음
		$searchUi.find(":input[name]").each(function(idx,input){
			let name = input.name;
			let value = $(input).val();
			$searchForm.find(`[name='${name}']`).val(value);
		}); //each end
		$searchForm.submit();
	});
});