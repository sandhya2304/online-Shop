
<div class="container">

<!-- Bread crumb -->
  <div class="row">
  
   <div class="col-xs12">
   
     <ol class="breadcrumb">
       
       <li><a href="${contextRoot}/home">Home</a> </li>
       <li><a href="${contextRoot}/show/all/products">View Product</a> </li>
        <li class="active"> ${product.name} </li>
     </ol>
     
     </div> 
  </div>
  
  <!-- display product -->
  <div class="row">
     
     <!-- display product image -->
     <div class="col-xs-12 col-sm-4">
     
       <div class="thumbnail">
       
          <img src="${images}/${product.code}.jpg" class="img img-responsive" />
       
       </div>
     
     
     </div>
     
     <!-- display product description -->
      <div class="col-xs-12 col-sm-8">
        
          <h3>${product.name }</h3>
          <hr/>
          
          <p>${product.description} </p>
          <hr/>
          
          <h4>Price: <strong> &#8377; ${product.unitPrice} /- </strong></h4>
          <hr/>
          
         
          <!-- quantity is 0 -->
          <c:choose>
             <c:when test="${product.quantity < 1 }">
                 <h6>Qty. Avilable: <span style="color:red" >Out Of Stock</span> </h6>
             </c:when>
             <c:otherwise>
                 <h6>Qty. Avilable: ${product.quantity }  </h6>
             </c:otherwise>
          </c:choose>
          
          
          <!-- Add to cart quantity -->
           <c:choose>
             <c:when test="${product.quantity < 1 }">
                    <a href="javascript.void(0)" class="btn btn-success disabled"><strike>
          <span class="glyphicon glyphicon-shopping-cart"></span>
          Add To Cart</a></strike>
             </c:when>
             <c:otherwise>
                  <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
          <span class="glyphicon glyphicon-shopping-cart"></span>
          Add To Cart</a>
             </c:otherwise>
          </c:choose>
          
          
         
          
          <a href="${contextRoot}/show/all/products" class="btn btn-primary">
         back</a>
     
     
     </div>
  
  
  
  </div>
  
  

</div>