<p class="lead">Shop Name</p>
                <div class="list-group">
                
                <c:forEach items="${categories}" var="cat">
                
                 <a href="#" class="list-group-item">${cat.name } </a>
                
                </c:forEach>
                
           
                </div>