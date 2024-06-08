<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
<form action="create" method="post">
  <h4>${message}</h4>
  <div>
    <label for="login"><h3>Enter login:</h3></label>
    <input name="login" type="text" id="login" value="" />
  </div>
  <div>
    <label for="name"><h3>Enter name:</h3></label>
    <input name="name" type="text" id="name" value="" />
  </div>
  <div>
    <label for="surname"><h3>Enter surname:</h3></label>
    <input name="surname" type="text" id="surname" value="" />
  </div>
  <div>
    <label for="age"><h3>Enter age:</h3></label>
    <input name="age" type="number" id="age" value="" />
  </div>
  <div>
    <button>Send</button>
  </div>
</form>
</body>
</html>