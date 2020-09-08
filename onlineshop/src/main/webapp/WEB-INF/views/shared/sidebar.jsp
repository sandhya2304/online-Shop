<p class="lead">Shop Name</p>
                <div class="list-group">
                
                <c:forEach items="${categories}" var="cat">
                
                 <a href="${contextRoot}/show/category/${cat.id}/products" class="list-group-item" id="a_${cat.name}">${cat.name } </a>
                
                </c:forEach>
                
           
                </div>