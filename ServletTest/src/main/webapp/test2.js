function nulltest(){
	let kor = document.getElementsByName("kor")[0].value;
	let eng = document.getElementsByName("eng")[0].value;
	let math = document.getElementsByName("math")[0].value;
	
	if(kor == "" || eng == "" || math == ""){
		alert("빈 칸을 채워주시기 바랍니다.");
		return false;
	}
	return true;
}