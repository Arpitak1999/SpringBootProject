<%@  include file="common/header.jspf" %>
<%@  include file="common/navigation.jspf" %>
<div class="container">

    <H1>Todos List are </H1>
    <table class="table">
        <thead>
            <tr>

                <th>description</th>
                <th>Target date</th>
                <th>Is done</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items ="${todos}" var="todo">
                <tr>

                    <td>${todo.description}</td>
                    <td>${todo.date}</td>
                    <td>${todo.done}</td>
                    <td> <a href ="delete-todos?id=${todo.id}" class= "btn btn-warning">Delete </a></td>
                    <td> <a href ="update-todos?id=${todo.id}" class= "btn btn-success">Update </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href ="add-todos" class= "btn btn-success">Add Todo</a>
</div>
<%@  include file="common/footer.jspf" %>