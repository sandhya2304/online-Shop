 <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<div class="container">

   <div class="row">
   
   
   <c:if test="${not empty msg}">
     <div class="col-xs-12">
      
        <div class="alert alert-success alert-dismissible">
        
        <button type="button" class="close" data-dismiss="alert">&times;</button>
         
           ${msg }
        
        </div>
     
     </div>
   </c:if>
   
   
   
      <div class="col-md-offset-2 col-md-8">
        
         <div class="panel panel-primary">
           
            <div class="panel-heading">
            
                <h4> Product Management </h4>
              
            </div>
            <div class="panel-body">
            
              <!-- Form Elements -->
              <sf:form class="form-horizontal" modelAttribute="product" 
                                      action="${contextRoot}/manage/products" 
                                      method="post"
                                      enctype="multipart/form-data"
                                      >
                 <div class="form-group">
                   <label class="control-label col-md-4" for="name">Enter the Name</label>
                   <div class="col-md-8">
                     <sf:input type="text" path="name" id="name" placeholder="Enter name" class="form-control" />
                     <sf:errors path="name" cssClass="help-block" element="em" />
                   </div>                 
                 </div>
                 
                 <div class="form-group">
                   <label class="control-label col-md-4" for="brand">Enter the Brand</label>
                   <div class="col-md-8">
                     <sf:input type="text" path="brand" id="brand" placeholder="Enter brand" class="form-control" />
                         <sf:errors path="brand" cssClass="help-block" element="em" />
                   </div>                 
                 </div>
                 
                  <div class="form-group">
                   <label class="control-label col-md-4" for="unitPrice">Enter the Product Description</label>
                   <div class="col-md-8">
                     <sf:textarea path="description" id="description" rows="4" placeholder="Enter the description" ></sf:textarea>
                         <sf:errors path="description" cssClass="help-block" element="em" />
                   </div>                 
                 </div>
                 
                    <div class="form-group">
                   <label class="control-label col-md-4" for="unitPrice">Enter the unitPrice</label>
                   <div class="col-md-8">
                     <sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Enter unitPrice" class="form-control" />
                       <sf:errors path="unitPrice" cssClass="help-block" element="em" />
                   </div>                 
                 </div>
                 
                 <div class="form-group">
                   <label class="control-label col-md-4" for="quantity">Enter the quantity</label>
                   <div class="col-md-8">
                     <sf:input type="number" path="quantity" id="quantity" placeholder="Enter quantity" class="form-control" />
                      <sf:errors path="quantity" cssClass="help-block" element="em" />
                   </div>                 
                 </div>
                 
                 
                   <div class="form-group">
                   <label class="control-label col-md-4" for="file">Select an image:</label>
                   <div class="col-md-8">
                     <sf:input type="file" path="file" id="file"  class="form-control" />
                      <sf:errors path="file" cssClass="help-block" element="em" />
                   </div>                 
                 </div>
                 
                 
                    <div class="form-group">
                   <label class="control-label col-md-4" for="categoryId">Select Category :</label>
                   <div class="col-md-8">
                      <sf:select class="form-control" id="categoryId" path="categoryId"
                           items="${categories }"
                           itemLabel="name"
                           itemValue="id"
                      />
                      
                      <c:if test="${product.id == 0}">
                      
                      <div class="text-right">
                        <br/>
                        
                        <button type="button" data-toggle="modal" data-target="#myCategoyModal" class="btn btn-warning btn-sm">
                            Add Category
                        </button>
                      </div>  
                      
                      </c:if>
                      
                      
                   
                   </div>                 
                 </div>
                 
                  <div class="form-group">
                  
                   <div class="col-md-offset-4 col-md-8">
                     
                     <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary" />
                     
                     <!-- hidden fields -->
                     
                     <sf:hidden path="id" />
                      <sf:hidden path="code" />
                       <sf:hidden path="active" />
                      <sf:hidden path="supplierId" />
                      <sf:hidden path="purchases" />
                       <sf:hidden path="views" />
                     
                   </div>                 
                 </div>
              
              
              </sf:form>
            
            
            </div>
            
         
         </div>
      
      
      </div>   
   
   
   </div>

  <div class="row">
  
    <div class="col-xs-12">
     
      <h3>Available Products</h3> 
      <hr/>
    </div>
    
    <div class="col-xs-12">
      <div style="overflow:auto">
      
      
      <!-- products table for Admin -->
      
       <table id="adminproductsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</thBrand>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Active</th>				
						<th>Edit</th>
					</tr>				
				</thead>
				
			 
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Active</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
    
    
      </div>
    </div>
  </div>

 <!------------------ Category -------------------------------------------->
   
    <div class="modal fade" id="myCategoyModal" role="dialog" tabindex="-1">
       <div class="modal-dialog" role="document">
         <div class="modal-content">
         <!-- modal header -->
           <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">
                  <span>&times;</span>
              </button>
              <h4 class="modal-title">Add new Catgeory</h4>  
           </div>
           <div class="modal-body">
             <!-- Category Form -->
              
              <sf:form modelAttribute="category" action="${contextRoot}/manage/category" 
                            method="POST" class="form-horizontal">
                            
                 <div class="form-group">
                   <label for="category_name" class="control-label col-md-4">Category Name</label>
                   <div class="col-md-8">
                      <sf:input type="text" path="name" id="category_name" class="form-control" />
                   </div>
                 </div>      
                 <div class="form-group">
                   <label for="category_description" class="control-label col-md-4">Category Description</label>
                   <div class="col-md-8">
                      <sf:textarea cols="" rows="5" path="description" id="category_description" class="form-control" />
                   </div>
                 </div>    
                 
                 
                 <div class="form-group">                   
                   <div class="col-md-offset-4 col-md-8">
                       <input type="submit" value="Add Catgeory" class="btn btn-primary" />
                   </div>
                 </div>                 
           
              </sf:form>
           </div>
         </div> 
       </div>
    </div>






</div>