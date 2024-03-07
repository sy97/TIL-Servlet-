function nullCheck(){
	let kor = document.getElementsByName("kor")[0].value;
	//똑같은 이름이 여러개 있을 수 있어서 배열로 처리해줘야함.
	//하나밖에없어도 무조건 배열로처리해줘야함.
	
	let eng = document.getElementsByName("eng")[0].value;
	let math = document.getElementsByName("math")[0].value;
	
	//코드를 짤 땐 중간점검 해보기
	console.log(kor, eng, math);
	
	
	if(kor === "" || eng === "" || math === ""){
		alert("빈 칸을 채워주시기 바랍니다.");
		return false;
		//비워있으면 보내지 않고 멈춰줘야함.
	}
	return true;
}