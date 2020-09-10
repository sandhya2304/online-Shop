$(function(){
	
	switch(menu){
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
		default:
			if(menu == "Home") break;
			$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
		
	}
	
	//code for jquery table
	
	var products  = [
		[1,"ABC"],
		[2,"DFR"],
		[3,"GHI"],
		[4,"JKL"],
		[5,"MNO"]
	];
	
	var $table=$('#productListTable');
	if($table.length){
		//console.log('inside the table');
		
		
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','Ten Records','ALL']],
			pageLength:5,
			data:products
		});
		
		
		
		
	}
	
	
});