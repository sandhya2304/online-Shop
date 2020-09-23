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
				
			   <tbody>
			   
			    <tr>
			     <td>2</td>
			     <td>
			        <img class="adminDataTableImg" src="${contextRoot}/resources/images/PRD9BB2F4DDDA.jpg" alt="MI Phone" />  </td>
			    
			     <td>MI Phone</td>
			       <td>OPPP</td>
			     <td>0</td>
			    
			     <td>&#8377; 23770.0</td>
			    
			    
			    <td>
			      <!-- toggle switch -->
                    <label class="switch">
                          
                          <input type="checkbox" checked="checked" value="2" />
                         <div class="slider"/>
                    </label>
                    			    
			    </td>
			    
			    <td>
			      
			       <a href="${contextRoot}/manage/2/product" class="btn btn-warning">
			          <span class="glyphicon glyphicon-pencil"></span>
			       </a>
			   
			    </td>
			    
			     </tr>
			     
			      <tr>
			     <td>2</td>
			     <td><img class="adminDataTableImg" src="${contextRoot}/resources/images/PRD9BB2F4DDDA.jpg" alt="MI Phone">  </td>
			     
			      <td>MI Phone</td>
			      <td>OPPP</td>
			     <td>0</td>
			     <td>&#8377; 23770.0</td>
			    <td>
			      <!-- toggle switch -->
                    <label class="switch">
                          
                          <input type="checkbox"  value="2" />
                         <div class="slider"/>
                    </label>
                    			    
			    </td>
			    
			    <td>
			      
			       <a href="${contextRoot}/manage/2/product" class="btn btn-warning">
			          <span class="glyphicon glyphicon-pencil"></span>
			       </a>
			   
			    </td>
			    
			     </tr>
			     
			   </tbody>
				
				
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
</div>