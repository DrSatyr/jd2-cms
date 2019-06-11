<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Content</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/content" method="get">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="tag">Tags</label>
                    <select class="form-control" id="tag" name="tag">
                        <option>testTagEn1</option>
                        <option>testTagRu1</option>
                        <option>testTagBy1</option>
                        <option>testTagEn2</option>
                        <option>testTagRu2</option>
                        <option>testTagBy2</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="title">Filter by title</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="Title">
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="createdBy">User</label>
                    <select class="form-control" name="createdBy" id="createdBy">
                        <option>editor</option>
                        <option>user</option>
                        <option>administrator</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="active" name="active">
                    <label class="form-check-label" for="active">Only published</label>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="limit">Items per page</label>
                    <select class="form-control" id="limit">
                        <option>10</option>
                        <option>20</option>
                        <option>50</option>
                    </select>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <div id="content" class="container">

    </div>
    <div class="container">
        <nav aria-label="...">
            <ul class="pagination">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item active" aria-current="page">
                    <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                </li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
