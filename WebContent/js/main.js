$(function(){
	$("#btn").click(function(){
		$.ajax({
			url:"../Hello/GetPerson",
			type:"get",
			data:{name:"liulimei"},
			success:function(data){
				//var p=JSON.parse(data); //转换为json对象
				alert(data);
//				alert(p.name);
//				alert(p.age);
			},
			error:function(ex,arguments){
				alert(arguments);
			}
		});
		
	});
	$("#btnObj").click(function(){
		var person={name:"mumeiliuli",age:10};
		$.ajax({
			url:"../Hello/GetPersonInfo",
			type:"post",
			data:person,
			success:function(data){
				alert(data);
			},
			error:function(ex,arguments){
				alert(arguments);
			}
		});
		
	});
	
});
