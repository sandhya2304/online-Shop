$(function(){
	
	switch(menu){
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
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
	
	
	
	var $table=$('#productListTable');
	if($table.length){
		//console.log('inside the table');
		
		
		var jsonURL = '';
		if(categoryId == ''){
			jsonURL   = window.contextRoot+'/json/data/all/products';
		} else{
			jsonURL   = window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
		
		
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','Ten Records','ALL']],
			pageLength:5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
				{
					data : 'code',
					mRender : function(data,type,row){
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'unitPrice',
					mRender : function(data,type,row){
						return '&#8377;'+data;
					}
				},
				{
					data : 'quantity',
					mRender : function(data,type,row){
						if(data < 1){
							return '<span style="color:red">Out Of Stock</span>';
						}
						return data;
					}
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data,type,row){

                          var str = '';
						 str += '<a href ="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
                       
						 if(row.quantity < 1){
							 str += '<a href ="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						 }else{
							 str += '<a href ="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						 }
						 
						
                         
                         return str;
						
					}
				},
				
				
			]
		});
   }
	
	//dismissing the alert after 3 seconds
	
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}
	
	//------------------------------------------------------------------------------------
	
	$('.switch input[type="checkbox"]').on('change',function ()
   		 {
          var checkbox= $(this);
          var checked= checkbox.prop('checked');
          var dmsg = (checked)? 'you want to activate your product?' : 
       	                      'you want to deactivate?' ;
          var value= checkbox.prop('value');
          
          bootbox.confirm({
       	   size: 'medium' ,
       	   title: 'Product Activation and deactivation' ,
       	   message: dmsg ,
       	   callback : function (confirmed)
       	       {      		   
       		      if(confirmed)
       		         {
       		    	  console.log(value);
       		    	  bootbox.alert({
       		    		 size:'medium',
       		    		 title:'Information',
       		    		 message:'You are going to perform operatrion on product '+ value
       		    	  });
       		    	     		    	  
       		         }else{
       		        	  
       		        	  checkbox.prop('checked', !checked);       		         
       		         }   		   
       	       }
          });
          
   		 });
     
          //************************************************************
          
          
          
          
});