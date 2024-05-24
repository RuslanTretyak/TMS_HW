<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>

    <body>
        <div class="container-fluid; border rounded-4" style="width: 640px; margin: 20px; padding: 10px">
            <div class="row">
                <div class="col d-flex justify-content-center">
                    <form action="save-request" method="post">
                        <c:if test="${isNameCorrect}">
                            <div class="form-floating mb-3">
                                <input name="name" type="text" class="form-control" id="floatingInput" placeholder="">
                                <label for="floatingInput">${nameLine}</label>
                            </div>
                        </c:if>
                        <c:if test="${!isNameCorrect}">
                            <div class="form-floating mb-3">
                                <input name="name" type="text" class="form-control is-invalid" id="floatingInputInvalid"
                                    placeholder="">
                                <label for="floatingInputInvalid">${nameLine}</label>
                            </div>
                        </c:if>
                        <c:if test="${isSurnameCorrect}">
                            <div class="form-floating mb-3">
                                <input name="surname" type="text" class="form-control" id="floatingInput"
                                    placeholder="">
                                <label for="floatingInput">${surnameLine}</label>
                            </div>
                        </c:if>
                        <c:if test="${!isSurnameCorrect}">
                            <div class="form-floating mb-3">
                                <input name="surname" type="text" class="form-control is-invalid"
                                    id="floatingInputInvalid" placeholder="">
                                <label for="floatingInputInvalid">${surnameLine}</label>
                            </div>
                        </c:if>
                        <c:if test="${isAgeCorrect}">
                            <div class="form-floating mb-3">
                                <input name="age" type="number" class="form-control" id="floatingInput" placeholder="">
                                <label for="floatingInput">${ageLine}</label>
                            </div>
                        </c:if>
                        <c:if test="${!isAgeCorrect}">
                            <div class="form-floating mb-3">
                                <input name="age" type="number" class="form-control is-invalid"
                                    id="floatingInputInvalid" placeholder="">
                                <label for="floatingInputInvalid">${ageLine}</label>
                            </div>
                        </c:if>
                        <c:if test="${isEmailCorrect}">
                            <div class="form-floating mb-3">
                                <input name="email" type="email" class="form-control" id="floatingInput" placeholder="">
                                <label for="floatingInput">${emailLine}</label>
                            </div>
                        </c:if>
                        <c:if test="${!isEmailCorrect}">
                            <div class="form-floating mb-3">
                                <input name="email" type="email" class="form-control is-invalid"
                                    id="floatingInputInvalid" placeholder="">
                                <label for="floatingInputInvalid">${emailLine}</label>
                            </div>
                        </c:if>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    </body>

    </html>