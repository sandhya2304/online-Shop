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
              <sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="post">
                 <div class="form-group">
                   <label class="control-label col-md-4" for="name">Enter the Name</label>
                   <div class="col-md-8">
                     <sf:input type="text" path="name" id="name" placeholder="Enter name" class="form-control" />
                   
                   </div>                 
                 </div>
                 
                 <div class="form-group">
                   <label class="control-label col-md-4" for="brand">Enter the Brand</label>
                   <div class="col-md-8">
                     <sf:input type="text" path="brand" id="brand" placeholder="Enter brand" class="form-control" />
                     
                   </div>                 
                 </div>
                 
                  <div class="form-group">
                   <label class="control-label col-md-4" for="unitPrice">Enter the Product Description</label>
                   <div class="col-md-8">
                     <sf:textarea path="description" id="description" rows="4" placeholder="Enter the description" ></sf:textarea>
                     
                   </div>                 
                 </div>
                 
                    <div class="form-group">
                   <label class="control-label col-md-4" for="unitPrice">Enter the unitPrice</label>
                   <div class="col-md-8">
                     <sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Enter unitPrice" class="form-control" />
                     
                   </div>                 
                 </div>
                 
                 <div class="form-group">
                   <label class="control-label col-md-4" for="quantity">Enter the quantity</label>
                   <div class="col-md-8">
                     <sf:input type="number" path="quantity" id="quantity" placeholder="Enter quantity" class="form-control" />
                    
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


</div>